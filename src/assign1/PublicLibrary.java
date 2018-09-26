//StudentID : 991496627, Student Name : Yena Park

package assign1;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import assign1.DAO.BookDAO;
import assign1.DAO.BranchDAO;
import assign1.DAO.LibraryDAO;
import assign1.model.Book;
import assign1.model.Branch;
import assign1.model.Library;

public class PublicLibrary {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true) {
			showMenu();
		}
	}
	
	public static void showMenu() {
		System.out.println("=====================================Menu=====================================");
		System.out.println("Option selection: 1. Book / 2. Branch / 3. Library / 4. Fine Amount / 5. Quit(exit the program)");
		Scanner input = new Scanner(System.in);
		System.out.print("Input number: ");
		String selectedOption = input.next();
		
		if(selectedOption.equals("5")) {
			System.exit(0);
		} else if(selectedOption.equals("1")) {
			showBookOptions(input);
		} else if(selectedOption.equals("2")) {
			showBranchOptions(input);
		} else if(selectedOption.equals("3")) {
			showLibraryOptions(input);
		} else if(selectedOption.equals("4")) {
			showFineAmount(input);
		}
	}
	
	public static void showFineAmount(Scanner input) {
		LibraryDAO libraryDAO = new LibraryDAO();
		List<HashMap<String, Number>> results = libraryDAO.getCalculatedFineAmount();
		System.out.println("===============================================");
		System.out.println("Total Fine Amount");
		System.out.println("===============================================");
		System.out.println("Book Code \t Branch Code \t Total Fine Amount");
		for(int i = 0; i < results.size(); i++) {
			System.out.print(results.get(i).get("bookCode") + " \t\t\t");
			System.out.print(results.get(i).get("branchCode") + " \t\t\t");
			System.out.println(results.get(i).get("totalFineAmount"));
		}
	}

	public static void showBookOptions(Scanner input) {
		System.out.println("Option selection: 1. Add / 2. Update / 3. Delete / 4. Search / 5. List / 6. All Books which are not borrowed in Beaches Branch");
		System.out.println("\t\t7. technology Books available in Each Branch");
		System.out.print("Input number: ");
		String bookOptions = input.next();

		BookDAO bookDAO = new BookDAO();
		List<Book> books;
		switch(bookOptions) {
		case "1": //add
			System.out.println("Insert Book Code: ");
			int bookCode = input.nextInt();
			System.out.println("Insert Title: ");
			String title = input.next();
			System.out.println("Insert Author: ");
			String author = input.next();
			System.out.println("Insert price: ");
			double price = input.nextDouble();
			System.out.println("Insert Type: ");
			String type = input.next();
			System.out.println("Insert Subject: ");
			String subject = input.next();
			int addedRow = bookDAO.addBookRow(bookCode, title, author, price, type, subject);
			System.out.println(addedRow + " row added");
			break;
		case "2": //update
			showUpdateBookMenu(bookDAO, input);
			break;
		case "3": //delete
			System.out.println("Insert Book Code to remove : ");
			bookCode = input.nextInt();
			
			// TOOD: delete library delete
			
			
			int deletedRow = bookDAO.deleteBookRow(bookCode);
			System.out.println(deletedRow + " row removed");
			break;
			
		case "4": //search
			System.out.println("1: Search By Title \t\t 2. Search By Author");
			System.out.println("Select :");
			int searchMenuNumber = input.nextInt();
			
			switch(searchMenuNumber) {
			case 1:
				System.out.println("Input Search Keyword :");
				String searchInput = input.next();
				books = bookDAO.getBooksByTitle(searchInput);
				System.out.println("=======================");
				System.out.println(searchInput + " Results");
				System.out.println("=======================");
				printBooks(books);
				break;
				
			case 2:
				System.out.println("Input Search Keyword :");
				searchInput = input.next();
				books = bookDAO.getBooksByAuthor(searchInput);
				System.out.println("=======================");
				System.out.println(searchInput + " Results");
				System.out.println("=======================");
				printBooks(books);
				break;
				
			default:
				break;
			}
			break;
		case "5": //list
			books = bookDAO.getAllBooks();
			printBooks(books);
			break;
		case "6":
			books = bookDAO.getAvaliableBooksWithBranchName("Beaches");
			System.out.println("=======================");
			System.out.println("Books in Beaches Branch");
			System.out.println("=======================");
			printBooks(books);
			break;
		case "7":
			List<HashMap<String, Integer>> results = bookDAO.getNumberOfAvailaibleBooksWithType("Technology");
			System.out.println("===============================================");
			System.out.println("Technology Total Books available in Each Branch");
			System.out.println("===============================================");
			System.out.println("branch code \t total books");
			
			for(int i = 0; i < results.size(); i++) {
				System.out.print(results.get(i).get("branchcode") + " \t\t\t");
				System.out.println(results.get(i).get("count"));
			}
			break;
		default:
			break;
		}
	}
	
	public static void printBooks(List<Book> books) {
		System.out.println("Book Code\tTitle\tAuthor\tPrice\tType\tSubject");
		for(int i = 0; i < books.size(); i++) {
			System.out.print(books.get(i).getBookCode());
			System.out.print("\t" + books.get(i).getTitle());
			System.out.print("\t" + books.get(i).getAuthor());
			System.out.print("\t" + books.get(i).getPrice());
			System.out.print("\t" + books.get(i).getType());
			System.out.println("\t" + books.get(i).getSubject());
		}
	}
	
	public static void showBranchOptions(Scanner input) {
		System.out.println("Option selection: 1. Add / 2. Update / 3. Delete / 4. Search / 5. List ");
		System.out.print("Input number: ");
		String branchOptions = input.next();
	
		BranchDAO branchDAO = new BranchDAO();
		List<Branch> branches;
		switch(branchOptions) {
		case "1": //add
			System.out.println("====Add Branch Row===");
			System.out.println("Enter Branch Code: ");
			int branchCode = input.nextInt();
			System.out.println("Enter Branch Name: ");
			String branchName = input.next();
			System.out.println("Enter Address: ");
			String address = input.next();
			System.out.println("Enter Postal Code: ");
			String postalCode= input.next();
			int row = branchDAO.addBranchRow(branchCode, branchName, address, postalCode);
			System.out.println(row + " row added");
			break;
		case "2": //update
			showUpdateBranchMenu(branchDAO, input);
			break;
		case "3": //delete
			System.out.println("Enter Branch Code: ");
			branchCode = input.nextInt();
			branchDAO.deleteBranchRow(branchCode);
			break;
		case "4": //Search
			System.out.println("1: Search By Branch Name \t\t 2. Search By Postal Code");
			System.out.println("Select :");
			int searchMenuNumber = input.nextInt();
			
			switch(searchMenuNumber) {
			case 1:
				System.out.println("Input Search Keyword :");
				String searchInput = input.next();
				branches = branchDAO.getBranchesByBranchName(searchInput);
				System.out.println("=======================");
				System.out.println(searchInput + " Results");
				System.out.println("=======================");
				printBranches(branches);
				break;
				
			case 2:
				System.out.println("Input Search Keyword :");
				searchInput = input.next();
				branches = branchDAO.getBranchesByPostalCode(searchInput);
				System.out.println("=======================");
				System.out.println(searchInput + " Results");
				System.out.println("=======================");
				printBranches(branches);
				break;
				
			default:
				break;
			}
			break;
		case "5": //List
			branches = branchDAO.getAllBranches();
			printBranches(branches);
			break;
		default:
			break;
		}
	}
	
	public static void printBranches(List<Branch> branches) {
		System.out.println("Branch Code\tBranch Name\tAddress\tPostal Code");
		Branch branch;
		for(int i=0; i < branches.size(); i++) {
			branch = branches.get(i);
			System.out.print(branch.getBranchCode());
			System.out.print("\t" + branch.getBranchName());
			System.out.print("\t" + branch.getAddress());
			System.out.println("\t\t" + branch.getPstalCode());
		}
	}
	
	public static void showLibraryOptions(Scanner input) {
		System.out.println("Option selection: 1. Add / 2. Update / 3. Delete / 4. Fine Amount / 5. List ");
		System.out.print("Input number: ");
		String libraryOptions = input.next();
	
		LibraryDAO libraryDAO = new LibraryDAO();
		List<Library> libraries;
		Library library;
		switch(libraryOptions) {
		case "1": //add
			System.out.println("====Add Library Row===");
			System.out.println("Enter Book Code: ");
			int bookCode = input.nextInt();
			System.out.println("Enter Branch Code: ");
			int branchCode = input.nextInt();
			System.out.println("Enter Borrow Date(ex: 2014-01-28): ");
			String borrowdate = input.next();
			System.out.println("Enter Return Date(ex: 2014-01-28): ");
			String returndate= input.next();
			System.out.println("Enter Fine Amount: ");
			double fineamount= input.nextDouble();
			
			int row = libraryDAO.addLibraryRow(bookCode, branchCode, borrowdate, returndate, fineamount);
			System.out.println(row + " row added");
			break;
		case "2": //update
			showUpdateLibraryMenu(libraryDAO, input);
			break;
		case "3": //delete
			libraries = libraryDAO.getAllLibraries();
			printLibraries(libraries);
			System.out.println("Insert Book Code to remove : ");
			bookCode = input.nextInt();
			System.out.println("Insert Branch Code to remove : ");
			branchCode = input.nextInt();
			
			int deletedRow = libraryDAO.deleteLibraryRowByBookCodeBranchCode(bookCode, branchCode);
			System.out.println(deletedRow + " row removed");
			break;
			
		case "4": //fine amount
			libraries = libraryDAO.getFineAmounts();
			System.out.println("Branch Code\tSum(Fine Amount)");
			
			for(int i=0; i<libraries.size(); i++) {
				library = libraries.get(i);
				System.out.print(library.getBranchCode());
				System.out.println("\t\t" + library.getFineAmount());
			}
			break;
		case "5": //list
			libraries = libraryDAO.getAllLibraries();
			printLibraries(libraries);
			break;
		default:
			break;
		}
	}
	
	public static void printLibraries(List<Library> libraries) {
		System.out.println("Book Code\tBranch Code\tBorrow Date\tReturn Date\tFine Amount");
		Library library;
		for(int i=0; i<libraries.size(); i++) {
			library = libraries.get(i);
			System.out.print(library.getBookCode());
			System.out.print("\t\t" + library.getBranchCode());
			System.out.print("\t\t" + library.getBorrowDate());
			System.out.print("\t\t" + library.getReturnDate());
			System.out.println("\t\t" + library.getFineAmount());
		}
	}
	public static void showUpdateLibraryMenu(LibraryDAO libraryDAO, Scanner input) {
		List<Library> libraries = libraryDAO.getAllLibraries();
		printLibraries(libraries);
		System.out.print("======================================================================\n");
		System.out.print("Input Book Code: ");
		int bookCode = input.nextInt();
		System.out.print("Input Branch Code: ");
		int branchCode = input.nextInt();
		System.out.println("1: Borrow Date(YYYY-MM-DD) \t\t 2: Return Date(YYYY-MM-DD) \t\t 3:Fine Amount");
		System.out.println("Select: ");
		int menuNumber = input.nextInt();
		switch(menuNumber) {
		case 1:
			System.out.println("Input Borrow Date(YYYY-MM-DD): ");
			String borrowDate = input.next();
			int result = libraryDAO.updateLibraryBorrowDate(bookCode, branchCode, borrowDate);
			System.out.println(result + " row(s) updated");
			break;
		case 2:
			System.out.println("Input Return Date(YYYY-MM-DD): ");
			String returnDate = input.next();
			result = libraryDAO.updateLibraryReturnDate(bookCode, branchCode, returnDate);
			System.out.println(result + " row(s) updated");
			break;
		case 3:
			System.out.println("Input Fine Amount: ");
			double fineAmount = input.nextDouble();
			result = libraryDAO.updateLibraryFineAmount(bookCode, branchCode, fineAmount);
			System.out.println(result + " row(s) updated");
			break;
			
		default:
			break;
		}
	}
	
	public static void showUpdateBookMenu(BookDAO bookDAO, Scanner input) {
		System.out.println("1: price \t\t 2: type \t\t 3:subject");
		System.out.print("Select Menu: ");
		int menuNumber = input.nextInt();
		switch(menuNumber) {
		case 1:
			System.out.println("Input Book Code: ");
			int bookcode = input.nextInt();
			System.out.println("Input Price: ");
			double price = input.nextDouble();
			int updatedRow = bookDAO.updateBookPrice(bookcode, price);
			System.out.println(updatedRow + " row updated");
			break;
		case 2:
			System.out.println("Input Book Code: ");
			bookcode = input.nextInt();
			System.out.println("Input Type: ");
			String type = input.next();
			updatedRow = bookDAO.updateBookType(bookcode, type);
			System.out.println(updatedRow + " row updated");
			break;
		case 3:
			System.out.println("Input Book Code: ");
			bookcode = input.nextInt();
			System.out.println("Input Subject: ");
			String subject = input.next();
			updatedRow = bookDAO.updateBookSubject(bookcode, subject);
			System.out.println(updatedRow + " row updated");
			break;
		}
	}
	
	public static void showUpdateBranchMenu(BranchDAO branchDAO, Scanner input) {
		List<Branch> branches = branchDAO.getAllBranches();
		printBranches(branches);
		System.out.println("Enter Branch Code to Update: ");
		int branchCode = input.nextInt();
		System.out.println("1: Branch name\t2: Address\t3:Postal Code");
		System.out.print("Input: ");
		int menuNumber = input.nextInt();
		switch(menuNumber) {
		case 1:
			System.out.println("Input New Branch Name: ");
			String branchName = input.next();
			int updatedRow = branchDAO.updateBranchName(branchCode, branchName);
			System.out.println(updatedRow + " row updated");
			break;
		case 2:
			System.out.println("Input New Branch Address: ");
			String address = input.next();
			updatedRow = branchDAO.updateBranchAddress(branchCode, address);
			System.out.println(updatedRow + " row updated");
			break;
		case 3:
			System.out.println("Input New Branch Postal Code(6 Characters): ");
			String postalCode = input.next();
			updatedRow = branchDAO.updateBranchPostalCode(branchCode, postalCode);
			System.out.println(updatedRow + " row updated");
			break;
		}
	}
}

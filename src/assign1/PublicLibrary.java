//StudentID : 991496627, Student Name : Yena Park

package assign1;

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
		System.out.println("Option selection: 1. Book / 2. Branch / 3. Library / 4. Quit(exit the program)");
		Scanner input = new Scanner(System.in);
		System.out.print("Input number: ");
		String selectedOption = input.next();
		
		if(selectedOption.equals("4")) {
			System.exit(0);
		} else if(selectedOption.equals("1")) {
			showBookOptions(input);
		} else if(selectedOption.equals("2")) {
			showBranchOptions(input);
		} else if(selectedOption.equals("3")) {
			showLibraryOptions(input);
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
			System.out.println("Insert Bookcode, Title, Author, Price, Type and Subject");
			break;
		case "2": //update
			break;
		case "3": //delete
			break;
		case "4": //search
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
		switch(branchOptions) {
		case "1": //add
			//BranchDAO.addBranchRow();
			break;
		case "2": //update
			//BranchDAO.updateBranchRow();
			break;
		case "3": //delete
			//BranchDAO.deleteBranchRow();
			break;
		case "4": //Search
			//BranchDAO.deleteBranchRow();
			break;
		case "5": //List
			List<Branch> branches = branchDAO.getAllBranches();
			System.out.println("Branch Code\tBranch Name\tAddress\tPostal Code");
			Branch branch;
			for(int i=0; i < branches.size(); i++) {
				branch = branches.get(i);
				System.out.print(branch.getBranchCode());
				System.out.print("\t" + branch.getBranchName());
				System.out.print("\t" + branch.getAddress());
				System.out.println("\t\t" + branch.getPstalCode());
			}
			
			break;
		default:
			break;
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
			//LibraryDAO.addLibraryRow();
			break;
		case "2": //update
			//LibraryDAO.updateLibraryRow();
			break;
		case "3": //delete
			//LibraryDAO.deleteLibraryRow();
			break;
		case "4": //fine amount
			//TODO: 
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
			System.out.println("Book Code\tBranch Code\tBorrow Date\tReturn Date\tFine Amount");
			
			for(int i=0; i<libraries.size(); i++) {
				library = libraries.get(i);
				System.out.print(library.getBookCode());
				System.out.print("\t\t" + library.getBranchCode());
				System.out.print("\t\t" + library.getBorrowDate());
				System.out.print("\t\t" + library.getReturnDate());
				System.out.println("\t\t" + library.getFineAmount());
			}
			break;
		default:
			break;
		}
	}
}

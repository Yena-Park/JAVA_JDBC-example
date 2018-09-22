//StudentID : 991496627, Student Name : Yena Park

package assign1;

import java.util.Scanner;
import assign1.DAO.*;

public class PublicLibrary {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			showMenu();
		}
	}
	
	private static void showMenu() {
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
		System.out.println("Option selection: 1. Add / 2. Update / 3. Delete / 4. Search / 5. List");
		System.out.print("Input number: ");
		String bookOptions = input.next();
		
		switch(bookOptions) {
		case "1": //add
			System.out.println("Insert Bookcode, Title, Author, Price, Type and Subject");
			String addBook = input.next();
			//BookDAO.addBookRow();
			break;
		case "2": //update
			BookDAO.updateBookRow();
			break;
		case "3": //delete
			BookDAO.deleteBookRow();
			break;
		case "4": //search
			BookDAO.searchBookRow();
			break;
		case "5": //list
			BookDAO.listBookRow();
			break;
		default:
			break;
		}
	}
	
	public static void showBranchOptions(Scanner input) {
		System.out.println("Option selection: 1. Add / 2. Update / 3. Delete / 4. Search ");
		System.out.print("Input number: ");
		String branchOptions = input.next();
	
		switch(branchOptions) {
		case "1": //add
			BranchDAO.addBranchRow();
			break;
		case "2": //update
			BranchDAO.updateBranchRow();
			break;
		case "3": //delete
			BranchDAO.deleteBranchRow();
			break;
		default:
			break;
		}
	}
	
	public static void showLibraryOptions(Scanner input) {
		System.out.println("Option selection: 1. Add / 2. Update / 3. Delete / 4. Search ");
		System.out.print("Input number: ");
		String libraryOptions = input.next();
	
		switch(libraryOptions) {
		case "1": //add
			LibraryDAO.addLibraryRow();
			break;
		case "2": //update
			LibraryDAO.updateLibraryRow();
			break;
		case "3": //delete
			LibraryDAO.deleteLibraryRow();
			break;
		case "4": //fine amount
			LibraryDAO.fineAmountLibraryRow();
			break;
		default:
			break;
		}
	}
}

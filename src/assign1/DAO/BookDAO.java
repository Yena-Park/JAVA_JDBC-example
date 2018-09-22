//StudentID : 991496627, Student Name : Yena Park

package assign1.DAO;
import java.sql.*;

public class BookDAO {
	Connection con = null;
	PreparedStatement pst;
	
	public static void addBookRow(int bookcode, String title, String author, double price, String type, String subject) throws Exception{
		String insertQuery = "Insert into car (BOOKCODE, TITLE, AUTHOR, PRICE, TYPE, SUBJECT) values (?, ?, ?, ?, ?, ?)";
	}
	
	public static void updateBookRow() {
		
	}
	
	public static void deleteBookRow() {
		
	}

	public static void searchBookRow() {
		
	}

	public static void listBookRow() {

	}
}

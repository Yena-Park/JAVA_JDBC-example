//StudentID : 991496627, Student Name : Yena Park

package assign1.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import assign1.DBConnector;
import assign1.model.Book;

public class BookDAO {
	Connection con = null;
	PreparedStatement pst;
	
	public static void addBookRow(int bookcode, String title, String author, double price, String type, String subject) throws Exception{
//		String insertQuery = "Insert into car (BOOKCODE, TITLE, AUTHOR, PRICE, TYPE, SUBJECT) values (?, ?, ?, ?, ?, ?)";
	}
	
	public void updateBookRow() {
		
	}
	
	public void deleteBookRow() {
		
	}

	public void searchBookRow() {
		
	}

	public List<Book> getAllBooks() {
		String query = "select * from books";
		List<Book> books = new ArrayList<Book>();
		
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//				System.out.println(rs.getDouble(4));
//				System.out.println(rs.getString(5));
//				System.out.println(rs.getString(6));
				Book book = new Book(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getDouble(4),
					rs.getString(5),
					rs.getString(6)
				);
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	public List<Book> getAvaliableBooksWithBranchName(String branchName) {
		String query = "select * "
				+ "from books, library "
				+ "where books.bookcode = library.bookcode "
				+ "and library.branchcode in "
				+ "(select library.branchcode from branch, library "
				+ "where branch.branchcode = library.branchcode "
				+ "and branch.branchname = '"+ branchName + "')";
		
		List<Book> books = new ArrayList<Book>();
		
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Book book = new Book(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getDouble(4),
					rs.getString(5),
					rs.getString(6)
				);
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	public List<HashMap<String, Integer>> getNumberOfAvailaibleBooksWithType(String type) {
		String query = "select branchcode, count(bookcode)"
				+ " from library "
				+ "where (returndate is not null OR borrowdate is null)"
				+"and bookcode in "
				+ "(select bookcode from books where type = '" + type + "')"
				+ " group by branchcode";
		List<HashMap<String, Integer>> results = new ArrayList<HashMap<String, Integer>>();
		
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				map.put("branchcode", rs.getInt(1));
				map.put("count", rs.getInt(2));
					
				results.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return results;
	}
}

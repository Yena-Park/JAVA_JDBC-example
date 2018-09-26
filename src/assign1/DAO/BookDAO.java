//StudentID : 991496627, Student Name : Yena Park

package assign1.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import assign1.DBConnector;
import assign1.model.Book;

public class BookDAO {
	static Connection con = null;
	static PreparedStatement pst;
	
	//update information of book
	public int updateBookPrice(int bookcode, double price) {
		String query = "UPDATE books SET price = ? where bookcode = ?";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setDouble(1, price);
			pst.setInt(2, bookcode);
			result = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateBookType(int bookcode, String type) {
		String query = "UPDATE books SET type = ? where bookcode = ?";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, type);
			pst.setInt(2, bookcode);
			result = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateBookSubject(int bookcode, String subject) {
		String query = "UPDATE books SET subject = ? where bookcode = ?";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, subject);
			pst.setInt(2, bookcode);
			result = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteBookRow(int bookcode) {
		String query = "DELETE from books WHERE bookcode = ?";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, bookcode);
			result = pst.executeUpdate();
	    		pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int addBookRow(int bookCode, String title, String author, double price, String type, String subject) {
		String query = "INSERT INTO BOOKS (BOOKCODE, TITLE, AUTHOR, PRICE, TYPE, SUBJECT)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, bookCode);
			pst.setString(2, title);
			pst.setString(3, author);
			pst.setDouble(4, price);
			pst.setString(5, type);
			pst.setString(6, subject);
			result = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Book> getBooksByTitle(String title) {
		String query = "select * from books where title like ?";
		List<Book> books = new ArrayList<Book>();
		
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, "%"+title+"%");
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
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return books;
	}
	public List<Book> getBooksByAuthor(String author) {
		String query = "select * from books where author like ?";
		List<Book> books = new ArrayList<Book>();
		
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, "%"+author+"%");
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
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return books;
	}
	

	//show all information of book
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
			pst.close();
			con.close();
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
			pst.close();
			con.close();
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
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return results;
	}
}

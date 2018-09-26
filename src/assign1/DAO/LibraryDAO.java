//StudentID : 991496627, Student Name : Yena Park

package assign1.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import assign1.DBConnector;
import assign1.model.Library;

public class LibraryDAO {
	Connection con = null;
	PreparedStatement pst;
	
	//add information of library
	public int addLibraryRow(int bookcode, int branchcode, String borrowdate, String returndate, double fineamount) {
		
		String query = "INSERT INTO library "
				+ "(bookcode, branchcode, borrowdate, returndate, fineamount) "
				+ "VALUE (?,?,?,?,?)";
		int row = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, bookcode);
			pst.setInt(2, branchcode);
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(borrowdate);
			Date convertedSqlDate = new Date(utilDate.getTime()); 
			pst.setDate(3, convertedSqlDate);
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(returndate);
			convertedSqlDate = new Date(utilDate.getTime()); 
			pst.setDate(4, convertedSqlDate);
			pst.setDouble(5, fineamount);
			row = pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public int deleteLibraryRowByBookCode(int bookcode) {
		String query = "DELETE from library WHERE bookcode = ?";
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
	
	public int deleteLibraryRowByBookCodeBranchCode(int bookCode, int branchCode) {
		String query = "DELETE from library WHERE bookcode = ? and branchcode = ?";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, bookCode);
			pst.setInt(2, branchCode);
			result = pst.executeUpdate();
	    		pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteLibraryRowByBranchCode(int branchcode) {
		String query = "DELETE from library WHERE branchcode = ?";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, branchcode);
			result = pst.executeUpdate();
	    		pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//update information of library
	public int updateLibraryBorrowDate(int bookCode, int branchCode, String borrowDate) {
		String query = "UPDATE library SET borrowdate = ? where bookcode = ? and branchcode = ?";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(borrowDate);
			Date convertedSqlDate = new Date(utilDate.getTime()); 
			pst.setDate(1, convertedSqlDate);
			pst.setInt(2, bookCode);
			pst.setInt(3, branchCode);
			result = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateLibraryReturnDate(int bookCode, int branchCode, String returnDate) {
		String query = "UPDATE library SET returndate = ? where bookcode = ? and branchcode = ?";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(returnDate);
			Date convertedSqlDate = new Date(utilDate.getTime()); 
			pst.setDate(1, convertedSqlDate);
			pst.setInt(2, bookCode);
			pst.setInt(3, branchCode);
			result = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateLibraryFineAmount(int bookCode, int branchCode, Double fineAmount) {
		String query = "UPDATE library SET fineamount = ? where bookcode = ? and branchcode = ?";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query); 
			pst.setDouble(1, fineAmount);
			pst.setInt(2, bookCode);
			pst.setInt(3, branchCode);
			result = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//show all information of library
	public List<Library> getAllLibraries() {
		String query = "select * from library";
		List<Library> libraries = new ArrayList<Library>();

		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Library library = new Library(
					rs.getInt(1),
					rs.getInt(2),
					rs.getDate(3),
					rs.getDate(4),
					rs.getDouble(5)
				);
				libraries.add(library);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libraries;
	}
	
	public List<Library> getFineAmounts() {
//		String query = "select library.branchcode, branch.branchname, sum(library.fineamount) "
//				+ "from branch, library where branch.branchcode = library.branchcode "
//				+ "group by library.branchcode";
		String query = "select branchcode, sum(fineamount) from library group by branchcode";
		List<Library> libraries = new ArrayList<Library>();
		
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Library library = new Library(
					rs.getInt(1),
					rs.getDouble(2)					
				);
				libraries.add(library);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libraries;
	}
	
	public List<HashMap<String, Number>> getCalculatedFineAmount() {
		String query = "select *, (returndate - borrowdate - 21) "
				+ "from library where (returndate - borrowdate > 21)";
		List<HashMap<String, Number>> results = new ArrayList<HashMap<String, Number>>();
		
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				HashMap<String, Number> map = new HashMap<String, Number>();
				map.put("bookCode", rs.getInt(1));
				map.put("branchCode", rs.getInt(2));
				double fineAmount = rs.getDouble(5);
				if (fineAmount == 0) {
					map.put("totalFineAmount", rs.getInt(6) * 0.5);
				} else {
					map.put("totalFineAmount", rs.getInt(6) * fineAmount);	
				}
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

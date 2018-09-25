//StudentID : 991496627, Student Name : Yena Park

package assign1.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assign1.DBConnector;
import assign1.model.Library;

public class LibraryDAO {
	Connection con = null;
	PreparedStatement pst;
	
	public void addLibraryRow() {
		
	}
	
	public void updateLibraryRow() {
		
	}
	
	public void deleteLibraryRow() {
			
	}
	
	public void fineAmountLibraryRow() {
		
	}
	
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
//		String query = "select library.branchcode, branch.branchname, sum(library.fineamout) "
//				+ "from branch, library where branch.branchcode = library.branchcode "
//				+ "group by library.branchcode";
		String query = "select branchcode, sum(fineamout) from library group by branchcode";
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
}

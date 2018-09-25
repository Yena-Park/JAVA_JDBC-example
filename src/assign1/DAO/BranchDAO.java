//StudentID : 991496627, Student Name : Yena Park

package assign1.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assign1.DBConnector;
import assign1.model.Branch;

public class BranchDAO {
	Connection con = null;
	PreparedStatement pst;
	
	public void addBranchRow() {
		
	}
	
	public void updateBranchRow() {
		
	}
	
	public void deleteBranchRow() {
		
	}
	
	public void searchBranchRow() {
		
	}

	public List<Branch> getAllBranches() {
		String query = "select * from branch";
		List<Branch> branches = new ArrayList<Branch>();
		
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Branch branch = new Branch(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4)
				);
				branches.add(branch);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return branches;
	}
}

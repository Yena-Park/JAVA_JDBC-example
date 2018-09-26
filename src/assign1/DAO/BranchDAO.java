//StudentID : 991496627, Student Name : Yena Park

package assign1.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assign1.DBConnector;
import assign1.model.Book;
import assign1.model.Branch;

public class BranchDAO {
	static Connection con = null;
	static PreparedStatement pst;
	
	public int addBranchRow(int branchCode, String branchName, String address, String postalCode) {
		String query = "INSERT INTO branch (branchcode, branchname, address, postalcode) VALUE (?, ?, ?, ?)";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			
			pst.setInt(1, branchCode);
			pst.setString(2, branchName);
			pst.setString(3, address);
			pst.setString(4, postalCode);
			result = pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateBranchName(int branchCode, String branchName) {
		String query = "UPDATE branch SET branchname = ? where branchcode = ?";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, branchName);
			pst.setInt(2, branchCode);
			result = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int updateBranchAddress(int branchCode, String address) {
		String query = "UPDATE branch SET address = ? where branchcode = ?";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, address);
			pst.setInt(2, branchCode);
			result = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int updateBranchPostalCode(int branchCode, String postalCode) {
		String query = "UPDATE branch SET postalcode = ? where branchcode = ?";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, postalCode);
			pst.setInt(2, branchCode);
			result = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//delete information of branch
	public int deleteBranchRow(int branchCode) {
		String deleteQuery = "DELETE from branch WHERE branchcode = ?";
		int result = -1;
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, branchCode);
			result = pst.executeUpdate();
	    		pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Branch> getBranchesByBranchName(String branchName) {
		String query = "select * from branch where branchname like ?";
		List<Branch> branches = new ArrayList<Branch>();
		
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, "%"+branchName+"%");
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
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return branches;
	}
	public List<Branch> getBranchesByPostalCode(String postalCode) {
		String query = "select * from branch where postalcode like ?";
		List<Branch> branches = new ArrayList<Branch>();
		
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, "%"+postalCode+"%");
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
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return branches;
	}
	
	
	//show all information of branch
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
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return branches;
	}
}

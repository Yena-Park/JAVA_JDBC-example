//StudentID : 991496627, Student Name : Yena Park

package assign1;

import java.sql.*;

public class DBConnector {
	
	private static final String url="jdbc:mysql://localhost:3306/PUBLICLIBRARY";
    private static final String DriverClass="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String password="rootroot";

    private DBConnector() {
    		try {
    			Class.forName(DriverClass);
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}
    }
    
    public static Connection getConnection() throws Exception {
    		Connection connection = null;
    		try {
    			connection = DriverManager.getConnection(url, user, password);
    		} catch (SQLException e) {
    			System.out.println("Error: Connection failed" + e.getMessage());
    		}
    		return connection;
    }
    
    public static void closeConnection(Connection con, Statement st, ResultSet rs) throws Exception {
    		if(con!=null)
    			con.close();
    		if(st!=null)
    			st.close();
    		if(rs!=null)
    			rs.close();
    }
}

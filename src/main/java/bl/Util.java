package bl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Util {
	
	private static final String URL = "jdbc:postgresql://localhost:5430/test"; 
	private static final String LOGIN = "postgres";
	private static final String PASSWORD = "login456456";
	Logger logger = Logger.getLogger(Util.class);
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}

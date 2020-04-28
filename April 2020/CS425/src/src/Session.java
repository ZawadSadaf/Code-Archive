package src;

//Import For User Input
import java.util.Scanner;

//Import For JDBC Functionality
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Session {
	//Private Data Members
	//String Variables For Connecting To PostreSQL DB
	private String DBUrl = "jdbc:postgresql://localhost:5432/postgres";
	private String user = "postgres";
	private String pass = "password";
	
	//Other Variables
	private String userID;
	private Scanner sc = new Scanner(System.in);
	
	//Constructor
	Session() {
		System.out.println("PostgreSQL Database User Interface");
		testConnect();
		loginHandler();
	}
	
	//Private Methods
	//Login Handler To Take UserID and Return Privilege
	private void loginHandler() {
		System.out.print("Enter your userID: ");
		userID = sc.next();
		String q = "select privilege from login where userid = '" + userID + "'";
		query(q);
	}
	
	//Trivial Method To Test If Connected To The Database
	//TODO Create Global Connection Object and Private ClosingConnection Method
	//  ^^ Currently Multiple Local Connection Objects ^^
	private void testConnect() {
		System.out.println("Connecting...");
		Connection c = null;
		
		try {
			c = DriverManager.getConnection(DBUrl, user, pass);
			
			if(c != null) {
				System.out.println("Connection Verified");
				c.close();
			}
			
		} catch (SQLException e) { throw new Error("Connection Failed", e); }
	}
	
	//Public Methods
	//Method For Conducting DDL Commands
	public void update(String q) {
		System.out.println("Executing Query...");
		Connection c = null;
		
		try {
			c = DriverManager.getConnection(DBUrl, user, pass);
			Statement s = null;
			s = c.createStatement();
			
			if (s != null) {
			s.executeUpdate(q);
			System.out.println("Query Successful");
			c.close();
			s.close();
			}
		} catch (SQLException e) { throw new Error("Query Failed", e); }
	}
	
	//Method For Executing DQL Commands
	public void query(String q) {
		System.out.println("Searching Database...");
		Connection c = null;
		
		try {
			c = DriverManager.getConnection(DBUrl, user, pass);
			Statement s = null;
			
			s = c.createStatement();
			
			if (s != null) {
			ResultSet rs = s.executeQuery(q);
			System.out.print("Results: ");
			int k = 1;
			while(rs.next()) {
				System.out.println(rs.getString(k));
				k++;
			}
			c.close();
			s.close();
			}
		} catch (SQLException e) { throw new Error("Query Failed", e); }
	}
	
	public static void main(String[] args) { Session s = new Session(); }
}

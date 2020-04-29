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
	
	//Global Variables
	private Scanner sc = new Scanner(System.in);
	private String userID;
	private String privilege;
	
	//Constructor
	Session() {
		System.out.println("PostgreSQL Database User Interface");
		openConnect();
		loginHandler();
		//userMenu(); 
		}
	
	//Trivial Method To Test If Connected To The Database
	private void openConnect() {
		System.out.println("Connecting...");
		Connection c = null;
			
		try { 
			c = DriverManager.getConnection(DBUrl, user, pass);
			if(c != null) {
				System.out.println("Connection Verified");
				c.close(); }
		} catch (SQLException e) { throw new Error("Connection Failed", e); } }
		
	//Private Methods
	//Login Handler To Take UserID and Return Privilege
	private void loginHandler() {
		System.out.print("Enter your userID: ");
		userID = sc.next();
		String q = "select privilege from login where userid = '" + userID + "'";
		loginQuery(q); }
	
	//Special Query For loginHandler Method
	private String loginQuery(String q) {
		System.out.println("Searching Database...");
		Connection c = null;
		Statement s = null;
		
		try {
			c = DriverManager.getConnection(DBUrl, user, pass);
			s = c.createStatement();
			if (s != null) {
			ResultSet rs = s.executeQuery(q);
			rs.next();
			privilege = rs.getString(1);
			c.close();
			s.close(); }
		} catch (SQLException e) { throw new Error("Login Failed", e); }
		System.out.println("Login Successful");
		return privilege; }
	
	//userMenu Method For Picking Display To Show
	private void userMenu(String privilege) {
		switch(privilege) {
		case "admin":
			adminMenu();
			break;
		case "engineer":
			engineerMenu();
			break;
		case "sales":
			salesMenu();
			break;
		case "hr":
			hrMenu();
			break;
		default:
			System.out.print("System Error: You Have Been Logged Out");
			break;
		}
	}
	
	//Private Menu Child Methods
	private void adminMenu() {};
	private void engineerMenu() {};
	private void salesMenu() {};
	private void hrMenu() {};
	
	//Public Methods
	//Method For Conducting DDL Commands
	public void update(String q) {
		Connection c = null;
		Statement s = null;
		
		try {
			c = DriverManager.getConnection(DBUrl, user, pass);
			s = c.createStatement();
			if (s != null) {
				s.executeUpdate(q);
				s.close();
				c.close(); }
		} catch (SQLException e) { throw new Error("DDL Command Failed", e); } }
	
	//Method For Executing DQL Commands
	public void query(String q) {
		System.out.println("Searching Database...");
		Connection c = null;
		Statement s = null;
		
		try {
			c = DriverManager.getConnection(DBUrl, user, pass);
			s = c.createStatement();
			if (s != null) {
			ResultSet rs = s.executeQuery(q);
			System.out.print("Results: ");
			int k = 1;
			while(rs.next()) {
				System.out.println(rs.getString(k));
				k++; }
			c.close();
			s.close(); }
		} catch (SQLException e) { throw new Error("Query Failed", e); } }
	
	public static void main(String[] args) { Session s = new Session(); } }

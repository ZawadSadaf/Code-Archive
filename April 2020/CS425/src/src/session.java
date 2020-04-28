package src;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class session {
	//private member variables
	private String DBUrl;
	private String user;
	private String pass;
	
	session(String DBUrl, String user, String pass) {
		this.DBUrl = DBUrl;
		this.user = user;
		this.pass = pass;
		
		testConnect();
	}
	
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
	
	/** 
	 *  Public method used to conduct queries.
	 */
	public void query(String q) {
		System.out.println("Conducting Query...");
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
	
	//Cheat Sheet:
	//Database URl: jdbc:postgresql://localhost:5432/postgres
	//Username: postgres
	//Password: password
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean done = false; 
		
		System.out.println("SQL Database Interface\nEnter Database URL:\njdbc:postgresql://localhost:5432/postgres");
		//String DBUul = sc.next();
		String DBUrl = "jdbc:postgresql://localhost:5432/postgres";
		System.out.println("Enter Username:\npostgres");
		//String user = sc.next();
		String user = "postgres";
		System.out.println("Enter Password:\npassword");
		//String pass = sc.next();
		String pass = "password";
		
		session t = new session(DBUrl, user, pass);
		
		System.out.println("Enter Query or Type \"exit\" To Exit The Interface");
		while(!done) {
			String answer = sc.nextLine();
			
			if (answer.equals("exit")) done = true;
			else {
				String q = answer;
				t.query(q);
			}
		}
		
		System.out.println("You've Exited The Interface.");
		System.exit(0);
	}
}

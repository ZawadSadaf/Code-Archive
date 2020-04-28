package src;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Session {
	//private member variables
	private String DBUrl = "jdbc:postgresql://localhost:5432/postgres";
	private String user = "postgres";
	private String pass = "password";
	//private String userID;
	
	//Constructor
	/*
	Session(String userID) {
		this.userID = userID;
		testConnect();
	}
	*/
	Session() {
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
	
	public static void main(String[] args) {
		
		Session s = new Session();
		String q1 = "create table Order\r\n" + 
				"           	(orderNo varchar(6),\r\n" + 
				"           	saleNo int,\r\n" + 
				"           	modelName varchar(20),         	\r\n" + 
				"quantity int,\r\n" + 
				"employeeID varchar(6),\r\n" + 
				"           	primary key (orderNo),\r\n" + 
				"foreign key (employeeID) references (Employee),\r\n" + 
				"check (quantity>=0))";
	
		s.query(q1);
		
		/*
		Scanner sc = new Scanner(System.in);
		boolean done = false; 
		
		System.out.println("SQL Database Interface");
		System.out.println("Enter UserID");
		String id = sc.next();
		
		Session t = new Session(id);
		
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
		sc.close();
		*/
		System.exit(0);
	}
}

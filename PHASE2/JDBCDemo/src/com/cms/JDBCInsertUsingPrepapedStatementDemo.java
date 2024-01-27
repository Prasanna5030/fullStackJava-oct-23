package com.cms;

import java.sql.*;
import java.util.Scanner;

public class JDBCInsertUsingPrepapedStatementDemo {

	public JDBCInsertUsingPrepapedStatementDemo() {

	}

	public static void main(String[] args) {

		// Steps to connect to our MySQL database named CMS

		// STEP 1: Loading the JDBC Driver
		// STEP 2: Create a Connection
		// STEP 3: Create a PreparedStatement
		// STEP 4: Execute the PreparedStatement (excuteUpdate) and  
		// STEP 5: Display the inserted row count

		Connection connection = null;

		try {
			// Step-1
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "rootroot");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			//step-3 
			PreparedStatement pStmt = connection.prepareStatement(
					"INSERT INTO STUDENTS(student_id, first_name, last_name, date_of_birth, enrollment_date, session_name) VALUES(?,?,?,?,?,?)");
			
			
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.println("Id:");
				int id = sc.nextInt();
				System.out.println("first_name:");
				String first_name = sc.next();
				System.out.println("last_name:");
				String last_name = sc.next();
				System.out.println("date_of_birth");
				String date_of_birth = sc.next();
				System.out.println("enrollment_date:");
				String enrollment_date = sc.next();
				System.out.println("session_name:");
				String session_name = sc.next();

				//step-4 (set the positional parameters and execute the prep statement)
				pStmt.setInt(1, id);
				pStmt.setString(2, first_name);
				pStmt.setString(3, last_name);
				pStmt.setString(4, date_of_birth);
				pStmt.setString(5, enrollment_date);
				pStmt.setString(6, session_name);
				

				int noOfRowsInserted = pStmt.executeUpdate();
				pStmt.clearParameters();

				// step-5
				System.out.println("Inserted " + noOfRowsInserted + " row(s) successfully!");

				System.out.println("Insert another row?: Y / N :");
				String answer = sc.next();
				if (!answer.equalsIgnoreCase("Y"))
					break;
			}
			sc.close();		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

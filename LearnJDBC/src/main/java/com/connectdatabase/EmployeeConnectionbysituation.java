package com.connectdatabase;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.Scanner;

public class EmployeeConnectionbysituation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:postgresql://localhost:5432/College";
		String un = "postgres";
		String pwd = "root";
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("org.postgresql.Driver");
			
			
			Connection connect = DriverManager.getConnection(url,un,pwd);
			
			
//			Statement stmt = connect.createStatement();
//			String sql2 = "alter table employee add salary int";
//			
//			stmt.execute(sql2);
			
			String sql = "insert into employee values(?,?,?,?)";
			
			PreparedStatement pstm = connect.prepareStatement(sql);
			
			System.out.println("Enter ID: ");
			int id = sc.nextInt();
			pstm.setInt(1, id);
			
			System.out.println("Enter Name: ");
			String name = sc.next();
			pstm.setString(2, name);
			
			System.out.println("Enter eCompany: ");
			String eCompany = sc.next();
			pstm.setString(3, eCompany);

			System.out.println("Enter Salary: ");
			int salary = sc.nextInt();
			pstm.setInt(4, salary);
			
			pstm.execute();
			
			connect.close();
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}

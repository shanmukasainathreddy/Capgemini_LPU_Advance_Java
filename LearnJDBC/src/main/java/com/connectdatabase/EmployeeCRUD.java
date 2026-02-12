package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeCRUD {

    static String url = "jdbc:postgresql://localhost:5432/College";
    static String un = "postgres";
    static String pwd = "root";

    static Scanner sc = new Scanner(System.in);

    public static void addEmployee() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connect = DriverManager.getConnection(url, un, pwd);

            String sql = "insert into employee values(?,?,?,?)";
            PreparedStatement pstm = connect.prepareStatement(sql);

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            pstm.setInt(1, id);

            System.out.print("Enter Name: ");
            String name = sc.next();
            pstm.setString(2, name);

            System.out.print("Enter eCompany: ");
            String eCompany = sc.next();
            pstm.setString(3, eCompany);

            System.out.print("Enter Salary: ");
            int salary = sc.nextInt();
            pstm.setInt(4, salary);

            int rows = pstm.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Inserted Successfully");
            }

            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmpById() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connect = DriverManager.getConnection(url, un, pwd);

            String sql = "delete from employee where emp_id = ?";
            PreparedStatement pstm = connect.prepareStatement(sql);

            System.out.print("Enter Employee ID to Delete: ");
            int emp_id = sc.nextInt();
            pstm.setInt(1, emp_id);

            int rows = pstm.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Deleted Successfully");
            } else {
                System.out.println("Employee Not Found");
            }

            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateEmpById() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connect = DriverManager.getConnection(url, un, pwd);

            String sql = "update employee set salary = ? where emp_id = ?";
            PreparedStatement pstm = connect.prepareStatement(sql);

            System.out.print("Enter New Salary: ");
            int salary = sc.nextInt();

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            pstm.setInt(1, salary);
            pstm.setInt(2, id);

            int rows = pstm.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Updated Successfully");
            } else {
                System.out.println("Employee Not Found");
            }

            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findEmpById() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connect = DriverManager.getConnection(url, un, pwd);

            String sql = "select * from employee where emp_id = ?";
            PreparedStatement pstm = connect.prepareStatement(sql);

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Company: " + rs.getString(3));
                System.out.println("Salary: " + rs.getInt(4));
            } else {
                System.out.println("Employee Not Found");
            }

            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	
//    	int cnt = 0;
//    	
//    	if(cnt>0) {
//    		System.out.println("Press Yes to conitnue : ");
//    		String allow = sc.nextLine();
//    		if(allow=="Yes") continue;	

        while (true) {
//        	cnt++;
            System.out.println("\n----- Employee Menu -----");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee by ID");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Find Employee by ID");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    deleteEmpById();
                    break;
                case 3:
                    updateEmpById();
                    break;
                case 4:
                    findEmpById();
                    break;
                case 5:
                    System.out.println("Bye  Program Ended.");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice  Try Again");
            }
        }
    	}
    	
    }

package com.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDButill {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	public static boolean isSucess;
	public static  int id;
	public static String fname;
	public static String lname;
	public static String email;
	public static String phone;

	//customer insert method
	public static boolean insertCustomer(String fname, String lname, String email, String phone, String pw) {
	
		boolean isInsert = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String query = "insert into user values(0, '"+fname+"', '"+lname+"', '"+email+"', '"+phone+"', '"+pw+"')";
			int val = stmt.executeUpdate(query);
			
			if (val > 0) {
				isInsert = true;
			}
			else {
				isInsert = false;
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isInsert;
	}
	
	
	//validate register customer
	public static boolean validate(String email, String password) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String query = "select * from user where email='"+email+"' and pw='"+password+"'";
			
			rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				isSucess = true;
			}
			
			
			else {
				isSucess = false;
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSucess;
	}
	
	//return customer data from database
	public static List<Customer> getCustomer(String email) {
		
		ArrayList<Customer> cus = new ArrayList<>();
		
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String query = "select * from user where email='"+email+"'";
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				id = (int)rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String maill = rs.getString(4);
				String phone = rs.getString(5);
				String password = rs.getString(6);
				
				Customer c1 = new Customer(id, fname, lname, maill, phone, password);
				
				cus.add(c1);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		return cus;
	}
	
	
	
	//update customer details
	public static boolean updateCustomer(String fname, String lname, String email, String phone) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String query = "update user set fname='"+fname+"', lname='"+lname+"', email='"+email+"',phone='"+phone+"' where c_id = '"+id+"'";
			int rs = stmt.executeUpdate(query);
			
			if (rs > 0) {
				isSucess = true;
			}
			
			else {
				isSucess = false;
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSucess;
	}
	
	//delete customer
	public static boolean deleteCustomer() {
		
		
		con = DBConnect.getConnection();
		try {
			stmt = con.createStatement();
			String query = "delete from user where c_id = '"+id+"'";
			int rs = stmt.executeUpdate(query);
			
			if (rs > 0) {
				isSucess = true;
			}
			
			else {
				isSucess = false;
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return isSucess;
	}
	

}

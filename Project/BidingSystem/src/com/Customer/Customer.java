package com.Customer;

public class Customer {
	
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String password;

	
	
	public Customer(int id, String fname, String lname, String email, String phone, String password) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	
	public Customer(String fname, String lname, String email, String phone, String password) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}


	public String getFname() {
		return fname;
	}


	public String getLname() {
		return lname;
	}


	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}	

	
}

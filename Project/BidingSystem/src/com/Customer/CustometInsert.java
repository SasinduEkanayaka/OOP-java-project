package com.Customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@WebServlet("/CustometInsert")
public class CustometInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String pw = request.getParameter("pw");
		
		
		boolean isTrue;
		
		isTrue = CustomerDButill.insertCustomer(fname, lname, email, phone, pw);
		
		if (isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("CustomerLogin.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("Unsucess.jsp");
			dis.forward(request, response);	
		}
		
		
	}

}

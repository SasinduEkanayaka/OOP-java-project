package com.Customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customerDeleteServlet")
public class customerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		boolean isTrue = CustomerDButill.deleteCustomer();
		
		
		if (isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("CustomerSignUp.jsp");
			dis.forward(request, response);
		}
		
		else {
			RequestDispatcher dis = request.getRequestDispatcher("unsucess.jsp");
			dis.forward(request, response);
		}
	}

}

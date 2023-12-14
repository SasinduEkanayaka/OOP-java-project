package com.Customer;

import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("password");
		boolean isTrue;
		
		isTrue = CustomerDButill.validate(email, pw);
		
		if (isTrue == true) {
			List<Customer> cusDetails = CustomerDButill.getCustomer(email);
			request.setAttribute("cusDetails", cusDetails);
			
			
			
			HttpSession session = request.getSession();
			session.setAttribute("uemail", email);
			
			if(pw == "123") {
			RequestDispatcher dis = request.getRequestDispatcher("AdminDashbord.jsp");
			dis.forward(request, response);
			}
			
			else {
				RequestDispatcher dis = request.getRequestDispatcher("CustomerProfile.jsp");
				dis.forward(request, response);	
			}
			
		}
		
		else {
			
			out.println("<script type='text/javascript'>");
			out.println("alert('Invalid Username Or Password')");
			out.println("location='CustomerLogin.jsp'");
			out.println("</script>");
		}
		
		
	}

}

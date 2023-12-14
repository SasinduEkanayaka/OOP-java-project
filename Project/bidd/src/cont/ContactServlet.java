package cont;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContactDBUtil ContactDBUtil;
    
	  
    public ContactServlet() {
        super();
        this.ContactDBUtil = new ContactDBUtil();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/con_new":
                	showNewContact(request, response);
                    break;
                case "/con_insert":
                	insertContact(request, response);
                    break;
                case "/con_delete":
                	deleteContact(request, response);
                    break;
                case "/con_edit":
                    showEditFormContact(request, response);
                    break;
                case "/con_update":
                	updateContact(request, response);
                    break;
                default:
                	listContact(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void showNewContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("addContact.jsp");
		dispatcher.forward(request, response);
	
	}
	
	 private void insertContact(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
	
		

		Contact newContact = new Contact(name, email, message);
		ContactDBUtil.insertContact(newContact);;
		response.sendRedirect("con_list");
	}
	 
	 private void deleteContact(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 ContactDBUtil.deleteContact(id);
		 response.sendRedirect("con_list");

	}
	 
	 private void showEditFormContact(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Contact existingContact = ContactDBUtil.selectContact(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addContact.jsp");
		request.setAttribute("contact", existingContact);
		dispatcher.forward(request, response);

	}
	 
	 private void updateContact(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		
		Contact newContact = new Contact(id,name, email, message);
	    ContactDBUtil.updateContact(newContact);
	    response.sendRedirect("con_list");
	    
	}
	 
	 private void listContact(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < Contact > listContact = ContactDBUtil.selectAllContacts();
			        request.setAttribute("listContact", listContact);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("viewContact.jsp");
			        dispatcher.forward(request, response);
			    }



	

}

package Item;

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
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ItemDBUtil ItemDBUtil;
    
	  
    public ItemServlet() {
        super();
        this.ItemDBUtil = new ItemDBUtil();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/itm_new":
                	showNewItem(request, response);
                    break;
                case "/itm_insert":
                	insertItem(request, response);
                    break;
                case "/itm_delete":
                	deleteItem(request, response);
                    break;
                case "/itm_edit":
                    showEditFormItem(request, response);
                    break;
                case "/itm_update":
                	updateItem(request, response);
                    break;
                default:
                	listItem(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void showNewItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("addItem.jsp");
		dispatcher.forward(request, response);
	
	}
	
	 private void insertItem(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String sprice = request.getParameter("sprice");
		String description = request.getParameter("description");
		String bidtime = request.getParameter("bidtime");
		

		Item newItem = new Item(title, category, sprice, description, bidtime);
		ItemDBUtil.insertItem(newItem);;
		response.sendRedirect("itm_list");
	}
	 
	 private void deleteItem(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
		 int code = Integer.parseInt(request.getParameter("code"));
		 ItemDBUtil.deleteItem(code);
		 response.sendRedirect("itm_list");

	}
	 
	 private void showEditFormItem(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		Item existingItem = ItemDBUtil.selectItem(code);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addItem.jsp");
		request.setAttribute("item", existingItem);
		dispatcher.forward(request, response);

	}
	 
	 private void updateItem(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String sprice = request.getParameter("sprice");
		String description = request.getParameter("description");
		String bidtime = request.getParameter("bidtime");
		
		Item newItem = new Item(code,title, category, sprice, description, bidtime);
	    ItemDBUtil.updateItem(newItem);
	    response.sendRedirect("itm_list");
	    
	}
	 
	 private void listItem(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < Item > listItem = ItemDBUtil.selectAllItems();
			        request.setAttribute("listItem", listItem);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("viewItem.jsp");
			        dispatcher.forward(request, response);
			    }



	

}

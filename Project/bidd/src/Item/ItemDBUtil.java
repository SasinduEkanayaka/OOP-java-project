package Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Item.DBConnect;

public class ItemDBUtil {
	
	private static final String INSERT_USERS_SQL = "INSERT INTO item" + "  (title,category,sprice,description,bidtime) VALUES " +
	        " (?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select code,title,category,sprice,description,bidtime from item where code =?";
	private static final String SELECT_ALL_USERS = "select * from item";
	private static final String DELETE_USERS_SQL = "delete from item where code = ?;";
	private static final String UPDATE_USERS_SQL = "update item set title = ?, category = ?, sprice = ?, description = ?, bidtime = ? where code = ?;";

	
	public void insertItem(Item item) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        
        try (Connection conn = DBConnect.getconnection();PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL)) {
        	
            preparedStatement.setString(1, item.gettitle());
            preparedStatement.setString(2, item.getcategory());
            preparedStatement.setString(3, item.getsprice());
            preparedStatement.setString(4, item.getdescription());
            preparedStatement.setString(5, item.getbidtime());
           
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }
	
    public boolean updateItem(Item item) throws SQLException {
        boolean rowUpdated;
        try (Connection conn = DBConnect.getconnection(); PreparedStatement statement = conn.prepareStatement(UPDATE_USERS_SQL);) {
        	 statement.setString(1, item.gettitle());
             statement.setString(2, item.getcategory());
             statement.setString(3, item.getsprice());
             statement.setString(4, item.getdescription());
             statement.setString(5, item.getbidtime());
            
             statement.setInt(6, item.getcode());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
	 public Item selectItem(int code) {
	    	
	    	Item item = null;
	        
	        try (Connection conn = DBConnect.getconnection();
	        		
	            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER_BY_ID);) {
	        	
	            preparedStatement.setInt(1, code);
	            System.out.println(preparedStatement);
	
	            ResultSet rs = preparedStatement.executeQuery();
	            
	
	            while (rs.next()) {
	                String title = rs.getString("title");
	                String category = rs.getString("category");
	                String sprice = rs.getString("sprice");
	                String description = rs.getString("description");
	                String bidtime = rs.getString("bidtime");
	                
	
	                item = new Item(code,title,category,sprice,description,bidtime);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();;
	        }
	        return item;
	    }
	 
 
	 public List < Item > selectAllItems() {
	
	
	     List < Item > items = new ArrayList < > ();
	
	     try (Connection conn = DBConnect.getconnection();
	
	         PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_USERS);) {
	         System.out.println(preparedStatement);
	
	         ResultSet rs = preparedStatement.executeQuery();
	
	         
	         while (rs.next()) {
	             int code = rs.getInt("code");
	             String title = rs.getString("title");
	             String category = rs.getString("category");
	             String sprice = rs.getString("sprice");
	             String description = rs.getString("description");
	             String bidtime = rs.getString("bidtime");
	          
	
	             items.add(new Item(code, title, category, sprice, description, bidtime));
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return items;
	 }
 
	 
	 public boolean deleteItem(int code) throws SQLException {
	        boolean rowDeleted;
	        try (Connection conn = DBConnect.getconnection(); PreparedStatement statement = conn.prepareStatement(DELETE_USERS_SQL);) {
	            statement.setInt(1, code);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
 

}

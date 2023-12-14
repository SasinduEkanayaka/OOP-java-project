package cont;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cont.DBConnect;

public class ContactDBUtil {
	
	private static final String INSERT_USERS_SQL = "INSERT INTO contact" + "  (name,email,message) VALUES " +
	        " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,name,email,message from contact where id =?";
	private static final String SELECT_ALL_USERS = "select * from contact";
	private static final String DELETE_USERS_SQL = "delete from contact where id = ?;";
	private static final String UPDATE_USERS_SQL = "update contact set name = ?, email = ?, message = ? where id = ?;";

	
	public void insertContact(Contact contact) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        
        try (Connection conn = DBConnect.getconnection();PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL)) {
        	
            preparedStatement.setString(1, contact.getname());
            preparedStatement.setString(2, contact.getemail());
            preparedStatement.setString(3, contact.getmessage());
           
           
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }
	
    public boolean updateContact(Contact contact) throws SQLException {
        boolean rowUpdated;
        try (Connection conn = DBConnect.getconnection(); PreparedStatement statement = conn.prepareStatement(UPDATE_USERS_SQL);) {
        	 statement.setString(1, contact.getname());
             statement.setString(2, contact.getemail());
             statement.setString(3, contact.getmessage());
            
            
             statement.setInt(4, contact.getid());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
	 public Contact selectContact(int id) {
	    	
	    	Contact contact = null;
	        
	        try (Connection conn = DBConnect.getconnection();
	        		
	            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER_BY_ID);) {
	        	
	            preparedStatement.setInt(1, id);
	            System.out.println(preparedStatement);
	
	            ResultSet rs = preparedStatement.executeQuery();
	            
	
	            while (rs.next()) {
	                String name = rs.getString("name");
	                String email = rs.getString("email");
	                String message = rs.getString("message");
	        
	                
	
	                contact = new Contact(id,name,email,message);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();;
	        }
	        return contact;
	    }
	 
 
	 public List < Contact > selectAllContacts() {
	
	
	     List < Contact > contacts = new ArrayList < > ();
	
	     try (Connection conn = DBConnect.getconnection();
	
	         PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_USERS);) {
	         System.out.println(preparedStatement);
	
	         ResultSet rs = preparedStatement.executeQuery();
	
	         
	         while (rs.next()) {
	             int id = rs.getInt("id");
	             String name = rs.getString("name");
	             String email = rs.getString("email");
	             String message = rs.getString("message");
	           
	          
	
	             contacts.add(new Contact(id,name,email,message));
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return contacts;
	 }
 
	 
	 public boolean deleteContact(int id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection conn = DBConnect.getconnection(); PreparedStatement statement = conn.prepareStatement(DELETE_USERS_SQL);) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
 

}

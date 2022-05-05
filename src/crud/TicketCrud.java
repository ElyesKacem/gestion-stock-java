package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ramnaf
 */
public class TicketCrud {
    final public String dbURL = "jdbc:mysql://localhost:3306/projetjavaing1";
	final public String username = "root";
	final public String password = "root";
	
	public Connection getConnectionDB() {
		try {
			 
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		 
		    if (conn != null) {
		        System.out.println("Connected");
		    }
		    return(conn);
		 }
		 catch (SQLException ex) {
		    ex.printStackTrace();
		 }
                return null;
	}
	public void insertTicket(String client,int event,float prix,boolean etat) {
        try{
	        	            	
			Connection conn =getConnectionDB();
			String sql = "INSERT INTO ticket (client, IDEvenement, prix, etat) VALUES (?, ?, ?, ?)";		 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, client);
			statement.setInt(2, event);
			statement.setFloat(3, prix);
			statement.setBoolean(4, etat);
		 
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("ticket inserer");
			}
	            }
        catch (SQLException ex) {
        	
        		ex.printStackTrace();
        		
        	}
            
	}
	
	public void listTickets() {
		int id;
		String client;
		int event;
		float prix;
		boolean etat;
                try{
		Connection conn = getConnectionDB();
		String sql = "SELECT * FROM ticket";
		 
		          Statement statement = conn.createStatement();
		          ResultSet result = statement.executeQuery(sql);
		 
		int count = 0;
		 
		while (result.next()){
                    id = result.getInt(1);
		    client = result.getString(2);
		    event = result.getInt(3);
		    prix = result.getFloat(4);
		    etat = result.getBoolean(5);
                    count=count+1;
		  //affichage
		}
                }
                catch (SQLException ex) {
		    ex.printStackTrace();
		 }
            
	}
	
		public void UpdateTicket(int id,String client,int event,float prix,boolean etat) {
                    try{
			Connection conn =getConnectionDB();
			String sql = "UPDATE ticket SET client=?, IDEvenement=?, prix=?, etat=? WHERE id=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, client);
			statement.setInt(2, event);
			statement.setFloat(3, prix);
			statement.setBoolean(4, etat);
			statement.setInt(5, id);
			 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("ticket modifié");
			}
                    }
                    catch (SQLException ex) {
		    ex.printStackTrace();
		 }
            
		}
		
		public void deleteTicket(int id) {
                    try{
			Connection conn =getConnectionDB();
			String sql = "DELETE FROM ticket WHERE id=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			 
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("ticket supprimé");
			}
                    }
                    catch (SQLException ex) {
		    ex.printStackTrace();
		 }
            
		}
		
	}
		
	



package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Ticket.Ticket;

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
	final public String password = "";
	
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
	public void insertTicket(String client,int event,float prix) {
        try{
	        	            	
			Connection conn =getConnectionDB();
			String sql = "INSERT INTO ticket (client, IDEvenement, prix, etat) VALUES (?, ?, ?, ?)";		 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, client);
			statement.setInt(2, event);
			statement.setFloat(3, prix);
			statement.setBoolean(4, false);
		 
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
	
	
	
	
	
public ArrayList<Ticket> getAllTickets() {
		
		ArrayList<Ticket> tab=new ArrayList<Ticket>();
		
		try {
			Connection conn = getConnectionDB();
			String sql = "SELECT * FROM ticket";

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			int count = 0;
			
			
			int id;
			String clientName;
			float price;
			int IdEvent;
			Boolean status;
			

			while (result.next()) {
				
				id = result.getInt(1);
				clientName = result.getString(2);
				IdEvent = result.getInt(3);
				price = result.getFloat(4);
				status = result.getBoolean(5);
				Ticket t=new Ticket(id,price,IdEvent,clientName,status);
				tab.add(t);
				

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return tab;
		
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
			    System.out.println("ticket modifiÃ©");
			}
                    }
                    catch (SQLException ex) {
		    ex.printStackTrace();
		 }
            
		}
		public void UpdateTicket(int id,String client,int event,float prix) {
            try{
				Connection conn =getConnectionDB();
				String sql = "UPDATE ticket SET client=?, IDEvenement=?, prix=? WHERE id=?";
				 
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, client);
				statement.setInt(2, event);
				statement.setFloat(3, prix);
				statement.setInt(5, id);
				 
				int rowsUpdated = statement.executeUpdate();
				if (rowsUpdated > 0) {
				    System.out.println("ticket modifiÃ©");
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
			    System.out.println("ticket supprimee");
			}
                    }
                    catch (SQLException ex) {
		    ex.printStackTrace();
		 }
            
		}
		
	
		
		public int validateTicketWithId(int idd) {
			
			ArrayList<Ticket> tab=new ArrayList<Ticket>();
			try {
				Connection conn = getConnectionDB();
				String sql = "SELECT * FROM ticket where ticket.id="+idd;

				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(sql);

				int count = 0;
				
				
				int id;
				String clientName;
				float price;
				int IdEvent;
				Boolean etat;
				

				while (result.next()) {
					
					id = result.getInt(1);
					clientName = result.getString(2);
					IdEvent = result.getInt(3);
					price = result.getFloat(4);
					etat=result.getBoolean(5);
					Ticket t=new Ticket(id,price,IdEvent,clientName,etat);
					tab.add(t);
					

				}
				
				if(tab.size()<1)
				{
					return -1; // le ticket n'existe pas
					
				}
				else
				{
					
					Ticket t=tab.get(0);
			
					if (t.getEtat()==true)
					{
						return 0;
						// ticket est déja utilisé
					}
					else
					{
						System.out.println("tbadlet");
						UpdateTicket(t.getId(), t.getClient(), t.getidEvenement(), t.getPrix(), true);
						return 1;
					}
				}
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return -2;
			
		}
		public String getEventNamebyId(int id) {
			
			ArrayList<String> tab=new ArrayList<String>();
			
			try {
				Connection conn = getConnectionDB();
				String sql = "SELECT name FROM event WHERE event.id="+id;

				Statement statement = conn.createStatement();
				
				ResultSet result = statement.executeQuery(sql);

				int count = 0;

				while (result.next()) {
					
					tab.add(result.getString(1));
					

				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			
			
			System.out.println("resultat"+tab);
					
			return tab.get(0);
			
		}
		
	}
		
	



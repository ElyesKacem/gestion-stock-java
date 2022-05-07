package crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import GestionEvenement.Evenement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class EventCrud {
	final public String dbURL = "jdbc:mysql://localhost:3306/projetjavaing1";
	final public String username = "root";
	final public String password = "";

	public Connection getConnectionDB() {
		try {

			Connection conn = DriverManager.getConnection(dbURL, username, password);

			if (conn != null) {
				System.out.println("Connected");
			}
			return (conn);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void insertEvent(String name, int salle, String type, String date, String description) {
		try {

			Connection conn = getConnectionDB();
			String sql = "INSERT INTO event (name, salle, type, description,date) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, salle);
			statement.setString(3, type);
			statement.setString(4, date);
			statement.setString(5, description);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("ticket inserer");
			}
		} catch (SQLException ex) {

			ex.printStackTrace();

		}

	}

	public ArrayList<Evenement> listEvent() {
		int id;
		String date;
		String description;
		String name;
		int salle;
		String type;
		ArrayList<Evenement> events = new ArrayList<Evenement>();
		try {
			Connection conn = getConnectionDB();
			String sql = "SELECT * FROM event";

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			int count = 0;

			while (result.next()) {
				
				id = result.getInt(1);
				date = result.getString(5);
				description = result.getString(6);
				name = result.getString(2);
				salle = result.getInt(3);
				type = result.getString(4);
				
				
				
				count = count + 1;
				Evenement ev = new Evenement(id,name,date,salle,description,type);
				
				events.add(ev);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return events;

	}

	public void UpdateEvent(int id, String name, String description, int salle, String type, String date) {
		try {
			Connection conn = getConnectionDB();
			String sql = "UPDATE event SET date=?, description=?, name=?, salle=?, type=? WHERE id=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, date);
			statement.setString(2, description);
			statement.setString(3, name);
			statement.setInt(4, salle);
			statement.setString(5, type);
			statement.setInt(6, id);
			


			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("event modified");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void deleteEvent(int id) {
		try {
			Connection conn = getConnectionDB();
			String sql = "DELETE FROM event WHERE id=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("event deleted");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}

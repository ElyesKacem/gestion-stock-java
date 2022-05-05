package GestionEvenement;

import java.sql.Date;

public class Evenement {
	private int id;
	private String nom;
	private String date;
	private int salle;
	String type;
	String description;
	
	public Evenement(int id, String nom, String date, int salle,String description,String type) {
		this.id = id;
		this.nom = nom;
		this.date = date;
		this.salle = salle;
		this.type=type;
		this.description=description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSalle() {
		return salle;
	}
	public void setSalle(int salle) {
		this.salle = salle;
	}

}

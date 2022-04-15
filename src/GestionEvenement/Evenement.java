package GestionEvenement;

import java.sql.Date;

public class Evenement {
	private int id;
	private String nom;
	private Date date;
	private int salle;	
	
	public Evenement(int id, String nom, Date date, int salle) {
		this.id = id;
		this.nom = nom;
		this.date = date;
		this.salle = salle;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getSalle() {
		return salle;
	}
	public void setSalle(int salle) {
		this.salle = salle;
	}

}

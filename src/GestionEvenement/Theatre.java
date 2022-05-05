package GestionEvenement;

import java.sql.Date;

public class Theatre extends Evenement {
	private String auteur;
	
	public Theatre(int id, String nom, String date, int salle,String description,String type,String r)
	{
		super(id, nom, date, salle,description,type);
		this.auteur=r;
		
	}

	public String getRealisateur() {
		return auteur;
	}

	public void setRealisateur(String realisateur) {
		this.auteur = realisateur;
	}
	
	

}

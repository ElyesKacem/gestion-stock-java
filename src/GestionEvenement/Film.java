package GestionEvenement;

import java.sql.Date;

public class Film extends Evenement {
	private String realisateur;
	
	public Film(int id, String nom, String date, int salle,String description,String type,String r)
	{
		super(id, nom, date, salle,description,type);
		this.realisateur=r;
		
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	
	

}

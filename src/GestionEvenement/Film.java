package GestionEvenement;

import java.sql.Date;

public class Film extends Evenement {
	private String realisateur;
	
	public Film(int id, String nom, Date date, int salle,String r)
	{
		super(id, nom, date, salle);
		this.realisateur=r;
		
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	
	

}

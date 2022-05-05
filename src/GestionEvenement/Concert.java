package GestionEvenement;

import java.sql.Date;

public class Concert extends Evenement {
	private String chant;
	
	public Concert(int id, String nom, String date, int salle,String description,String type,String r)
	{
		super(id, nom, date, salle,description,type);
		this.chant=r;
		
	}

	public String getRealisateur() {
		return chant;
	}

	public void setRealisateur(String realisateur) {
		this.chant = realisateur;
	}
	
	

}

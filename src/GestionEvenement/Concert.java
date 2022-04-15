package GestionEvenement;

import java.sql.Date;

public class Concert extends Evenement {
	private String chant;
	
	public Concert(int id, String nom, Date date, int salle,String r)
	{
		super(id, nom, date, salle);
		this.chant=r;
		
	}

	public String getRealisateur() {
		return chant;
	}

	public void setRealisateur(String realisateur) {
		this.chant = realisateur;
	}
	
	

}

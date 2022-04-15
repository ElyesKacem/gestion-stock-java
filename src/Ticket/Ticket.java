package Ticket;

public class Ticket {
	private int id;
	private float prix;
	private int IDEvenement;
	private int IDClient;
	private Boolean etat;
	
	
	
	public Ticket(int id, float prix, int iDEvenement, int iDClient, Boolean etat) {

		this.id = id;
		this.prix = prix;
		IDEvenement = iDEvenement;
		IDClient = iDClient;
		this.etat = etat;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getIDEvenement() {
		return IDEvenement;
	}
	public void setIDEvenement(int iDEvenement) {
		IDEvenement = iDEvenement;
	}
	public int getIDClient() {
		return IDClient;
	}
	public void setIDClient(int iDClient) {
		IDClient = iDClient;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	
	

}

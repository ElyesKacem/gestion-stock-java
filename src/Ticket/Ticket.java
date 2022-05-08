package Ticket;

public class Ticket {
	private int id;
	private float prix;
	private int idEvenement;
	private String client;
	private Boolean etat;
	
	public Ticket(int id, float prix, int idEvenement, String clientName) {

		this.id = id;
		this.prix = prix;
		this.idEvenement = idEvenement;
		client = clientName;
		this.etat = false;
		
	}
	
	
	public Ticket(int id, float prix, int idEvenement, String clientName, Boolean etat) {

		this.id = id;
		this.prix = prix;
		this.idEvenement = idEvenement;
		client = clientName;
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
	public int getidEvenement() {
		return idEvenement;
	}
	public void setidEvenement(int idEvenement) {
		this.idEvenement = idEvenement;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String iDclient) {
		client = iDclient;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	
	

}

package et3.java.projet;


import java.util.HashMap;


public class Utilisateur {
	
	
	
	//pour ajouter un utilisateur
	
	
	//Variables
	
	public HashMap <String, Document> listeEmprunts;
	private int quota;
	private String nom;
	private String prenom;
	private int idUser;
	private int compteur=0;
	private Bibliotheque bibli;
	
	//Constructeurs
	
	public Utilisateur (int quota, String nom, String prenom,Bibliotheque bibli) {
		
		this.quota=quota;
		this.nom=nom;
		this.prenom=prenom;
		this.bibli=bibli;
		listeEmprunts= new HashMap();
		compteur++;
		idUser=compteur;
	}
	
	//Getters &Setters
	
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	public int getIdUser() {
		return idUser;
	}


	public int getQuota() {
		return quota;
	}
	
	public void setQuota(int quota) {
		this.quota = quota;
	}
	
}


package et3.java.projet;

import java.util.ArrayList;

public class Utilisateur extends Bibliotheque {
	
	//Variables
	
	
	private int id;
	private int nbEmprunts;
	private int quota;
	private String nom;
	private String prenom;
	
	//Constructeurs
	
	public Utilisateur (int id_bibli, int id_user, int totalCopies,ArrayList<Bibliotheque> listeBibli, ArrayList<Document> collecTotal) {
		super (id_bibli,totalCopies,listeBibli,collecTotal);
		this.id=id_user;
		this.quota=0;
		this.nbEmprunts=0;
		this.nom="";
		this.prenom="";
	}
	
	//Getters &Setters
	
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
		
	
	//Méthodes
	
	public boolean emprunter (int quota) {
		//TODO
		return false;
	}
	

	public boolean rendre (int quota) {
		//TODO
		return false;
	}
}


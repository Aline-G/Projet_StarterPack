package et3.java.projet;

import java.util.ArrayList;


public class Bibliotheque extends Reseau {

	//Variables

	private int id;
	private String nom;
	private ArrayList<Document> collec = new ArrayList<Document>(); 
	
	
	//Constructeurs

	public Bibliotheque(int id, String nom,  ArrayList<Document> collec,int totalCopies,ArrayList<Bibliotheque> listeBibli, ArrayList<Document> collecTotal) {
		super(totalCopies,listeBibli,collecTotal);
		this.id=id;
		this.nom=nom;
		this.collec=collec;
	}
	
	public Bibliotheque(int id, String nom,int totalCopies,ArrayList<Bibliotheque> listeBibli, ArrayList<Document> collecTotal) {
		super(totalCopies,listeBibli,collecTotal);
		this.id=id;
		this.nom=nom;
		this.collec=null;
	}
	
	public Bibliotheque(int id,  ArrayList<Document> collec,int totalCopies,ArrayList<Bibliotheque> listeBibli, ArrayList<Document> collecTotal) {
		super(totalCopies,listeBibli,collecTotal);
		this.id=id;
		this.nom="";
		this.collec=collec;
	}
	
	public Bibliotheque(int id,int totalCopies,ArrayList<Bibliotheque> listeBibli, ArrayList<Document> collecTotal) {
		super(totalCopies,listeBibli,collecTotal);
		this.id=id;
		this.nom="";
		this.collec=null;
	}
	
	//Getters &Setters
	
	//Méthodes
	
	
	public boolean trouverSerie (Document doc) {
		//TODO
		return false;
	}
	
	public boolean echange (ArrayList<Document> docEchange) {
		//TODO
		return false;
	}
	
	public boolean estDisponible (Document doc) {
		//TODO
		return false;
	}
	
	public boolean ajoutDocument (Document doc) {
		//TODO
		return false;
	}
	
	public boolean ajoutUtilisateur (String Nom, String Prenom){
		//TODO
		//utiliser getNom et getPrenom
		return false;
	}
	
	public void ConsulterDocument(Document doc) {
		//TODO
	}
	
	public void trierSerie(String titreSerie) {
		//TODO
		//utiliser getSerieTitle
	}
	
	@Override
	public void trierParAuteur(String authorName) {
		//TODO
	}
	
	@Override
	public void trierParAuteurSurname(String authorSurname) {
		//TODO
	}
	
	@Override
	public void trierParAuteur(String authorName, String authorSurname) {
		//TODO
	}
	
	public void rechercheISBN(String ISBN) {
		//TODO
	}
	
	public void rechercheEAN (String EAN) {
		//TODO
	}
	
	public void nbDocumentsTypes (String dateDebut, String dateFin, String type) {
	
	}
	
}


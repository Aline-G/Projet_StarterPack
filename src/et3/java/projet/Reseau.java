package et3.java.projet;

import java.util.ArrayList;


public class Reseau {
	
	//Variables
	
	private int totalCopies;
	private ArrayList<Bibliotheque> listeBibli = new ArrayList<Bibliotheque>();  ;
	private ArrayList<Document> collecTotal= new ArrayList<Document>(); 
	
	//Constructeurs
	
	public Reseau (int totalCopies,ArrayList<Bibliotheque> listeBibli, ArrayList<Document> collecTotal ) {
		this.totalCopies=totalCopies;
		this.listeBibli=listeBibli;
		this.collecTotal=collecTotal;
	}
	
	public Reseau (int totalCopies,ArrayList<Bibliotheque> listeBibli ) {
		this.totalCopies=totalCopies;
		this.listeBibli=listeBibli;
		this.collecTotal=null;
	}
	
	public Reseau (int totalCopies ) {
		this.totalCopies=totalCopies;
		this.listeBibli=null;
		this.collecTotal=null;
	}
	
	//Getters &Setters
	
	//Méthodes
	
	public boolean ajoutBiblio (Bibliotheque bibli) {
		//TODO
		return false;
	}
	
	public boolean ajoutDocument(String ISBN,String EAN, int id_bibli) {
		return false;
		//TODO
	}
	
	public void consulterDocument() {
		//TODO
	}
	
	public void trierSerie(String TitreSerie) {
		//TODO
	}
	
	public void trierParAuteur(String authorName) {
		//TODO
	}
	
	public void trierParAuteurSurname(String authorSurname) {
		//TODO
	}
	
	public void trierParAuteur(String authorName, String authorSurname) {
		//TODO
	}
	
	public void rechercheISBN(String ISBN) {
		
	}
	
	public void rechercheEAN(String EAN) {
		
	}
	
	public void nbDocumentsTypes(String dateDebut, String dateFin, String type) {
		
	}
	
	
}


package et3.java.projet;

import java.util.ArrayList;

import java.util.HashMap;




public class Reseau {
	
	//Variables
	
	public HashMap <String,Serie> listeSeries;
	public HashMap <String, Bibliotheque> listeBibli;
	
	//Constructeurs
	
	public Reseau (ArrayList<ArrayList<String>> collec) {
		
		listeBibli = new HashMap();
		listeSeries = new HashMap();
		
		Bibliotheque AimeCesaire = new Bibliotheque("AimeCesaire",this);
		Bibliotheque EdmondRostand = new Bibliotheque("EdmondRostand",this);
		Bibliotheque JeanPierreMelville = new Bibliotheque("JeanPierreMelville",this);
		Bibliotheque OscarWilde = new Bibliotheque("OscarWilde",this);
		Bibliotheque SaintSimon = new Bibliotheque("SaintSimon",this);
		
		int isbn= 0;
		int ean= 1;
		int title= 2;
		int publisher= 3;
		int date= 4;
		int seriesTitle = 5;
		int seriesNumber = 6;
		int authorName = 7;
		int authorSurname =8;
		int type = 9;
		int totalcopies =10;
		int numberOfcopyAimeCesaire = 11;
		int numberOfcopyEdmondRostand = 12;
		int numberOfcopyJeanPierreMelville = 13;
		int numberOfcopyOscarWilde = 14;
		int numberOfcopySaintSimon = 15;
		
		listeBibli.put(AimeCesaire.getNom(),AimeCesaire);
		listeBibli.put(EdmondRostand.getNom(),EdmondRostand);
		listeBibli.put(JeanPierreMelville.getNom(),JeanPierreMelville);
		listeBibli.put(OscarWilde.getNom(),OscarWilde);
		listeBibli.put(SaintSimon.getNom(),SaintSimon);	
		
		
		for(int i=0;i<collec.size();i++) {
			Document doc = new Autre(collec.get(i).get(ean),collec.get(i).get(title),collec.get(i).get(publisher),collec.get(i).get(date),collec.get(i).get(seriesTitle),collec.get(i).get(seriesNumber),collec.get(i).get(authorSurname),collec.get(i).get(authorName));
			
			if(!collec.get(i).get(ean).equals("") || !collec.get(i).get(isbn).equals("")) {
				if(!collec.get(i).get(isbn).equals("")) {
				
					if(collec.get(i).get(type).contains("Livre")) {
						doc = new Livre(collec.get(i).get(isbn),collec.get(i).get(ean),collec.get(i).get(title),collec.get(i).get(publisher),collec.get(i).get(date),collec.get(i).get(seriesTitle),collec.get(i).get(seriesNumber),collec.get(i).get(authorSurname),collec.get(i).get(authorName));
					}
					else if(collec.get(i).get(type).contains("Partition")) {
						doc = new Partition(collec.get(i).get(isbn),collec.get(i).get(ean),collec.get(i).get(title),collec.get(i).get(publisher),collec.get(i).get(date),collec.get(i).get(seriesTitle),collec.get(i).get(seriesNumber),collec.get(i).get(authorSurname),collec.get(i).get(authorName));
					}
					else if(collec.get(i).get(type).contains("Bande")) {
						doc = new BandeDessinee(collec.get(i).get(isbn),collec.get(i).get(ean),collec.get(i).get(title),collec.get(i).get(publisher),collec.get(i).get(date),collec.get(i).get(seriesTitle),collec.get(i).get(seriesNumber),collec.get(i).get(authorSurname),collec.get(i).get(authorName));
					}
					else if(collec.get(i).get(type).contains("Carte")) {
						doc = new Carte(collec.get(i).get(isbn),collec.get(i).get(ean),collec.get(i).get(title),collec.get(i).get(publisher),collec.get(i).get(date),collec.get(i).get(seriesTitle),collec.get(i).get(seriesNumber),collec.get(i).get(authorSurname),collec.get(i).get(authorName));
					}
				}
					
				else {
					if(collec.get(i).get(type).contains("Disque")) {
						doc = new CD(collec.get(i).get(ean),collec.get(i).get(title),collec.get(i).get(publisher),collec.get(i).get(date),collec.get(i).get(seriesTitle),collec.get(i).get(seriesNumber),collec.get(i).get(authorSurname),collec.get(i).get(authorName));
					}
					else if(collec.get(i).get(type).contains("Jeux Video")) {
						doc = new JeuVideo(collec.get(i).get(ean),collec.get(i).get(title),collec.get(i).get(publisher),collec.get(i).get(date),collec.get(i).get(seriesTitle),collec.get(i).get(seriesNumber),collec.get(i).get(authorSurname),collec.get(i).get(authorName));
					}
					else if(collec.get(i).get(type).contains("Revue")) {
						doc = new Revue(collec.get(i).get(ean),collec.get(i).get(title),collec.get(i).get(publisher),collec.get(i).get(date),collec.get(i).get(seriesTitle),collec.get(i).get(seriesNumber),collec.get(i).get(authorSurname),collec.get(i).get(authorName));
					}
					else if(collec.get(i).get(type).contains("Vinyle")) {
						doc = new Vinyle(collec.get(i).get(ean),collec.get(i).get(title),collec.get(i).get(publisher),collec.get(i).get(date),collec.get(i).get(seriesTitle),collec.get(i).get(seriesNumber),collec.get(i).get(authorSurname),collec.get(i).get(authorName));
					}
					else if (collec.get(i).get(type).contains("Revue")) {
						doc = new Revue(collec.get(i).get(ean),collec.get(i).get(title),collec.get(i).get(publisher),collec.get(i).get(date),collec.get(i).get(seriesTitle),collec.get(i).get(seriesNumber),collec.get(i).get(authorSurname),collec.get(i).get(authorName));
					}
					else if(collec.get(i).get(type).contains("Jeux de societe")) {
						doc = new Vinyle(collec.get(i).get(ean),collec.get(i).get(title),collec.get(i).get(publisher),collec.get(i).get(date),collec.get(i).get(seriesTitle),collec.get(i).get(seriesNumber),collec.get(i).get(authorSurname),collec.get(i).get(authorName));
					}	
					else if(collec.get(i).get(type).contains("Disque")) {
						doc = new Vinyle(collec.get(i).get(ean),collec.get(i).get(title),collec.get(i).get(publisher),collec.get(i).get(date),collec.get(i).get(seriesTitle),collec.get(i).get(seriesNumber),collec.get(i).get(authorSurname),collec.get(i).get(authorName));
					}
					else if(!collec.get(i).get(seriesTitle).contains("")) {
						ajoutSeries(collec.get(i).get(seriesTitle),doc);
					}	
				}
				
				if(Integer.parseInt(collec.get(i).get(numberOfcopyAimeCesaire))>0){
					AimeCesaire.ajoutDocument(doc, Integer.parseInt(collec.get(i).get(numberOfcopyAimeCesaire)));
				}
				if(Integer.parseInt(collec.get(i).get(numberOfcopyEdmondRostand))>0) {
					EdmondRostand.ajoutDocument(doc,Integer.parseInt(collec.get(i).get(numberOfcopyEdmondRostand)));
				}
				if(Integer.parseInt(collec.get(i).get(numberOfcopyJeanPierreMelville))>0) {
					JeanPierreMelville.ajoutDocument(doc,Integer.parseInt(collec.get(i).get(numberOfcopyJeanPierreMelville)));
				}
				if(Integer.parseInt(collec.get(i).get(numberOfcopyOscarWilde))>0) {
					OscarWilde.ajoutDocument(doc,Integer.parseInt(collec.get(i).get(numberOfcopyOscarWilde)));
				}
				if(Integer.parseInt(collec.get(i).get(numberOfcopyEdmondRostand))>0) {
					SaintSimon.ajoutDocument(doc,Integer.parseInt(collec.get(i).get(numberOfcopySaintSimon)));
				}
			}							
		}		
	}

	//Getters &Setters
	
	//MÃ©thodes
	
	
	//fonction qui ajoute une bibliothèque et renvoi vrai si c'est possible
	
	
	//FOcntion pour les tests
	public  Bibliotheque renvoiBibli(String nom){
		return listeBibli.get(nom);
	}
	
	public void ajoutBiblio (Bibliotheque bibli) {
		listeBibli.put(bibli.getNom(), bibli);
	}
	
	public void ajoutSeries (String serieTitle, Document doc) {
		boolean existe = false;
		for(String key: listeSeries.keySet()) {
			if(listeSeries.get(key) != null ) {
				if(serieTitle.equals(listeSeries.get(key).getNom())) {
					listeSeries.get(key).series.add(doc);
					existe=true;
				}
			}
		}
		if (existe==false) {
		ArrayList<Document> ajout = new ArrayList<Document>();
		ajout.add(doc);
		Serie s = new Serie (serieTitle,ajout);
		listeSeries.put(serieTitle,s);
		}
	}
	
	//Consultation de tous les documents du réseau
	public void consulterDocument() {
		for(String key: listeBibli.keySet()) {
			listeBibli.get(key).consulterDocument();
		}
	}
	
	public void echange (ArrayList<Document> docEchange, Bibliotheque A, Bibliotheque B) {
		for(int i=0; i<docEchange.size();i++) {
			if(A.estDisponible(docEchange.get(i))) {
				B.ajoutDocument(docEchange.get(i),1);																	 //On ajoute un exemplaire à la liste de la bibliotheque B
				A.listeExemplaires.put(docEchange.get(i).getKey(),A.listeExemplaires.get(docEchange.get(i).getKey())-1); //On retire un exemplaire à la liste de la bibliotheque A
			}
			else {
				System.out.println("Le document " + docEchange.get(i) + " n'est pas disponible dans la bibliotheque " + A + " pour un échange avec la bibliotheque " + B + "\n");
			}
		}
	}
	
	public void trierParAuteurName(String authorName) {
		for(String key: listeBibli.keySet()) {
			listeBibli.get(key).trierParAuteurName(authorName);
		}
	}
	
	public void trierParAuteurSurname(String authorSurName) {
		for(String key: listeBibli.keySet()) {
			listeBibli.get(key).trierParAuteurSurname(authorSurName);
		}
	}
	
	public void trierParAuteur(String authorName,String authorSurname) {
		for(String key: listeBibli.keySet()) { 
			listeBibli.get(key).trierParAuteur(authorName,authorSurname);
		}
	}
	
	public void rechercheISBN(String ISBN) {
		for(String key: listeBibli.keySet()) {
			listeBibli.get(key).rechercheISBN(ISBN);
		}
	}
	
	public void rechercheEAN(String EAN) {
		for(String key: listeBibli.keySet()) {
			listeBibli.get(key).rechercheEAN(EAN);
		}
	}
	
	
	public void nbDocumentsTypes(int dateDebut, int dateFin) {
		for(String key: listeBibli.keySet()) {
			listeBibli.get(key).nbDocumentsTypes(dateDebut, dateFin);
		}
	}
	
}


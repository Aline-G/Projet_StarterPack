package et3.java.projet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import et3.java.projet.data.FileReader;


public class Reseau {
	
	//Variables
	
	
		
	/*
	//collection de tous les documents
	private ArrayList<Document> collecTotal= new ArrayList<Document>();
	
	//collection des documents par bibliothèques contenu dans une collection
	private ArrayList<ArrayList<Document>> listeCollec= new ArrayList<ArrayList<Document>>();
	
	//on remplit la liste de bibli
	*/
	
	
	private HashMap <String, Bibliotheque> listeBibli;
	
	//Constructeurs
	
	public Reseau (ArrayList<ArrayList<String>> collec) {
		
		listeBibli = new HashMap();
		
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
		int authorname = 7;
		int authorsurname =8;
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
			Document doc;
			if(!doc.getEAN().equals("") || !doc.getISBN().equals("")) {
				
				if(collec.get(i).get(type).contains("Livre")) {
					doc = new Livre(collec.get(i).get(isbn),collec.get(i).get(ean),collec.get(i).get(title),publisher,date,String serieTitle,serieNumber,authorSurname,authorName);
				}
				// TODO
				//Ajouter les copies à la bibliotheque
			}
			
			
		}
		
	}
	
	
	//Getters &Setters
	
	//MÃ©thodes
	
	
	//fonction qui ajoute une bibliothèque et renvoi vrai si c'est possible
	
	public boolean ajoutBiblio (Bibliotheque bibli) {
		boolean peutAjouter = false;
		for (int i=0; i < listeBibli.size() ; i++) {
			if (bibli.getId() != listeBibli.get(i).getId()  || bibli.getNom() != listeBibli.get(i).getNom()) {
				peutAjouter = true;
			}
			else {
				peutAjouter=false;
			}
		}
		if(peutAjouter) {
			listeBibli.add(bibli);
			return true;
		}
		else {
			return false;
		}
	}
	
	//On ajoute le document ainsi que l'ID de la bibliothèque dans laquelle on ajoute le document
	
		public boolean ajoutDocument(Document doc, int idBibli) {
		//On teste si on peut ajouter le document par rapport à l'ISBN et l'EAN
	        boolean peutAjouter=true;
	        for (int i=0; i<collec.size();i++){
	            if (doc.getEAN() == collec.get(i).getEAN() || doc.getISBN()==collec.get(i).getISBN()) {
	                peutAjouter = false;
	            }
	        }
	        if(peutAjouter) {
	        	//On ajoute le doc à la collection
	            collec.add(doc);
	            //On ajoute le document aux bibliotheques
	             for (int j=0;j<listeBibli.size();j++) {
	            	 if(idBibli == listeBibli.get(j).getId()) {
	            		 listeCollec.get(j).add(doc);	 
	            	 }
	             }
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
		
	//Consultation de tous les documents du réseau
	public void consulterDocument() {
		for (int i=0; i< collec.size();i++) {
			System.out.println(collec.get(i));
		}
	}
	
	public void trierSerie(String titreSerie) {
		ArrayList<Document> liste = new ArrayList<Document>();
		ArrayList<String> tableau = new ArrayList<String>();
		
		for (int i=0;i<collec.size();i++) {
			if (collec.get(i).getSerieTitle()==titreSerie) {
				liste.add(collec.get(i));				//On ajoute le document à une liste temporaire
				tableau.add(liste.get(i).getDate());		//on crée une liste qui ne contient que les dates de liste
			}
		}
		//Maintenant on veut afficher cette liste de documents en fonction de la date de publication croissant
		Collections.sort(tableau);							// On trie la liste de dates
		for (int i=0; i<tableau.size();i++) {
			for(int j=0; j<liste.size();i++) {
				if(tableau.get(i)==liste.get(j).getDate()) {
					System.out.println(liste.get(j));		//Affichage des documents par série et par date de publication
					liste.remove(j);						//on retire de la liste une fois que ça a été affiché
				}
			}
		}
	}
	
	public void trierParAuteurName(String authorName) {
		for (int i=0;i<collec.size();i++) {
			if (collec.get(i).getAuthorName() == authorName) {
				System.out.println(collec.get(i));
			}
		}
	}
	
	public void trierParAuteurSurname(String authorSurname) {
		for (int i=0;i<collec.size();i++) {
			if (collec.get(i).getAuthorSurname() == authorSurname) {
				System.out.println(collec.get(i));
			}
		}
	}
	
	public void trierParAuteur(String authorName, String authorSurname) {
		for (int i=0;i<collec.size();i++) {
			if (collec.get(i).getAuthorName() == authorName & collec.get(i).getAuthorSurname() == authorSurname ) {
				System.out.println(collec.get(i));
			}
		}
	}
	
	public void rechercheISBN(String ISBN) {
		for (int i=0; i<collec.size(); i++) {
			if(collec.get(i).getType().startsWith("Livre") || collec.get(i).getType().startsWith("Bande")) { //StartsWith permet de comparer le début d'une chaine de caractère
				if(collec.get(i).getISBN()==ISBN) {
					System.out.println(collec.get(i));
				}
			}
		}
	}
	
	public void rechercheEAN(String EAN) {
		for (int i=0; i<collec.size(); i++) {
			if(collec.get(i).getEAN()==EAN) {
				System.out.println(collec.get(i));
			}
		}
	}
	
	
	public void nbDocumentsTypes(int dateDebut, int dateFin) {
	       int carte=0,cd=0,jeuV=0,jeuS=0,livre=0,revue=0,partition=0,Vinyle=0,BD=0,autre=0;
	        for (int i=0;i<collec.size();i++){
	            int date = Integer.parseInt(collec.get(i).getDate());
	            if(collec.get(i).getType().startsWith("Livre") & dateDebut <= date & dateFin >= date){
	                livre+=1;
	            }
	            else if(collec.get(i).getType().startsWith("carte") & dateDebut <= date & dateFin >= date){
	                carte+=1;
	            }
	            else if(collec.get(i).getType().startsWith("Disque") & dateDebut <= date & dateFin >= date){
	                cd+=+1;
	            }
	            else if(collec.get(i).getType().startsWith("Jeux Videos") & dateDebut <= date & dateFin >= date) {
	            	jeuV+=1;
	            }
	            else if(collec.get(i).getType().startsWith("Jeu de societe") & dateDebut <= date & dateFin >= date) {
	            	jeuS+=1;
	            }
	            else if(collec.get(i).getType().startsWith("Revue") & dateDebut <= date & dateFin >= date) {
	            	revue+=1;
	            }
	            else if(collec.get(i).getType().startsWith("Partition") & dateDebut <= date & dateFin >= date) {
	            	partition+=1;
	            }
	            else if(collec.get(i).getType().startsWith("Vinyle") & dateDebut <= date & dateFin >= date) {
	            	Vinyle+=1;
	            }
	            else if(collec.get(i).getType().startsWith("Bande") & dateDebut <= date & dateFin >= date) {
	            	BD+=1;
	            }
	            else if(dateDebut <= date & dateFin >= date) {
	            	autre+=1;
	            }  
	          }
		       System.out.println("Le nombre de documents par types sont :" + "\n");
		       System.out.println("Les livres : " + livre + "\n");
		       System.out.println("Les cartes : " + carte + "\n");
		       System.out.println("Les disques : " + cd + "\n");
		       System.out.println("Les jeux videos : " + jeuV + "\n");
		       System.out.println("Les jeux de societes : " + jeuV + "\n");
		       System.out.println("Les revues : " + revue + "\n");
		       System.out.println("Les partitions : " + partition + "\n");
		       System.out.println("Les vinyles : " + Vinyle + "\n");
		       System.out.println("Les Bandes dessinees : " + BD + "\n");
		       System.out.println("Les autres : " + autre + "\n");
	}
	
}


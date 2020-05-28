package et3.java.projet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import et3.java.projet.data.FileReader;


public class Bibliotheque {

	//Variables
	
	//private int id;
	private String nom;
	private Reseau res;
	
	
	//liste des utilisateurs associés à une bibliothèque
	
	
	private HashMap <String, Bibliotheque> listeUtilisateur;
	private HashMap <String, Bibliotheque> listeExemplaires;
	private HashMap <String, Bibliotheque> listeDocs;
	
	
	//Constructeurs

	public Bibliotheque(String nom,Reseau res) {
		listeUtilisateur = new HashMap();
		listeExemplaires = new HashMap();
		listeDocs= new HashMap();
		this.nom=nom;
		this.res=res;
	}
	
	//Getters &Setters

	public String getNom() {
		return nom;
	}
	
	//Ajout utilisateur
	/* 
	 * public void ajoutUtilisateur(int quota,String nom,String prenom){
	 * 		Utilisateur User= new Utilisateur(nom,prenom,quota,this);
	 * 		listeUtilisateur.put(nom+prenom+User.getIdUser(),User);
	 * 		}
	 * 
	 * 
	 * 
	 * */
	
	
	//Methodes
	

	
	public ArrayList<Document> trouverSerie () {
		ArrayList<Document> collecSerie = new ArrayList<Document>();
		for(int i=0; i<this.collec.size() ; i++) {
			if(collec.get(i).getSerieTitle()!="") {
				collecSerie.add(collec.get(i));
			}
		}
		return collecSerie;
	}
	
	public boolean echange (ArrayList<Document> docEchange) {
		//TODO
		return false;
	}
	
	public boolean estDisponible (Document doc) {
		boolean peutModifier = false;
		for(int i=0; i<this.collec.size();i++) {
			//On compare pour les 5 bibliothèques disponibles dans le fihier csv, il faudrait ajouter une colonne pour chque nouvelle bibliothèque
			if(doc.getEAN()==this.collec.get(i).getEAN() & doc.getISBN()==this.collec.get(i).getISBN() & doc.getNumberCopyAimeCesaire() > 0 || doc.getNumberCopyEdmondRostand()>0
					|| doc.getNumberCopyJeanPierreMelville() >0 || doc.getNumberCopyOscarWilde()>0 || doc.getNumberCopySaintSimon()>0) {
				peutModifier=true;
			}
			else {
				peutModifier=false;
			}
		}
		if(peutModifier) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean ajoutDocument (Document doc) {
		
		//String key=doc.getKey()
		//listeDocs.put(key,doc);
		//listeExemplaires.put(key,nbExemplaires
	     boolean peutAjouter=true;
	        for (int i=0; i<this.collec.size();i++){
	            if (doc.getEAN() == this.collec.get(i).getEAN() || doc.getISBN()==this.collec.get(i).getISBN()) {
	                peutAjouter = false;
	            }
	        }
	        if(peutAjouter) {
	        	//On ajoute le doc à la collection
	            this.collec.add(doc);
	            return true;
	        }
	        else {
	            return false;
	        }
	}
	
	public void ajoutUtilisateur (Utilisateur user){
		listeUtilisateur.add(user);
	}
	
	//Pour cette fonction on affiche tous les documents
	public void ConsulterDocument() {
		for (int i=0; i<this.collec.size(); i++) {
			System.out.println(this.collec.get(i));
		}
	}
	
	public void trierSerie(String titreSerie) {
		ArrayList<Document> liste = new ArrayList<Document>();
		ArrayList<String> tableau = new ArrayList<String>();
		
		ArrayList<Document> collecS = new ArrayList<Document>();
		collecS=this.trouverSerie();
		
		for (int i=0;i<collecS.size();i++) {
			if (collecS.get(i).getSerieTitle()==titreSerie) {
				liste.add(collecS.get(i));				//On ajoute le document à une liste temporaire
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
	
	@Override
	public void trierParAuteurName(String authorName) {
		for (int i=0;i<this.collec.size();i++) {
			if (this.collec.get(i).getAuthorName() == authorName) {
				System.out.println(collec.get(i));
			}
		}
	}	
		
	
	@Override
	public void trierParAuteurSurname(String authorSurname) {
		for (int i=0;i<this.collec.size();i++) {
			if (this.collec.get(i).getAuthorSurname() == authorSurname) {
				System.out.println(collec.get(i));
			}
		}
	}
	
	@Override
	public void trierParAuteur(String authorName, String authorSurname) {
		for (int i=0;i<this.collec.size();i++) {
			if (this.collec.get(i).getAuthorName() == authorName & this.collec.get(i).getAuthorSurname() == authorSurname ) {
				System.out.println(this.collec.get(i));
			}
		}
	}
	
	public void rechercheISBN(String ISBN) {
		for (int i=0; i<this.collec.size(); i++) {
			if(this.collec.get(i).getType().startsWith("Livre") || this.collec.get(i).getType().startsWith("Bande")) { //StartsWith permet de comparer le début d'une chaine de caractère
				if(this.collec.get(i).getISBN()==ISBN) {
					System.out.println(this.collec.get(i));
				}
			}
		}
	}
	
	public void rechercheEAN (String EAN) {
		for (int i=0; i<this.collec.size(); i++) {
				if(this.collec.get(i).getEAN()==EAN) {
					System.out.println(this.collec.get(i));
			}
		}
	}
	
	public void nbDocumentsTypes (int dateDebut, int dateFin) {
        int carte=0,cd=0,jeuV=0,jeuS=0,livre=0,revue=0,partition=0,Vinyle=0,BD=0,autre=0;
        for (int i=0;i<this.collec.size();i++){
            int date = Integer.parseInt(this.collec.get(i).getDate());
            if(this.collec.get(i).getType().startsWith("Livre") & dateDebut <= date & dateFin >= date){
                livre+=1;
            }
            else if(this.collec.get(i).getType().startsWith("carte") & dateDebut <= date & dateFin >= date){
                carte+=1;
            }
            else if(this.collec.get(i).getType().startsWith("Disque") & dateDebut <= date & dateFin >= date){
                cd+=+1;
            }
            else if(this.collec.get(i).getType().startsWith("Jeux Videos") & dateDebut <= date & dateFin >= date) {
            	jeuV+=1;
            }
            else if(this.collec.get(i).getType().startsWith("Jeu de societe") & dateDebut <= date & dateFin >= date) {
            	jeuS+=1;
            }
            else if(this.collec.get(i).getType().startsWith("Revue") & dateDebut <= date & dateFin >= date) {
            	revue+=1;
            }
            else if(this.collec.get(i).getType().startsWith("Partition") & dateDebut <= date & dateFin >= date) {
            	partition+=1;
            }
            else if(this.collec.get(i).getType().startsWith("Vinyle") & dateDebut <= date & dateFin >= date) {
            	Vinyle+=1;
            }
            else if(this.collec.get(i).getType().startsWith("Bande") & dateDebut <= date & dateFin >= date) {
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

	
	//Creation d'objets
	//On cree 5 objets pour chaque bibliotheque comprenant un ID, un nom et une collection de documents
	/*
	Bibliotheque AimeCesaire = new Bibliotheque(1,"AimeCesaire",this.collec);
	Bibliotheque EdmondRostand = new Bibliotheque(2,"EdmondRostand",this.collec);
	Bibliotheque JeanPierreMelville = new Bibliotheque(3,"JeanPierreMelville",this.collec);
	Bibliotheque OscarWilde = new Bibliotheque(4,"OscarWilde",this.collec);
	Bibliotheque SaintSimon = new Bibliotheque(5,"SaintSimon",this.collec);
	*/
	
}


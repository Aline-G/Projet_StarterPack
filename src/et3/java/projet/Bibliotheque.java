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
	
	
	private HashMap <String, Utilisateur> listeUtilisateur;
	public HashMap <String, Integer> listeExemplaires;
	public HashMap <String, Document> listeDocs;
	
	
	
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
	
	//Methodes
	
	
	public boolean estDisponible (Document doc) {
		boolean peutModifier=false;
			if(listeExemplaires.get(doc.getKey())>0) {
				peutModifier=true; 
			}
		return peutModifier;
	}
	
	public void consulterDocument() {
		for(String key: listeDocs.keySet()){
			System.out.println(listeDocs.get(key).getTitle());
		}
	}
	
	
	public boolean emprunter (Utilisateur user, Document doc) {
		if(user.getQuota()<=5 && this.estDisponible(doc)) { //On décide arbitrairement que le quota maximum est de 5 emprunts
			user.setQuota(user.getQuota()-1);
			listeExemplaires.put(doc.getKey(),listeExemplaires.get(doc.getKey())-1);
			user.listeEmprunts.put(doc.getKey(),doc);
			return true;
		}else {
			System.out.println("Vous ne pouvez pas emprunter dans cette bibliothèque");
			return false;
		}	
	}
	
	public void rendre (Utilisateur user, Document doc) {
			user.setQuota(user.getQuota()+1);
			listeExemplaires.put(doc.getKey(),listeExemplaires.get(doc.getKey())+1);
		}	
	
	public void ajoutDocument (Document doc, int nbExemplaires) {
		String key=doc.getKey();
		listeDocs.put(key,doc);
		listeExemplaires.put(key,nbExemplaires);
	}
	
	public void ajoutUtilisateur (int quota,String nom,String prenom){
		Utilisateur User= new Utilisateur (quota,nom,prenom,this);
		listeUtilisateur.put(nom+prenom+User.getIdUser(),User); 
	}
	
	
	//Pour cette fonction on affiche tous les documents
	public void ConsulterDocument() {
		for(String key: listeDocs.keySet()) {
			System.out.println(listeDocs.get(key).getTitle());
		}
	}
	
	
	public void trierParAuteurName(String authorName) {
		for(String key: listeDocs.keySet()) {
			if (listeDocs.get(key).getAuthorName() == authorName) {
				System.out.println(listeDocs.get(key).getTitle());
			}
		}
	}	
		
	
	public void trierParAuteurSurname(String authorSurname) {
		for(String key: listeDocs.keySet()) {
			if (listeDocs.get(key).getAuthorSurname() == authorSurname) {
				System.out.println(listeDocs.get(key).getTitle());
			}
		}
	}
	
	
	public void trierParAuteur(String authorName, String authorSurname) {
		for(String key: listeDocs.keySet()) {
			if (listeDocs.get(key).getAuthorName() == authorName && listeDocs.get(key).getAuthorSurname() == authorSurname ) {
				System.out.println(listeDocs.get(key).getTitle());
			}
		}
	}
	
	public void rechercheISBN(String ISBN) {
		for(String key: listeDocs.keySet()) {
				if(listeDocs.get(key).getISBN()==ISBN) {
					System.out.println(listeDocs.get(key).getISBN());
				}
		}
	}
	
	public void rechercheEAN(String EAN) {
		for(String key: listeDocs.keySet()) {
				if(listeDocs.get(key).getEAN()==EAN) {
					System.out.println(listeDocs.get(key).getEAN());
				}
		}
	}
	
	public void nbDocumentsTypes (int dateDebut, int dateFin) {
        int carte=0,cd=0,jeuV=0,jeuS=0,livre=0,revue=0,partition=0,Vinyle=0,BD=0,autre=0;
        for(String key: listeDocs.keySet()) {
            int date = Integer.parseInt(listeDocs.get(key).getDate());
            
            if(listeDocs.get(key) instanceof Livre && dateDebut <= date & dateFin >= date){
                livre+=1;
            }
            else if(listeDocs.get(key) instanceof Carte && dateDebut <= date & dateFin >= date){
                carte+=1;
            }
            else if(listeDocs.get(key) instanceof CD  && dateDebut <= date & dateFin >= date){
                cd+=+1;
            }
            else if(listeDocs.get(key) instanceof JeuVideo && dateDebut <= date & dateFin >= date) {
            	jeuV+=1;
            }
            else if(listeDocs.get(key) instanceof JeuDeSociete && dateDebut <= date & dateFin >= date) {
            	jeuS+=1;
            }
            else if(listeDocs.get(key) instanceof Revue && dateDebut <= date & dateFin >= date) {
            	revue+=1;
            }
            else if(listeDocs.get(key) instanceof Partition && dateDebut <= date & dateFin >= date) {
            	partition+=1;
            }
            else if(listeDocs.get(key) instanceof Vinyle && dateDebut <= date & dateFin >= date) {
            	Vinyle+=1;
            }
            else if(listeDocs.get(key) instanceof BandeDessinee && dateDebut <= date & dateFin >= date) {
            	BD+=1;
            }
            else if(dateDebut <= date && dateFin >= date) {
            	autre+=1;
            }  
          }
	       System.out.println("Le nombre de documents par types sont :" + "\n");
	       System.out.println("Les livres : " + livre + "\n");
	       System.out.println("Les cartes : " + carte + "\n");
	       System.out.println("Les disques : " + cd + "\n");
	       System.out.println("Les jeux videos : " + jeuV + "\n");
	       System.out.println("Les jeux de societes : " + jeuS + "\n");
	       System.out.println("Les revues : " + revue + "\n");
	       System.out.println("Les partitions : " + partition + "\n");
	       System.out.println("Les vinyles : " + Vinyle + "\n");
	       System.out.println("Les Bandes dessinees : " + BD + "\n");
	       System.out.println("Les autres : " + autre + "\n");
       }
}


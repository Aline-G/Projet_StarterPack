package et3.java.projet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import et3.java.projet.data.FileReader;


public class Bibliotheque {

	//Variables
	
	private String nom;
	private Reseau res;
	
	
	//liste des utilisateurs associés à une bibliothèque
	
	
	public HashMap <String, Utilisateur> listeUtilisateur = new HashMap();
	public HashMap <String, Integer> listeExemplaires = new HashMap();
	public HashMap <String, Document> listeDocs= new HashMap(); 
	
	
	
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
	
	
	/**
	    * Méthode qui permet de vérifier si un document est disponible dans la bibliotheque concernee (dispose d'un exeplaire au moins). 
	    * Renvoi un booleen à true si le document est disponible, faux sinon.
	    * Est utilisee dans la méthode d'échange de documents
	    * 
	    * @param  //Document : le document dont on souhaite vérifier la disponibilité
	    * 
	    */
	public boolean estDisponible (Document doc) {
		boolean peutModifier=false;
		if(listeExemplaires.get(doc.getKey()) != null) {
			if(listeExemplaires.get(doc.getKey())>0) {
				peutModifier=true; 
			}
		}	
		return peutModifier;
	}
	
	
	/**
	    * Permet d'afficher le titre de l'ensemble des documents de la bibliotheque concernee.
	    * 
	    * @param  
	    * 
	    */
	public void consulterDocument() {
		for(String key: listeDocs.keySet()){
			System.out.println(listeDocs.get(key).getTitle());
		}
	}
	
	
	/**
	    * Méthode qui permet d'emprunter un document dans une bibliotheque. 
	    * Le quota à ne pas dépassser a été initialisé à 5 arbitrairement.
	    * Cette méthode test si le quota n'est pas dépassé et si le document est disponible pour un utilisateur spécifique.
	    * Ensuite on retrait un exemplaire dans la liste d'exemplaires de la bibliotheque concernee.
	    * On ajoute le document dans la liste d'emprunts de l'utilisateur.
	    * Un message s'affiche si le document ne peut pas être emprunté.
	    * 
	    * @param  //Utilisateur : user , Document doc ; On prend en paramètre un document et un utilisateur qui souhaite empruter ce document particulier.
	    * 
	    */
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
	
	
	/**
	    *Méthode qui permet de rendre un document emprunté au préalable par un utilisateur à une bibliotheque.
	    *Cette méthode retire le document dans la liste de  
	    * 
	    * @param  //Utilisateur : user , Document doc ; On prend en paramètre un document et un utilisateur qui souhaite empruter ce document particulier.
	    * 
	    */
	public void rendre (Utilisateur user, Document doc) {
			user.setQuota(user.getQuota()+1);
			listeExemplaires.put(doc.getKey(),listeExemplaires.get(doc.getKey())+1);
			user.listeEmprunts.remove(doc.getKey(),doc);
		}	
	
	/**
	    	Ajoute un document sans vérifier que l'ean et l'isbn ne sont pas 
	 	* déjà existant (uniquement utilisée pour chargée les données depuis le
	 	* CSV.
	    * 
	    * @param  //Documents  Document que l'on souhaite ajouter.
	    * 
	    */
	public void ajoutDocument (Document doc, int nbExemplaires) {
		String key=doc.getKey();
		listeDocs.put(key,doc);
		listeExemplaires.put(key,nbExemplaires);
	}
	
		/**
		* 
		*	Ajoute un utilisateur selon son quota, son nom, et son prenom à la bibliotheque courante
		* 	Ajoute cet utilisateur à la liste d'utilisateur de la bibliotheque.
		* 
		* 	@param  quota, le quota de livre de l'utilisateur, le nom et le prenom 
		* 
		*/
	public void ajoutUtilisateur (int quota,String nom,String prenom){
		Utilisateur User= new Utilisateur (quota,nom,prenom,this);
		listeUtilisateur.put(nom+prenom+User.getIdUser(),User); 
	}
	
	/**
	*	Renvoi le titre des livres d'une bibliotheque courante pour un même prénom d'auteur
	*
	* 	@param authorName,le prenom de l'auteur pour lequel on doit trier.
	* 
	*/
	public void trierParAuteurName(String authorName) {
		boolean trouve=false;
		for(String key: listeDocs.keySet()) {
			if (listeDocs.get(key).getAuthorName().contentEquals(authorName)) {
				System.out.println(listeDocs.get(key).getTitle());
				trouve=true;
			}
		}
		if(trouve==false) {
			System.out.println("Aucune correspondance n'a été trouvée");
		}	
	}	
		
	/**
	*	Renvoi le titre des livres d'une bibliotheque courante pour un même nom auteur
	*
	* 	@param //authorName,le nom de l'auteur pour lequel on doit trier.
	* 
	*/
	public void trierParAuteurSurname(String authorSurname) {
		boolean trouve=false;
		for(String key: listeDocs.keySet()) {
			if (listeDocs.get(key).getAuthorSurname().contentEquals(authorSurname)) {
				System.out.println(listeDocs.get(key).getTitle());
				trouve=true;
			}
		}
		if(trouve==false) {
			System.out.println("Aucune correspondance n'a été trouvée");
		}	
	}
	
	
	/**
	*	Renvoi le titre des livres d'une bibliotheque courante pour un même nom et prénom d'auteur
	*
	* 	@param authorName,le nom et le prenom de l'auteur pour lequel on doit trier.
	* 
	*/
	public void trierParAuteur(String authorName, String authorSurname) {
		boolean trouve=false;
		for(String key: listeDocs.keySet()) {
			if (listeDocs.get(key).getAuthorName().equals(authorName) && listeDocs.get(key).getAuthorSurname().equals(authorSurname)) {
				System.out.println(listeDocs.get(key).getTitle());
				trouve=true;
			}
		}
		if(trouve==false) {
			System.out.println("Aucune correspondance n'a été trouvée");
		}	
	}
	

	public void rechercheISBN(String ISBN) {
		for(String key: listeDocs.keySet()) {
			if(listeDocs.get(key) != null ) {
				if(listeDocs.get(key).getISBN()!=null) {
					if(listeDocs.get(key).getISBN().equals(ISBN)) {
						System.out.println(listeDocs.get(key).getTitle());
					}
				}
			}
		}
	}
	
	public void rechercheEAN(String EAN) {
		for(String key: listeDocs.keySet()) {
			if(listeDocs.get(key) != null ) {
				if(listeDocs.get(key).getEAN().equals(EAN)) {
					System.out.println(listeDocs.get(key).getTitle());
				}
			}	
		}
	}
	
	public void nbDocumentsTypes (int dateDebut, int dateFin) {
        int carte=0,cd=0,jeuV=0,jeuS=0,livre=0,revue=0,partition=0,Vinyle=0,BD=0,autre=0;
        for(String key: listeDocs.keySet()) {
            int date = Integer.parseInt(listeDocs.get(key).getDate());
            
            if(listeDocs.get(key) instanceof Livre && dateDebut <= date && dateFin >= date){
                livre+=1;
            }
            else if(listeDocs.get(key) instanceof Carte && dateDebut <= date && dateFin >= date){
                carte+=1;
            }
            else if(listeDocs.get(key) instanceof CD  && dateDebut <= date && dateFin >= date){
                cd+=+1;
            }
            else if(listeDocs.get(key) instanceof JeuVideo && dateDebut <= date && dateFin >= date) {
            	jeuV+=1;
            }
            else if(listeDocs.get(key) instanceof JeuDeSociete && dateDebut <= date && dateFin >= date) {
            	jeuS+=1;
            }
            else if(listeDocs.get(key) instanceof Revue && dateDebut <= date && dateFin >= date) {
            	revue+=1;
            }
            else if(listeDocs.get(key) instanceof Partition && dateDebut <= date && dateFin >= date) {
            	partition+=1;
            }
            else if(listeDocs.get(key) instanceof Vinyle && dateDebut <= date && dateFin >= date) {
            	Vinyle+=1;
            }
            else if(listeDocs.get(key) instanceof BandeDessinee && dateDebut <= date &&dateFin >= date) {
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


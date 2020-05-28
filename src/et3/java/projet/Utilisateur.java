package et3.java.projet;

import java.util.ArrayList;
import java.util.HashMap;


public class Utilisateur {
	
	private Bibliotheque bibli;
	
	//pour ajouter un utilisateur
	
	
	//Variables
	
	private HashMap <String, Document> listeEmprunts;;
	private int quota;
	private String nom;
	private String prenom;
	private int idUser;
	private int compteur=0;
	
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

			
	//Méthodes
	
	
	
	public boolean emprunter (int limiteQuota, int idBiblio, Document doc) {
		if(this.getQuota()<=limiteQuota & estDisponible(doc)) {
			switch (idBiblio) {
			  case 1:
			    doc.setNumberCopyAimeCesaire(doc.getNumberCopyAimeCesaire()-1);
			    break;
			  case 2:
				  doc.setNumberCopyEdmondRostand(doc.getNumberCopyEdmondRostand()-1);
			    break;
			  case 3:
				  doc.setNumberCopyJeanPierreMelville(doc.getNumberCopyJeanPierreMelville()-1);
			    break;
			  case 4:
				  doc.setNumberCopyOscarWilde(doc.getNumberCopyOscarWilde()-1);
			    break;
			  case 5:
				  doc.setNumberCopySaintSimon(doc.getNumberCopySaintSimon()-1);
			    break;
			}
			this.setQuota(this.getQuota()-1);
			return true;
		}else {
			return false;
		}
		
	}
	

	public void rendre (int idBiblio, Document doc) {
		switch (idBiblio) {
		 case 1:
			  doc.setNumberCopyAimeCesaire(doc.getNumberCopyAimeCesaire()+1);
			  break;
		 case 2:
			  doc.setNumberCopyEdmondRostand(doc.getNumberCopyEdmondRostand()+1);
			  break;
		 case 3:
			  doc.setNumberCopyJeanPierreMelville(doc.getNumberCopyJeanPierreMelville()+1);
			  break;
		 case 4:
			  doc.setNumberCopyOscarWilde(doc.getNumberCopyOscarWilde()+1);
			  break;
		 case 5:
		  	  doc.setNumberCopySaintSimon(doc.getNumberCopySaintSimon()+1);
			  break;
		}
		this.setQuota(this.getQuota()+1);
	}
}


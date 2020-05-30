package et3.java.projet;

import java.util.ArrayList;
import java.util.Collections;

public class Serie {
	


	public ArrayList<Document> series = new ArrayList<Document>();
	private String nom;
	
	
	public Serie(String nom, ArrayList<Document> series) {
		this.nom=nom;
		this.series=series;
	}

	public void trierSerie(String nom) {
		ArrayList<Document> liste = new ArrayList<Document>();
		ArrayList<String> tableau = new ArrayList<String>();
		
		for (int i=0;i<series.size();i++) {
			if (series.get(i).getSerieTitle()==nom) {
				liste.add(series.get(i));				//On ajoute le document à une liste temporaire
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
	
	public String getNom() {
		return nom;
	}

}



package et3.java.projet.application;

import java.io.File;
import java.util.ArrayList;

import et3.java.projet.Reseau;
import et3.java.projet.Utilisateur;
import et3.java.projet.data.FileReader;
import et3.java.projet.Bibliotheque;
import et3.java.projet.Document;
import et3.java.projet.Menu;
import et3.java.projet.BandeDessinee;

public class Main 
{
	public static void main(String[] args) 
	{
		 ArrayList<ArrayList<String>> docs = new ArrayList<ArrayList<String>>();
		 
		if(args.length > 0)
		{
			File tempFile = new File(args[0]);
			
			if(tempFile.exists())
			{
				System.out.println("[Main] Reading the file " + args[0] + " ...");
						
				//We start by reading the CSV file
				FileReader.getDataFromCSVFile(args[0],docs);
				
				System.out.println("[Main] End of the file " + args[0] + ".");
			}
			else
			{
				System.out.println("[Main] No file " + args[0]);
			}
			
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////// TEST //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			Reseau reseau =new Reseau(docs);
			Bibliotheque bibli = new Bibliotheque("Aline",reseau);
			//BandeDessinee bd = new BandeDessinee("2-205-00863-3","","Brave et honnete Achille Talon | Texte imprime | Greg","Dargaud","1975","Achille Talon","[9]","Greg","");
			/*Document A = new Document("9782012020719","Les Six compagnons a Scotland Yard | Texte imprime | Paul-Jacques Bonzon","Hachette jeunesse","DL 2010","Les six compagnons","4","Bonzon","Paul-Jacques") {
				@Override
            public String getISBN() {
                return null;
            }
			};
			Document B =  new Document("9782012032996","L'equation de l'amour et du hasard | Texte imprime | Jennifer E. Smith | traduit de l'anglais (etats-Unis) par Frederique Le Boucher","Hachette","DL 2013","","","Smith","Jennifer E.") {
				@Override
	            public String getISBN() {
	                return null;
	            }
	        };
	       
			
			ArrayList<Document>array = new ArrayList<Document>();
			array.add(A);
			array.add(B);
			*/
			/*
			 Document C =  new Document("9782012039391","Le refuge du Grand Baou | Texte imprime | Cecile Aubry | [illustrations de Annette Marnat]","Hachette","DL 2013","Belle et Sebastien","1","Aubry","Cecile") {
					@Override
		            public String getISBN() {
		                return null;
		            }
		        };
		        
		     */
			
		    /*    
		     Utilisateur user = new Utilisateur(2,"Aline","Giordano",reseau.renvoiBibli("AimeCesaire"));
		     reseau.renvoiBibli("AimeCesaire").ajoutUtilisateur(2, "Aline", "labellegosse");
		     for(String key: reseau.renvoiBibli("AimeCesaire").listeUtilisateur.keySet()){
		    	 	System.out.println(reseau.renvoiBibli("AimeCesaire").listeUtilisateur.get(key).getNom());
				}
		    */
		      
		     // System.out.println(reseau.renvoiBibli("AimeCesaire").emprunter(user, C));
		      
		    //reseau.ajoutSeries("Achille Talon", bd);
			//System.out.println(reseau.listeSeries);
			//reseau.consulterDocument();
			//reseau.trierParAuteur("Emmanuelle","Remond");
			//reseau.trierParAuteurSurname("Remond");
			//reseau.trierParAuteurName("Emmanuelle");
			
			//reseau.renvoiBibli("AimeCesaire").trierParAuteur("Ai","Yazawa");
			//reseau.renvoiBibli("AimeCesaire").trierParAuteurSurname("Yazawa");
			//reseau.renvoiBibli("AimeCesaire").trierParAuteurName("Ai");
			
			//reseau.echange(array,reseau.renvoiBibli("AimeCesaire"),bibli);
			
			//bibli.consulterDocument();
			
			//reseau.renvoiBibli("AimeCesaire").rechercheEAN("9782021004892");
			//reseau.renvoiBibli("AimeCesaire").rechercheISBN("2-7467-0165-0");
			
			//reseau.rechercheEAN("9782021004892");
			//reseau.rechercheISBN("2-7467-0165-0");
			
			reseau.ajoutBiblio(bibli);
			
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////// TEST //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			while(true) {
				Menu.MenuPrincipal(docs);
			}
			
		}
		else
		{
			System.out.println("[Main] You should enter the CSV file path as a parameters.");
		}
		
		Reseau res = new Reseau(docs);
	}
}

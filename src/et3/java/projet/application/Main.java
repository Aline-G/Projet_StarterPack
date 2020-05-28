package et3.java.projet.application;

import java.io.File;
import java.util.ArrayList;

import et3.java.projet.Reseau;
import et3.java.projet.data.FileReader;
import et3.java.projet.Bibliotheque;
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
			
			/*
			Reseau reseau =new Reseau(docs);
			Bibliotheque bibli = new Bibliotheque("Aline",reseau);
			BandeDessinee bd = new BandeDessinee("2-205-00863-3","","Brave et honnete Achille Talon | Texte imprime | Greg","Dargaud","1975","Achille Talon","[9]","Greg","");
			reseau.ajoutSeries("Achille Talon", bd);
			System.out.println(reseau.listeSeries);
			
			
			reseau.ajoutBiblio(bibli);
			*/
			while(true) {
				Menu.MenuPrincipal(docs);
			}

		}
		else
		{
			System.out.println("[Main] You should enter the CSV file path as a parameters.");
		}

	}
}

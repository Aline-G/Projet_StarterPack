package et3.java.projet.application;

import java.io.File;
import java.util.ArrayList;

import et3.java.projet.Reseau;
import et3.java.projet.data.FileReader;

public class Main 
{
	public static void main(String[] args) 
	{
		 ArrayList<ArrayList> docs = new ArrayList<ArrayList>();
		 
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
		}
		else
		{
			System.out.println("[Main] You should enter the CSV file path as a parameters.");
		}
		
		//TODO Project :)
		Reseau res = new Reseau(docs);
	}
}

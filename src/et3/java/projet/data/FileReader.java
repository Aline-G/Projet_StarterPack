package et3.java.projet.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import et3.java.projet.Bibliotheque;
import et3.java.projet.Document;
import et3.java.projet.Livre;

public class FileReader {

/*
	static ArrayList<Document> collecA = new ArrayList<Document>();
	static ArrayList<Document> collecE = new ArrayList<Document>();
	static ArrayList<Document> collecJ = new ArrayList<Document>();
	static ArrayList<Document> collecO = new ArrayList<Document>();
	static ArrayList<Document> collecS = new ArrayList<Document>();
	
	public static ArrayList<Document> getCollecA() {
		return collecA;
	}

	public static ArrayList<Document> getCollecE() {
		return collecE;
	}

	public static ArrayList<Document> getCollecJ() {
		return collecJ;
	}

	public static ArrayList<Document> getCollecO() {
		return collecO;
	}

	public static ArrayList<Document> getCollecS() {
		return collecS;
	}*/

	public static void getDataFromCSVFile(String csvFilePath, ArrayList<ArrayList<String>> collec)
	{
        String line = "";
        String[] data = null;
        String separator = ";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        
        //Document data
        String isbn;
        String ean;
        String title;
        String publisher;
        String date;
        String seriesTitle;
        Integer seriesNumber;
        String authorName;
        String authorSurname;
        String type;
        int totalCopies;
        int numberCopyAimeCesaire;
        int numberCopyEdmondRostand;
        int numberCopyJeanPierreMelville;
        int numberCopyOscarWilde;
        int numberCopySaintSimon;
        
        
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(csvFilePath), StandardCharsets.ISO_8859_1)) 
        {
        	//Read the first line
        	line = bufferedReader.readLine();
        	
        	//Get data from the line
        	data = line.split(separator, -1);
        	
        	if(data.length != 16)
        	{
        		System.out.println("[FileReader] The file at " + csvFilePath + " does not contain the right number of columns.");
        		return;
        	}
        	
        	int i = 1;
        	
        	//Read the file line by line
            while ((line = bufferedReader.readLine()) != null)
            {
            	//Get data from the line
            	data = line.split(separator, -1);
            	
            	//Sort data
            		
            		//Get the ISBN number
            		isbn = data[0];
            		
            		//Get the EAN number
            		ean = data[1];
            		
            		//Get the title of the document
            		title = data[2];

            		//Get the name of the publisher
            		publisher = data[3];
            		
            		//Get the publication date
            		try
            		{
            			int dateInt = Integer.parseInt(data[4].replaceAll("[^0-9]", ""));
            			
            			if(dateInt%10000 >= 2021 || dateInt%10000 < 0)
            			{
            				date = "?";
            			}
            			else if(dateInt/10000 == 0)
            			{
            				date = Integer.toString(dateInt%10000);
            			}
            			else
            			{
            				date = dateInt%10000 + "-" + dateInt/10000;
            			}
            		}
            		catch (Exception exception)
            		{
            			date = "?";
            		}
            		
            		//Get the title of the series
            		seriesTitle = data[5];
            		
            		//Get the number of this document in the series
            		try
            		{
            			seriesNumber = Integer.parseInt(data[6]);
            		}
            		catch (Exception exception)
            		{
            			seriesNumber = null;
            		}
            		
            		//Get the name of the author
            		authorSurname = data[7];
            		
            		//Get the surname of the author
            		authorName = data[8];
            		
            		//Get the type of the document
            		type = data[9];
            		
            		//Get the total number of copy in Paris for this document 
            		try
            		{
            			totalCopies = Integer.parseInt(data[10]);
            		}
            		catch (Exception exception)
            		{
            			totalCopies = 0;
            		}
            		
            		//Get the number of copy in the library "Aime Cesaire"
            		try
            		{
            			numberCopyAimeCesaire = Integer.parseInt(data[11]);
            		}
            		catch (Exception exception)
            		{
            			numberCopyAimeCesaire = 0;
            		}
            		
            		//Get the number of copy in the library "Edmond Rostand"
            		try
            		{
            			numberCopyEdmondRostand = Integer.parseInt(data[12]);
            		}
            		catch (Exception exception)
            		{
            			numberCopyEdmondRostand = 0;
            		}
            		
            		//Get the number of copy in the library "Jean-Pierre Melville"
            		try
            		{
            			numberCopyJeanPierreMelville = Integer.parseInt(data[13]);
            		}
            		catch (Exception exception)
            		{
            			numberCopyJeanPierreMelville = 0;
            		}
            		
            		//Get the number of copy in the library "Oscar Wilde"
            		try
            		{
            			numberCopyOscarWilde = Integer.parseInt(data[14]);
            		}
            		catch (Exception exception)
            		{
            			numberCopyOscarWilde = 0;
            		}
            		
            		//Get the number of copy in the library "Saint-Simon"
            		try
            		{
            			numberCopySaintSimon = Integer.parseInt(data[15]);
            		}
            		catch (Exception exception)
            		{
            			numberCopySaintSimon = 0;
            		}
                
                //TODO Do something with data
            		
            		ArrayList ajoutColonne = new ArrayList();
            		
            		ajoutColonne.add(""+(String)isbn);
            		ajoutColonne.add(""+(String)ean);
            		ajoutColonne.add(""+(String)title);
            		ajoutColonne.add(""+(String)publisher);
            		
            		try {
            			date=date.replaceAll("[^0-9]", "");
            		}catch(Exception e) {
            			date=""+Integer.MIN_VALUE;
            		}
            		if (date.equals("")) date = ""+Integer.MIN_VALUE;
            		
            		ajoutColonne.add(""+(String)date);
            		ajoutColonne.add(""+(String)seriesTitle);
            		ajoutColonne.add(""+seriesNumber);
            		ajoutColonne.add(""+(String)authorName);
            		ajoutColonne.add(""+(String)authorSurname);
            		ajoutColonne.add(""+(String)type);
            		ajoutColonne.add(""+totalCopies);
            		ajoutColonne.add(""+numberCopyAimeCesaire);
            		ajoutColonne.add(""+numberCopyEdmondRostand);
            		ajoutColonne.add(""+numberCopyJeanPierreMelville);
            		ajoutColonne.add(""+numberCopyOscarWilde);
            		ajoutColonne.add(""+numberCopySaintSimon);
            		
            		collec.add(ajoutColonne);
            		
            	/*
                System.out.println(
                		isbn + ";" +
                		ean + ";" +
                		title + ";" +
                		publisher + ";" +
                		date + ";" +
                		seriesTitle + ";" +
                		seriesNumber + ";" +
                		authorName + ";" +
                		authorSurname + ";" +
                		type + ";" +
                		totalCopies + ";" +
                		numberCopyAimeCesaire + ";" +
                		numberCopyEdmondRostand + ";" +
                		numberCopyJeanPierreMelville + ";" +
                		numberCopyOscarWilde + ";" +
                		numberCopySaintSimon);
                		*/
            }
        }
		

	
        catch (IOException exception) 
        {
            System.err.println(exception);
        }
	}
}

package et3.java.projet;

public class Livre extends Document {

	//Variables
	private String ISBN;
	
	//Constructeurs
	
	public Livre(String ISBN,String EAN,String title,String publisher,String date,String serieTitle,String serieNumber,String authorSurname,String authorName) {
		
		super(EAN,title,publisher,date,serieTitle,serieNumber, authorSurname, authorName);
		this.ISBN=ISBN;
		
	}
	
	//Getters and Setters

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


}

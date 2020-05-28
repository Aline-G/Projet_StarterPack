package et3.java.projet;

public class BandeDessinee extends Livre {
	//Variables
	private String ISBN;

	//Constructeur
	public BandeDessinee(String ISBN, String EAN, String title, String publisher, String date, String serieTitle, String serieNumber, String authorSurname, String authorName) {
		super(ISBN, EAN, title, publisher, date, serieTitle, serieNumber, authorSurname, authorName);
	}

	//Getters and Setters

	public String getISBN(){
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	

}

package et3.java.projet;

public class Carte extends Livre {
	//Constructeur
	public Carte(String ISBN,String EAN,String title,String publisher,String date,String serieTitle,String serieNumber,String authorSurname,String authorName) {
		super(ISBN,EAN, title, publisher, date,serieTitle,serieNumber,authorSurname, authorName);
	}

	public String getISBN() {
		String ISBN="";
		return ISBN;
	}

}

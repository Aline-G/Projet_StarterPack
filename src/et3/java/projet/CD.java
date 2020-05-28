package et3.java.projet;

public class CD extends Document {
	//Constructeur
	public CD (String EAN,String title,String publisher,String date,String serieTitle,String serieNumber,String authorSurname,String authorName) {
		super(EAN, title, publisher, date, serieTitle,serieNumber, authorSurname, authorName);
	}

	public String getISBN() {
		String ISBN="";
		return ISBN;
	}

}

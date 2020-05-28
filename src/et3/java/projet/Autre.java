package et3.java.projet;

public class Autre extends Document {

    public Autre(String EAN, String title, String publisher, String date, String serieTitle, String serieNumber, String authorSurname, String authorName) {
        super(EAN, title, publisher, date, serieTitle, serieNumber, authorSurname, authorName);
    }

    public String getISBN() {
        String ISBN="";
        return ISBN;
    }
}
package et3.java.projet;

public class Revue extends Document {
    //Constructeur
    public Revue(String EAN, String title, String publisher, String date, String serieTitle, String serieNumber, String authorSurname, String authorName) {
        super(EAN, title, publisher, date, serieTitle, serieNumber, authorSurname, authorName);
    }

    public String getISBN() {
        String ISBN="";
        return ISBN;
    }

}

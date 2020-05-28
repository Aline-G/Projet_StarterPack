package et3.java.projet;

public class JeuVideo extends Document{
    //Constructeur
    public JeuVideo(String EAN, String title, String publisher, String date, String serieTitle, String serieNumber, String authorSurname, String authorName) {
        super(EAN, title, publisher, date, serieTitle, serieNumber, authorSurname, authorName);
    }

    public String getISBN() {
        String ISBN="";
        return ISBN;
    }

}

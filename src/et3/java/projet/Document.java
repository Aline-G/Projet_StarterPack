package et3.java.projet;

public class Document {
	
	//Variables
		private String EAN;
		private String title;
		private String publisher;
		private String date;
		private String serieTitle;
		private String serieNumber;
		private String authorSurname;
		private String authorName;
		private String type;
		
		//Constructeurs
		
		public Document (String EAN,String title,String publisher,String date,String serieTitle,String serieNumber,String authorSurname,String authorName,String type) {
			this.EAN=EAN;
			this.title=title;
			this.publisher=publisher;
			this.date=date;
			this.serieTitle=serieTitle;
			this.serieNumber=serieNumber;
			this.authorSurname=authorSurname;
			this.authorName=authorName;
			this.type=type;
		}
		
		//Getters 
		
		
		public String getSerieTitle() {
			return serieTitle;
		}

		public String getDate() {
			return date;
		}

		public String getEAN() {
			return EAN;
		}
		
		public String getType() {
			return type;
		}

		
		//Setters
		
		public void setDate(String date) {
			this.date = date;
		}
		
		
		
		//Méthodes
	}



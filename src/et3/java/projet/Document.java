package et3.java.projet;


public abstract class Document {

		//Variables
		
		private String EAN;
		private String title;
		private String publisher;
		private String date;
		private String serieTitle;
		private String serieNumber;
		private String authorSurname;
		private String authorName;
		
		//Constructeurs
		
		public Document (String EAN,String title,String publisher,String date,String serieTitle,String serieNumber,String authorSurname,String authorName) {
	
			this.EAN=EAN;
			this.title=title;
			this.publisher=publisher;
			this.date=date;
			this.serieTitle=serieTitle;
			this.serieNumber=serieNumber;
			this.authorSurname=authorSurname;
			this.authorName=authorName;
		}
		
		//Getters 
		
		
		public String getSerieTitle() {
			return serieTitle;
		}
		
		public String getTitle() {
			return title;
		}
		public String getAuthorSurname() {
			return authorSurname;
		}

		public String getAuthorName() {
			return authorName;
		}

		public String getDate() {
			return date;
		}
		
		public String getPublisher() {
			return publisher;
		}
		
		public String getSerieNumber() {
			return serieNumber;
		}
		

		public String getEAN() {
			return EAN;
		}
		
		public abstract String getISBN();
		
		public String getKey() {
			if(!EAN.equals("")){
				return EAN;
			}
			else {
				return getISBN();
			}
		}
		

		
		//Setters
		
		public void setDate(String date) {
			this.date = date;
		}	
		
	}



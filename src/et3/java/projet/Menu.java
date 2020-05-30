package et3.java.projet;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void MenuPrincipal(ArrayList<ArrayList<String>> documents) {
        Reseau reseau = new Reseau(documents);
        Scanner entree = new Scanner(System.in);

        while (true) {
            System.out.println("----- Menu principal -----");
            System.out.println("");
            System.out.println("1. Consulter");
            System.out.println("2. Ajouter");
            System.out.println("3. Rechercher dans le reseau");
            System.out.println("4. Menu Utilisateur");
            System.out.println("5. Quitter");
            System.out.println("");
            System.out.println("A vous de choisir !");

            String choix = entree.next();
            switch (choix) {
                case "1":
                    menuConsulter(entree, reseau);
                    break;
                case "2":
                    menuAjouter(entree, reseau);
                    break;
                case "3":
                    menuRechercher(entree, reseau);
                    break;
                case "4":
                    menuUtilisateur(entree,reseau);
                    break;
                case "5":
                    System.exit(0);
                    break;
            }
        }
    }

    private static void menuConsulter(Scanner entree, Reseau reseau) {
        while (true) {
            System.out.println("----- Menu Consulter -----");
            System.out.println("");
            System.out.println("1. Consulter les documents d'une bibliotheque");
            System.out.println("2. Consulter le nombre de publications de tous les types sur une duree donnee");
            System.out.println("3. Consulter tous les documents du reseau");
            String ch = entree.next();
            Scanner sc = new Scanner(System.in);
            switch (ch) {
                case "1":
                    System.out.println("Entrez le nom de la bibliotheque: ");
                    String bibli = sc.nextLine();
                    for (String key : reseau.listeBibli.keySet()) {
                        if (reseau.listeBibli.get(key).getNom().equals(bibli)) {
                            reseau.listeBibli.get(key).consulterDocument();
                        } else {
                            System.out.println("Le nom de bibliotheque saisi n'existe pas");
                        }
                    }
                    break;
                case "2":
                    System.out.println("Saisissez une date de debut :");
                    int datedeb = Integer.parseInt(sc.nextLine());
                    System.out.println("Saisissez une date de fin :");
                    int datefin = Integer.parseInt(sc.nextLine());
                    reseau.nbDocumentsTypes(datedeb, datefin);
                    //ça apparait 5 fois car c'est pour chaque bibliotheque
                    break;
                case "3":
                    reseau.consulterDocument();
                    break;
            }
            break;
        }
        return;
    }


    private static void menuAjouter(Scanner entree, Reseau res) {
        while (true) {
            System.out.println("----- Menu Ajouter -----");
            System.out.println("");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Ajouter un utilisateur");
            System.out.println("3. Ajouter une bibliotheque");
            String choix = entree.next();
            Scanner sc = new Scanner(System.in);
            switch (choix) {
                case "1":
                    System.out.println("Saisissez l'EAN :");
                    String ean = sc.nextLine();
                    System.out.println("Saisissez le titre :");
                    String titre = sc.nextLine();
                    System.out.println("Saisissez le publisher :");
                    String publisher = sc.nextLine();
                    System.out.println("Saisissez la date de publication :");
                    String date = sc.nextLine();
                    System.out.println("Saisissez le titre de la serie :");
                    String serTi = sc.nextLine();
                    System.out.println("Saisissez le numero de serie :");
                    String sereNb = sc.nextLine();
                    System.out.println("Saisissez le prenom de l'auteur :");
                    String prenomA = sc.nextLine();
                    System.out.println("Saisissez le nom de l'auteur :");
                    String nomA = sc.nextLine();
                    System.out.println("Saisissez le nom de la bibliotheque :");
                    String bibliot = sc.nextLine();
                    Document doc = new Document(ean, titre, publisher, date, serTi, sereNb, prenomA, nomA) {
                        @Override
                        public String getISBN() {
                            return null;
                        }
                    };
                    for (String key : res.listeBibli.keySet()) {
                        if (res.listeBibli.get(key).getNom().equals(bibliot)) {
                            res.listeBibli.get(key).ajoutDocument(doc, 1);
                            System.out.println("Le document a été ajouté");
                        }
                    }
                    break;
                case "2":
                    System.out.println("Saisissez votre prenom :");
                    String prenom = sc.nextLine();
                    System.out.println("Saisissez votre nom :");
                    String name = sc.nextLine();
                    System.out.println("Entrez le nom de la bibliotheque: ");
                    String bibli = sc.nextLine();
                    for (String key : res.listeBibli.keySet()) {
                        if (res.listeBibli.get(key).getNom().equals(bibli)) {
                            res.listeBibli.get(key).ajoutUtilisateur(0, name, prenom);
                            System.out.println("Vous êtes bien inscrit");
                        } else {
                            System.out.println("Le nom de bibliothèque saisi n'héxiste pas");
                        }
                    }
                    break;
                case "3":
                    System.out.println("Entrez le nom de la bibliotheque: ");
                    String nom = sc.nextLine();
                    Bibliotheque biblio = new Bibliotheque(nom, res);
                    res.ajoutBiblio(biblio);
                    break;
            }
            break;
        }
        return;
    }

    private static void menuRechercher(Scanner entree, Reseau res) {
        while (true) {
            System.out.println("----- Menu Rechercher dans le reseau -----");
            System.out.println("");
            System.out.println("1. Rechercher par auteur");
            System.out.println("2. Rechercher par ISBN");
            System.out.println("3. Rechercher par EAN");
            String choix = entree.next();
            Scanner sc = new Scanner(System.in);
            switch (choix) {
                case "1":
                    System.out.println("Saisissez un nom d'auteur :");
                    String nomA = sc.nextLine();
                    System.out.println("Saisissez un prénom d'auteur :");
                    String prenomA = sc.nextLine();
                    res.trierParAuteur(nomA, prenomA);
                    break;
                case "2":
                    System.out.println("Saisissez un ISBN :");
                    String isbn = sc.nextLine();
                    res.rechercheISBN(isbn);
                    break;
                case "3":
                    System.out.println("Saisissez un EAN :");
                    String ean = sc.nextLine();
                    res.rechercheEAN(ean);
                    break;
            }
            break;
        }
        return;
    }
    private static void menuUtilisateur(Scanner entree, Reseau res){
        while (true) {
            System.out.println("----- Menu Utilisateur -----");
            System.out.println("");
            System.out.println("1. Emprunter");
            System.out.println("2. Rendre");
            String choix = entree.next();
            Scanner sc = new Scanner(System.in);
            switch (choix) {
                case "1":

                    System.out.println("Saisissez l'ean du doc à emprunter :");
                    String ean = sc.nextLine();
                    System.out.println("Saisissez le nom de la votre bibliotheque :");
                    String bibli = sc.nextLine();
                    System.out.println("Saisissez votre id :");
                    int id = Integer.parseInt(sc.nextLine());

                    for (String key : res.listeBibli.keySet()) {
                        if (res.listeBibli.get(key).getNom().equals(bibli)) {
                            for (String cle : res.listeBibli.get(key).listeUtilisateur.keySet()) {
                                if (res.listeBibli.get(key).listeUtilisateur.get(cle).getIdUser() == id) {
                                    res.listeBibli.get(key).emprunter(res.listeBibli.get(key).listeUtilisateur.get(cle),res.listeBibli.get(key).listeDocs.get(ean));
                                    System.out.println("Vous venez d'emprunter un document");
                                    System.out.println("Le nombre d'exemplaires restants dans cette bibliothèque est : "+ res.listeBibli.get(key).listeExemplaires.get(ean));
                                }
                            }
                        }
                    }
                    break;
                case "2":
                    System.out.println("Saisissez l'ean du doc à rendre :");
                    String EAN = sc.nextLine();
                    System.out.println("Saisissez le nom de la votre bibliotheque :");
                    String biblio = sc.nextLine();
                    System.out.println("Saisissez votre id :");
                    int iduser = Integer.parseInt(sc.nextLine());

                    for (String key : res.listeBibli.keySet()) {
                        if (res.listeBibli.get(key).getNom().equals(biblio)) {
                            for (String cle : res.listeBibli.get(key).listeUtilisateur.keySet()) {
                                if (res.listeBibli.get(key).listeUtilisateur.get(cle).getIdUser() == iduser) {
                                    res.listeBibli.get(key).rendre(res.listeBibli.get(key).listeUtilisateur.get(cle),res.listeBibli.get(key).listeDocs.get(EAN));
                                    System.out.println("Vous venez de rendre un document");
                                    System.out.println("Le nombre d'exemplaires mis à jour dans cette bibliothèque est : "+ res.listeBibli.get(key).listeExemplaires.get(EAN));
                                }
                            }
                        }
                    }
                    break;
            }
            break;
        }
        return;
    }
}

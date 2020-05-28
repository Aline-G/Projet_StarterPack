package et3.java.projet.application;

import et3.java.projet.Bibliotheque;
import et3.java.projet.Reseau;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void MenuPrincipal(ArrayList<ArrayList<String>> documents){
        Reseau reseau = new Reseau(documents);
        Scanner entree = new Scanner(System.in);

        while(true){
            System.out.println("----- Menu principal -----");
            System.out.println("");
            System.out.println("1. Consulter");
            System.out.println("2. Ajouter");
            System.out.println("3. Rechercher");
            System.out.println("4. Quitter");
            System.out.println("");
            System.out.println("A vous de choisir");

            String choix = entree.next();
            switch(choix){
                case "1":
                   // menuConsulter(entree,reseau);
                    break;
                case "2":
                    menuAjouter(entree,reseau);
                    break;
                case "3":
                    menuRechercher(entree,reseau);
                    break;
                case "4":
                    System.exit(0);
                    break;
            }
        }
    }

    private static void menuRechercher(Scanner entree, Reseau res) {
        while(true){
            System.out.println("----- Menu Rechercher -----");
            System.out.println("");
            System.out.println("1. Rechercher un auteur");
            System.out.println("2. Rechercher un ISBN");
            System.out.println("3. Rechercher un EAN");
            String choix = entree.next();
            switch (choix){
                case "1":
                    break;
                case "2":
                    System.out.println("Saisissez un ISBN :");
                    String isbn = entree.nextLine();
                    res.rechercheISBN(isbn);
                    break;
                case "3":
                    System.out.println("Saisissez un EAN :");
                    String ean = entree.nextLine();
                    res.rechercheEAN(ean);
                    break;
            }
            break;
        }
        return;
    }

    private static void menuAjouter(Scanner entree, Reseau res) {
        while(true){
            System.out.println("----- Menu Ajouter -----");
            System.out.println("");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Ajouter un utilisateur");
            System.out.println("3. Ajouter une bibliothèque");
            String choix = entree.next();
            switch (choix){
                case "1":
                    break;
                case "2":
                    System.out.println("Saisissez votre prenom :");
                    String prenom = entree.nextLine();
                    System.out.println("Saisissez votre nom :");
                    String name = entree.nextLine();
                    System.out.println("Entrez le nom de la bibliothèque: ");
                    String bibli = entree.nextLine();
                    for (String key : res.listeBibli.keySet()) {
                        if (res.listeBibli.get(key).getNom() == "bibli") {
                            res.listeBibli.get(key).ajoutUtilisateur(5,name,prenom);
                            System.out.println("Vous êtes bien inscrit");
                        } else {
                            System.out.println("Le nom de bibliothèque saisi n'héxiste pas");
                        }
                    }
                    break;
                case "3":
                    System.out.println("Entrez le nom de la bibliothèque: ");
                    String nom = entree.nextLine();
                    Bibliotheque biblio = new Bibliotheque(nom, res);
                    res.ajoutBiblio(biblio);
                    break;
            }
            break;
        }
        return;
    }


    private static void menuConsulter(Scanner entree, Reseau reseau) {
        while(true){
            System.out.println("----- Menu Consulter -----");
            System.out.println("");
            System.out.println("1. Consulter les documents d'une bibliothèque");
            System.out.println("2. Consulter le nombre de publications de tous les types sur une durée donnée");
            System.out.println("3. Consulter une série de documents");
            System.out.println("4. Consulter tous les documents du réseau");
            String ch = entree.next();
            switch (ch){
                case "1":
                    System.out.println("Entrez le nom de la bibliothèque: ");
                    String bibli = entree.nextLine();
                    for (String key : reseau.listeBibli.keySet()) {
                        if (reseau.listeBibli.get(key).getNom() == "bibli") {
                            reseau.listeBibli.get(key).ConsulterDocument();
                        } else {
                            System.out.println("Le nom de bibliothèque saisi n'héxiste pas");
                        }
                    }
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    reseau.consulterDocument();
                    break;
            }
            break;
        }
        return;
    }

}

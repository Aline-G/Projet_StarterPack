package et3.java.projet.application;

import et3.java.projet.Reseau;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    static void MenuPrincipal(ArrayList<ArrayList> documents){
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
                    menuConsulter(entree);
                    break;
                case "2":
                    menuAjouter(entree);
                    break;
                case "3":
                    menuRechercher(entree);
                    break;
                case "4":
                    System.exit(0);
                    break;
            }
        }
    }

    private static void menuRechercher(Scanner entree) {
        while(true){
            System.out.println("Menu Rechercher");
            System.out.println("");
            System.out.println("1. Rechercher un auteur");
            System.out.println("2. Rechercher un ISBN");
            System.out.println("3. Rechercher un EAN");
            String choix = entree.next();
            switch (choix){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
            }
            break;
        }
        return;
    }

    private static void menuAjouter(Scanner entree) {
        while(true){
            System.out.println("Menu Ajouter");
            System.out.println("");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Ajouter un utilisateur");
            System.out.println("3. Ajouter une bibliothèque");
            String choix = entree.next();
            switch (choix){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
            }
            break;
        }
        return;
    }

    private static void menuConsulter(Scanner entree) {
        while(true){
            System.out.println("Menu Consulter");
            System.out.println("");
            System.out.println("1. Consulter les documents d'une bibliothèque");
            System.out.println("2. Consulter le nombre de publications de tous les types sur une durée donnée");
            System.out.println("3. Consulter une série de documents");
            String choix = entree.next();
            switch (choix){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
            }
            break;
        }
        return;
    }

}

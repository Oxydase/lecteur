package dm.lecteur;

public class LecteurFichier {
    public static void main(String[] args) {
        // Exemple avec un fichier texte
        Fichier fichierTxt = new FichierTexte("dm/lecteur/test.txt");

        // Ouverture du fichier
        fichierTxt.ouvrirFichier();

        // Affichage du contenu à l'endroit
        System.out.println("Contenu du fichier :");
        fichierTxt.afficherContenu();

        // Affichage du contenu à l'envers
        System.out.println("\nContenu du fichier à l'envers :");
        fichierTxt.afficherContenuInverse();

        // Affichage du contenu palindromique
        System.out.println("\nContenu du fichier palindromique :");
        fichierTxt.afficherPalindromique();

        // Comparaison avec un autre fichier
        boolean estIdentique = fichierTxt.comparerFichiers("dm/lecteur/test2.txt");
        System.out.println("\nLes fichiers sont identiques : " + estIdentique);

        // Fermeture du fichier
        fichierTxt.fermerFichier();


        // Exemple avec un fichier CSV

        Fichier fichierCSV = getFichierByType("dm/lecteur/test.csv");

        // Ouverture du fichier
        fichierCSV.ouvrirFichier();

        // Affichage du contenu à l'endroit
        System.out.println("Contenu du fichier :");
        fichierCSV.afficherContenu();

        // Affichage du contenu à l'envers
        System.out.println("\nContenu du fichier à l'envers :");
        fichierCSV.afficherContenuInverse();

        // Fermeture du fichier
        fichierCSV.fermerFichier();

    }

    public static Fichier getFichierByType(String chemin) {
        if (chemin.endsWith(".txt")) {
            return new FichierTexte(chemin);
        } else if (chemin.endsWith(".csv")) {
            return new FichierCSV(chemin);  // Ou passer un autre séparateur ';'
        } else {
            throw new IllegalArgumentException("Format de fichier non supporté !");
        }
    }

}

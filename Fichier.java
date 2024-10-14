package dm.lecteur;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public abstract class Fichier implements Lecteur {
    // Attributs
    protected File fichier;
    protected static final int BUFFER_SIZE = 256;  // Taille du buffer
    protected byte[] buffer = new byte[BUFFER_SIZE];  // Buffer pour stocker les données temporairement

    // Constructeurs
    public Fichier() {
        this.fichier = new File("test.txt");
    }

    public Fichier(String fichier) {
        this.fichier = new File(fichier);
    }

    // Getters et setters
    public File getFichier() {
        return this.fichier;
    }

    public void setFichier(File fichier) {
        this.fichier = fichier;
    }

    // Méthodes abstraites pour ouvrir et fermer un fichier (à implémenter dans les sous-classes)
    public abstract Object ouvrirFichier();
    public abstract Object fermerFichier();

    // Affichage du contenu à l'endroit (utilisant FileInputStream)
    public void afficherContenu() {
        try (FileInputStream fis = new FileInputStream(this.fichier)) {
            int sizeRead;
            while ((sizeRead = fis.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, sizeRead));  // Afficher les données lues
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Affichage du contenu à l'envers (utilisant FileInputStream)
    public void afficherContenuInverse() {
        StringBuilder contenu = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(this.fichier)) {
            int sizeRead;
            while ((sizeRead = fis.read(buffer)) != -1) {
                contenu.append(new String(buffer, 0, sizeRead));  // Stockage du contenu dans un StringBuilder
            }
            // Inverser le contenu ligne par ligne
            String[] lignes = contenu.toString().split("\n");
            for (int i = lignes.length - 1; i >= 0; i--) {
                System.out.println(lignes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Affichage du contenu de manière palindromique (ligne par ligne)
    @Override
    public void afficherPalindromique() {
        StringBuilder contenu = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(this.fichier)) {
            int sizeRead;
            while ((sizeRead = fis.read(buffer)) != -1) {
                contenu.append(new String(buffer, 0, sizeRead));  // Stockage du contenu
            }
            // Inverser les caractères ligne par ligne
            String[] lignes = contenu.toString().split("\\n");
            for (String ligne : lignes) {
                System.out.println(new StringBuilder(ligne).reverse().toString());  // Un palindrome par ligne
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Comparaison de fichiers (ligne par ligne)
    public boolean comparerFichiers(String path2) {
        StringBuilder contenu1 = new StringBuilder();
        StringBuilder contenu2 = new StringBuilder();
        try (FileInputStream fis1 = new FileInputStream(this.fichier);
             FileInputStream fis2 = new FileInputStream(path2)) {
            // Lire le contenu du premier fichier
            int sizeRead;
            while ((sizeRead = fis1.read(buffer)) != -1) {
                contenu1.append(new String(buffer, 0, sizeRead));
            }
            // Lire le contenu du deuxième fichier
            while ((sizeRead = fis2.read(buffer)) != -1) {
                contenu2.append(new String(buffer, 0, sizeRead));
            }
            // Comparer le contenu des deux fichiers
            return contenu1.toString().equals(contenu2.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

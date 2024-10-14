package dm.lecteur;

import java.io.FileInputStream;
import java.io.IOException;

public class FichierCSV extends Fichier {
    private char separateur;

    public FichierCSV() {
        super();
        this.separateur = ',';  // Par défaut, séparateur virgule
    }

    public FichierCSV(String chemin) {
        super(chemin);
        this.separateur = ',';  // Séparateur par défaut
    }

    @Override
    public Object ouvrirFichier() {
        System.out.println("Ouverture du fichier CSV: " + fichier.getName());
        return fichier;
    }

    @Override
    public Object fermerFichier() {
        System.out.println("Fermeture du fichier CSV: " + fichier.getName());
        return fichier;
    }

    // Méthode pour détecter automatiquement le séparateur
    private char detecterSeparateur(String contenu) {
        if (contenu.contains(";")) {
            return ';';
        } else if (contenu.contains(",")) {
            return ',';
        } else {
            return ',';  // Par défaut, on considère que le séparateur est une virgule
        }
    }

    @Override
    public void afficherContenu() {
        try (FileInputStream fis = new FileInputStream(this.fichier)) {
            int sizeRead;
            StringBuilder contenu = new StringBuilder();
            while ((sizeRead = fis.read(buffer)) != -1) {
                contenu.append(new String(buffer, 0, sizeRead));  // Stocker le contenu dans un StringBuilder
            }
            this.separateur = detecterSeparateur(contenu.toString());
            // Afficher le contenu avec le séparateur détecté
            System.out.println(contenu.toString().replace(this.separateur, ','));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afficherContenuInverse() {
        try (FileInputStream fis = new FileInputStream(this.fichier)) {
            int sizeRead;
            StringBuilder contenu = new StringBuilder();
            while ((sizeRead = fis.read(buffer)) != -1) {
                contenu.append(new String(buffer, 0, sizeRead));  // Stocker le contenu dans un StringBuilder
            }
            this.separateur = detecterSeparateur(contenu.toString());
            String[] lignes = contenu.toString().replace(this.separateur, ',').split("\\n");

            // Afficher le contenu en ordre inverse
            for (int i = lignes.length - 1; i >= 0; i--) {
                System.out.println(lignes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

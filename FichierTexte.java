package dm.lecteur;

public class FichierTexte extends Fichier {

    public FichierTexte() {
        super();
    }

    public FichierTexte(String chemin) {
        super(chemin);
    }

    @Override
    public Object ouvrirFichier() {
        //  ouvrir un fichier .txt
        System.out.println("Ouverture du fichier texte: " + fichier.getName());
        return fichier;
    }

    @Override
    public Object fermerFichier() {
        // fermer un fichier .txt
        System.out.println("Fermeture du fichier texte: " + fichier.getName());
        return fichier;
    }
}

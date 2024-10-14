package dm.lecteur;

public interface Lecteur {
    Object ouvrirFichier();
    Object fermerFichier();
    void afficherContenu();
    void afficherContenuInverse();
    void afficherPalindromique();
    boolean comparerFichiers(String path2);
}

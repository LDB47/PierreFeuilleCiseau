package devoirjeu;

import java.util.Random;
import java.util.Scanner;

public class DevoirJeu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String pierre = "pierre";
        String ciseaux = "ciseaux";
        String feuille = "feuille";

        String[] choix = {pierre, ciseaux, feuille};
        String[] victoire = new String[]{"Perdu!", "Gagné!", "Egalité!"};
        int choixJoueur;
        int choixOrdi;
        int i;

        final int ORDI = 0;
        final int JOUEUR = 1;
        final int EGALITE = 2;
        int gagnant = 0;
        int scoreJoueur = 0;
        int scoreOrdi = 0;

        boolean continuer = true;

        while (continuer) {
            choixJoueur = -1;
            while (choixJoueur == -1) {
                System.out.println("Choisissez pierre, feuille ou ciseaux. Entrez 4 pour quitter le jeu et obtenir le score.");
                System.out.println("1 - Pierre \n2 - Ciseaux \n3 - Feuille \n4: Quitter");

                try {
                    scanner = new Scanner(System.in);
                    choixJoueur = scanner.nextInt() - 1;
                } catch (Exception e) {
                    System.out.println("Non valide.");
                }
            }
            if (choixJoueur == 3) {
                System.out.println("Votre score: " + scoreJoueur);
                System.out.println("Score de l'ordi: " + scoreOrdi);
                continuer = false;
            } else {
                if (choixJoueur < 0 || choixJoueur > 2) {
                    System.out.println("Vous avez écrit: " + (choixJoueur + 1) + " et ce n'est pas valide.");
                } else {
                    choixOrdi = random.nextInt(3);

                    System.out.println("Vous avez choisi: " + choix[choixJoueur]);
                    System.out.println("L'ordinateur a choisi: " + choix[choixOrdi]);

                    if (choixJoueur == choixOrdi) {
                        gagnant = EGALITE;
                    } else if (choixJoueur == 2 && choixOrdi == 0) {
                        gagnant = JOUEUR;
                        scoreJoueur++;
                    } else if (choixJoueur == 0 && choixOrdi == 2) {
                        gagnant = ORDI;
                        scoreOrdi++;
                    } else if (choixOrdi < choixJoueur) {
                        gagnant = ORDI;
                        scoreOrdi++;
                    } else {
                        gagnant = JOUEUR;
                        scoreJoueur++;
                    }
                    System.out.println("Résultat: " + victoire[gagnant]);
                }
            }
        }
    }
}

package model;

import java.util.concurrent.ThreadLocalRandom;

public class Genome {
    
    private final int tailleChaine; private final char[] chaine; public Genome(int tailleChaine) { this.tailleChaine = tailleChaine; this.chaine = new char[tailleChaine]; } public void genererGenomeAleatoire() { for (int indice = 0; indice < tailleChaine; indice++) { chaine[indice] = (char) ThreadLocalRandom.current().nextInt(32, 256); } } public void afficherGenome() { System.out.println(chaine); } public void modifierCaractere(int indice, int valeur) { chaine[indice] = (char) valeur; } public int recupererCaractere(int indice) { return (int) chaine[indice]; } public int recupererTailleGenome() { return tailleChaine; }

}

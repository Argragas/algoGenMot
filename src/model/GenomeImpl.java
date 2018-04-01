package model;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Implémentation de l'interface {@link Genome}.
 * @author Argragas
 *
 */
public class GenomeImpl implements Genome {
    
    private final int tailleChaine; 
    private final char[] chaine; 
    
    public GenomeImpl(int tailleChaine) {
        this.tailleChaine = tailleChaine; 
        this.chaine = new char[tailleChaine]; 
    } 
    
	public void genererGenomeAleatoire() {
        for (int indice = 0; indice < tailleChaine; indice++) {
            chaine[indice] = (char) ThreadLocalRandom.current().nextInt(32, 256);
        }
    }
    
	public String afficherGenome() {
        StringBuffer sb = new StringBuffer();
        for (char c : chaine) {
            sb.append(c);
        }
        return sb.toString(); 
    }
    
	public void modifierCaractere(int indice, int valeur) {
        chaine[indice] = (char) valeur;
    }
    
	public int recupererCaractere(int indice) {
        return (int) chaine[indice]; 
    }
    
	public int recupererTailleGenome() {
        return tailleChaine; 
    }

}

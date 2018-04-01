package model;

import java.util.concurrent.ThreadLocalRandom;

public class GenomeImpl implements Genome {
    
    private final int tailleChaine; 
    private final char[] chaine; 
    
    public GenomeImpl(int tailleChaine) {
        this.tailleChaine = tailleChaine; 
        this.chaine = new char[tailleChaine]; 
    } 
    
    /* (non-Javadoc)
	 * @see model.Genome#genererGenomeAleatoire()
	 */
    @Override
	public void genererGenomeAleatoire() {
        for (int indice = 0; indice < tailleChaine; indice++) {
            chaine[indice] = (char) ThreadLocalRandom.current().nextInt(32, 256);
        }
    }
    
    /* (non-Javadoc)
	 * @see model.Genome#afficherGenome()
	 */
    @Override
	public String afficherGenome() {
        StringBuffer sb = new StringBuffer();
        for (char c : chaine) {
            sb.append(c);
        }
        return sb.toString(); 
    }
    
    /* (non-Javadoc)
	 * @see model.Genome#modifierCaractere(int, int)
	 */
    @Override
	public void modifierCaractere(int indice, int valeur) {
        chaine[indice] = (char) valeur;
    }
    
    /* (non-Javadoc)
	 * @see model.Genome#recupererCaractere(int)
	 */
    @Override
	public int recupererCaractere(int indice) {
        return (int) chaine[indice]; 
    }
    
    /* (non-Javadoc)
	 * @see model.Genome#recupererTailleGenome()
	 */
    @Override
	public int recupererTailleGenome() {
        return tailleChaine; 
    }

}

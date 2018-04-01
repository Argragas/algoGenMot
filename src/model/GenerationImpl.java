package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe représentant une génération.
 * Une génération est composée d'individus, d'un nb d'individus a sauvegarder pour la génération suivante,
 * une probabilité de mutation et d'un objectif.
 * 
 */
public class GenerationImpl implements Generation {

private final int nbIndividus;
 private final int nbIndividusNextGen; 
 private final int probaMutation;
 private final Objectif objectif;
 private final ArrayList<IndividuImpl> groupe;
 
 /**
  * Constructeur de la classe Generation.
  * @Param nbIndividu nbIndividusNextGen probaMutation objectif.
  */
 public GenerationImpl(int nbIndividus, int nbIndividusNextGen, int probaMutation, Objectif objectif) {
     this.nbIndividus = nbIndividus; 
     this.nbIndividusNextGen = nbIndividusNextGen;
     this.objectif = objectif;
     this.probaMutation = probaMutation;
     this.groupe = new ArrayList<>(); 
     }
     
     /* (non-Javadoc)
	 * @see model.Generation#initialiserGenerationZero()
	 */
    @Override
	public void initialiserGenerationZero() {
         for (int individu = 0; individu < nbIndividus; individu++) {
             groupe.add(new IndividuImpl(objectif.getObjectif().length())); 
             
             groupe.get(individu).recupererGenome().genererGenomeAleatoire(); 
             groupe.get(individu).mettreAjourScore(objectif.getObjectif()); 
        } 
    } 
    
    /* (non-Javadoc)
	 * @see model.Generation#executerSelection()
	 */
    @Override
	public void executerSelection() {
        for (int individu = 0; individu < nbIndividus; individu++) {
            groupe.get(individu).mettreAjourScore(objectif.getObjectif()); 
        } Collections.sort(groupe); 
    }
    
    /* (non-Javadoc)
	 * @see model.Generation#executerCroisement()
	 */
    @Override
	public void executerCroisement() {
        for (int individu = nbIndividusNextGen; individu < nbIndividus; individu++) {
            groupe.get(individu).transformerEnEnfant( groupe.get(ThreadLocalRandom.current().nextInt(0, nbIndividusNextGen)).recupererGenome(), groupe.get(ThreadLocalRandom.current().nextInt(0, nbIndividusNextGen)).recupererGenome());
        } 
    } 
    
    /* (non-Javadoc)
	 * @see model.Generation#executerMutation()
	 */
    @Override
	public void executerMutation() {
        for (int individu = 0; individu < nbIndividus; individu++) {
            if (ThreadLocalRandom.current().nextInt(0, 1000) < probaMutation) {
                groupe.get(individu).muter(); 
            }
        }
    }
    
    /* (non-Javadoc)
	 * @see model.Generation#recupererIndividu(int)
	 */
    @Override
	public Individu recupererIndividu(int indice) {
        return groupe.get(indice); 
    }


}

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
public class Generation {

private final int nbIndividus;
 private final int nbIndividusAlpha; 
 private final int probaMutation;
 private final String objectif;
 private final ArrayList<Individu> groupe;
 
 /**
  * Constructeur de la classe Generation.
  * @Param nbIndividu nbIndividusNextGen probaMutation objectif.
  */
 public Generation(int nbIndividus, int nbIndividusNextGen, int probaMutation, String objectif) {
     this.nbIndividus = nbIndividus; 
     this.nbIndividusAlpha = nbIndividusNextGen;
     this.objectif = objectif;
     this.probaMutation = probaMutation;
     this.groupe = new ArrayList<>(); 
     }
     
     public void initialiserGenerationZero() {
         for (int individu = 0; individu < nbIndividus; individu++) {
             groupe.add(new Individu(objectif.length())); 
             
             groupe.get(individu).recupererGenome().genererGenomeAleatoire(); 
             groupe.get(individu).mettreAjourScore(objectif); 
        } 
    } 
    
    public void executerSelection() {
        for (int individu = 0; individu < nbIndividus; individu++) {
            groupe.get(individu).mettreAjourScore(objectif); 
        } Collections.sort(groupe); 
    }
    
    public void executerCroisement() {
        for (int individu = nbIndividusAlpha; individu < nbIndividus; individu++) {
            groupe.get(individu).transformerEnEnfant( groupe.get(ThreadLocalRandom.current().nextInt(0, nbIndividusAlpha)).recupererGenome(), groupe.get(ThreadLocalRandom.current().nextInt(0, nbIndividusAlpha)).recupererGenome());
        } 
    } 
    
    public void executerMutation() {
        for (int individu = 0; individu < nbIndividus; individu++) {
            if (ThreadLocalRandom.current().nextInt(0, 1000) < probaMutation) {
                groupe.get(individu).muter(); 
            }
        }
    }
    
    public Individu recupererIndividu(int indice) {
        return groupe.get(indice); 
    }


}

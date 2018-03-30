package model;

import java.util.concurrent.ThreadLocalRandom;

public class Individu implements Comparable<Individu> {

    private final Genome genome;
    private int          score;

    public Individu(int tailleChaine) {
        this.genome = new Genome(tailleChaine);
        this.score = 0;
    }

    public void mettreAjourScore(String objectif) {
        score = 0;
        for (int indice = 0; indice < objectif.length(); indice++) {
            score += Math.abs(genome.recupererCaractere(indice) - (int)objectif.charAt(indice));
        }
    }

    public void transformerEnEnfant(Genome genome1, Genome genome2) {
        int pivot = ThreadLocalRandom.current().nextInt(0, genome.recupererTailleGenome());
        
        for (int indice = 0; indice < pivot; indice++) {
            genome.modifierCaractere(indice, genome1.recupererCaractere(indice));
        }
        for (int indice = pivot; indice < genome.recupererTailleGenome(); indice++) {
            genome.modifierCaractere(indice, genome2.recupererCaractere(indice));
        }
    }

    public void muter() {
        int indice = ThreadLocalRandom.current().nextInt(0, genome.recupererTailleGenome());
        int ecart = ThreadLocalRandom.current().nextInt(1, 7);
        if (ThreadLocalRandom.current().nextInt(0, 2) == 0) {
            genome.modifierCaractere(indice, genome.recupererCaractere(indice) - ecart);
        } else {
            genome.modifierCaractere(indice, genome.recupererCaractere(indice) + ecart);
        }
    }

    public Genome recupererGenome() {
        return genome;
    }

    public int recupererScore() {
        return score;
    }

    @Override
    public int compareTo(Individu autreIndividu) {
        return (this.score - autreIndividu.score);
    }
    


}

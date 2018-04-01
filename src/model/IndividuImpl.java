package model;

import java.util.concurrent.ThreadLocalRandom;

public class IndividuImpl implements Comparable<IndividuImpl>, Individu {

    private final Genome genome;
    private int          score;

    public IndividuImpl(int tailleChaine) {
        this.genome = new GenomeImpl(tailleChaine);
        this.score = 0;
    }

    /* (non-Javadoc)
	 * @see model.Individu#mettreAjourScore(java.lang.String)
	 */
    @Override
	public void mettreAjourScore(String objectif) {
        score = 0;
        for (int indice = 0; indice < objectif.length(); indice++) {
            score += Math.abs(genome.recupererCaractere(indice) - (int)objectif.charAt(indice));
        }
    }

    /* (non-Javadoc)
	 * @see model.Individu#transformerEnEnfant(model.Genome, model.Genome)
	 */
    @Override
	public void transformerEnEnfant(Genome genome1, Genome genome2) {
        int pivot = ThreadLocalRandom.current().nextInt(0, genome.recupererTailleGenome());
        
        for (int indice = 0; indice < pivot; indice++) {
            genome.modifierCaractere(indice, genome1.recupererCaractere(indice));
        }
        for (int indice = pivot; indice < genome.recupererTailleGenome(); indice++) {
            genome.modifierCaractere(indice, genome2.recupererCaractere(indice));
        }
    }

    /* (non-Javadoc)
	 * @see model.Individu#muter()
	 */
    @Override
	public void muter() {
        int indice = ThreadLocalRandom.current().nextInt(0, genome.recupererTailleGenome());
        int ecart = ThreadLocalRandom.current().nextInt(1, 7);
        if (ThreadLocalRandom.current().nextInt(0, 2) == 0) {
            genome.modifierCaractere(indice, genome.recupererCaractere(indice) - ecart);
        } else {
            genome.modifierCaractere(indice, genome.recupererCaractere(indice) + ecart);
        }
    }

    /* (non-Javadoc)
	 * @see model.Individu#recupererGenome()
	 */
    @Override
	public Genome recupererGenome() {
        return genome;
    }

    /* (non-Javadoc)
	 * @see model.Individu#recupererScore()
	 */
    @Override
	public int recupererScore() {
        return score;
    }

    /* (non-Javadoc)
	 * @see model.Individu#compareTo(model.IndividuImpl)
	 */
    @Override
    public int compareTo(IndividuImpl autreIndividu) {
        return (this.score - autreIndividu.score);
    }

}

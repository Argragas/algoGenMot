package model;

/**
 * Interface de la classe Individu.
 * Représente un individu dans une génération.
 * @author Argragas
 *
 */
public interface Individu {

	/**
	 * Met a jour le score de l'individu en fonction d'un objectif.
	 * @param String objectif
	 */
	public void mettreAjourScore(String objectif);

	/**
	 * Transforme l'individu en individu de la prochaine génération en croisant son génome avec le génome d'un autre individu.
	 * @param Genome genome1
	 * @param Genome genome2
	 */
	public void transformerEnEnfant(Genome genome1, Genome genome2);

	/**
	 * Création d'une mutation sur le génome de l'individu.
	 */
	public void muter();

	/**
	 * Renvoi le génome de l'individu.
	 * @return {@link Genome}
	 */
	public Genome recupererGenome();

	/**
	 * Renvoi le score de l'individu.
	 * @return int score.
	 */
	public int recupererScore();

}
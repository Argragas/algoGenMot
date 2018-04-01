package model;

/**
 * Représentation de la classe {@link Genome}.
 * @author Argragas
 *
 */
public interface Genome {

	/**
	 * Génère un génome de façon aléatoire.
	 */
	public void genererGenomeAleatoire();

	/**
	 * Renvoi une représentation graphique du génome.
	 * @return String {@link Genome}
	 */
	public String afficherGenome();

	/**
	 * Modification d'un caractère du {@link Genome}.
	 * @param indice
	 * @param valeur
	 */
	public void modifierCaractere(int indice, int valeur);

	/**
	 * Renvoi le caractère à l'indice donné en paramètre.
	 * @param indice
	 * @return int caractère.
	 */
	public int recupererCaractere(int indice);

	/**
	 * Renvoi la taille du {@link Genome}.
	 * @return int taille
	 */
	public int recupererTailleGenome();

}
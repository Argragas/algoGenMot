package model;

/**
 * Representation d'une génération.
 * @author Argragas
 *
 */
public interface Generation {

	/**
	 * Initialisation de la génération.
	 */
	public void initialiserGenerationZero();

	/**
	 * Lance la selection des meilleurs {@link Individu}.
	 */
	public void executerSelection();

	/**
	 * Lance l'execution des croisement entre les meilleurs {@link Individu}.
	 */
	public void executerCroisement();

	/**
	 * Lance l'execution des mutations sur les {@link Individu}.
	 */
	public void executerMutation();

	/**
	 * Renvoi l'{@link Individu} à l'indice donné en paramètre.
	 * @param int indice
	 * @return {@link Individu}.
	 */
	public Individu recupererIndividu(int indice);

}
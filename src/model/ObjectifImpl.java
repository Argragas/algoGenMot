package model;

import model.Objectif;

/**
 * Implementation de l'interface {@link Objectif} a atteindre pour la génération en cours.
 * @author Argragas
 *
 */
public class ObjectifImpl implements Objectif{

	private String objectif;

	public ObjectifImpl(String objectif) {
		this.objectif = objectif;
	}

	public String getObjectif() {
		return objectif;
	}







}

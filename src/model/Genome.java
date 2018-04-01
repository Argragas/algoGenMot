package model;

public interface Genome {

	void genererGenomeAleatoire();

	String afficherGenome();

	void modifierCaractere(int indice, int valeur);

	int recupererCaractere(int indice);

	int recupererTailleGenome();

}
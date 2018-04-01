package model;

public interface Individu {

	void mettreAjourScore(String objectif);

	void transformerEnEnfant(Genome genome1, Genome genome2);

	void muter();

	Genome recupererGenome();

	int recupererScore();

}
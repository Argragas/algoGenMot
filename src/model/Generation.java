package model;

public interface Generation {

	void initialiserGenerationZero();

	void executerSelection();

	void executerCroisement();

	void executerMutation();

	Individu recupererIndividu(int indice);

}
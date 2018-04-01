package main;
import model.Generation;
import model.GenerationImpl;
import model.ObjectifImpl;

public class Main {

	public static void main(String[] args) {
		int counter = 0; 

		Generation generation = new GenerationImpl(1000, 50, 300, new ObjectifImpl("ET SI VOUS ÉTIEZ DÉJÀ MARIN SANS LE SAVOIR ?")); 
		generation.initialiserGenerationZero(); 
		while (generation.recupererIndividu(0).recupererScore() != 0) {
			generation.executerSelection(); 
			System.out.println(String.format("Génération  %s : %s", counter,  generation.recupererIndividu(0).recupererGenome().afficherGenome()));

			generation.executerCroisement(); 
			generation.executerMutation();
			counter++; 
		}
	}
}

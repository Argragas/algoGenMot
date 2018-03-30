import model.Generation;

public class Main {

    public static void main(String[] args) {
int counter = 0; 
Generation generation = new Generation(1000, 50, 200, "ET SI VOUS ÉTIEZ DÉJÀ MARIN SANS LE SAVOIR ?"); 
generation.initialiserGenerationZero(); 
while (generation.recupererIndividu(0).recupererScore() != 0) {
    generation.executerSelection(); System.out.print("Génération " + counter + " : ");
    generation.recupererIndividu(0).recupererGenome().afficherGenome(); 
    generation.executerCroisement(); 
    generation.executerMutation();
    counter++; 
    }


    }
}

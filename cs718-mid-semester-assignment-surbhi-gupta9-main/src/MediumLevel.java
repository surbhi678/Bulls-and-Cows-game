import java.util.ArrayList;
import java.util.List;

public class MediumLevel extends Computer {
    private List guesses = new ArrayList(); // storing the guesses previously made

    @Override
    public void guess(Players player, Players answer) { // Computer will not make the same guess again
        int[] tempGuess = this.generateRandomNumbers(); // storing the temporary guess
        if (! guesses.contains(tempGuess)){ //verifying whether temporary guess has been previously made
            guesses.add(tempGuess.clone());
            this.guess = tempGuess;
        }
        else {
            this.guess(player, answer); //recursion
        }

        this.checkAnswer(player.guess, answer.secretCode);
    }
}


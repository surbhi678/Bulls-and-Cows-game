import Exceptions.DataDuplicationException;
import java.util.ArrayList;
import java.util.List;

public class HardLevel extends Computer {
    private List<int[]> possibleCodes = new ArrayList<int[]>();
    int[] tempGuess = new int[CODE_LENGTH];

    public HardLevel() {
        // The possibleCodes for round 1 to be intialised
        String s;
        for (int i = 123; i <= 9876; i++) {
            s = Integer.toString(i);
            if (s.length() == 3) {
                s = "0" + s;
            }
            try {
                for (int j = 0; j < CODE_LENGTH; j++) {
                    int value = Integer.parseInt(s.charAt(j) + "");
                    for (int k = 0; k < j; k++) {
                        if (value == tempGuess[k]) {
                            throw new DataDuplicationException();
                        }
                    }
                    tempGuess[j] = value;
                }
                possibleCodes.add(tempGuess.clone());
            } catch (DataDuplicationException e) {
                continue;
            }
        }
    }

    @Override
    public void guess(Players player, Players answer) {
        //one guess to be selected from possibleCode
        int randomIndex = (int)(Math.random() * this.possibleCodes.size());
        for (int i = 0; i < CODE_LENGTH; i++){
            this.guess[i] = this.possibleCodes.get(randomIndex)[i];
        }
        //answer verification
        this.checkAnswer(player.guess, answer.secretCode);
        // possibleCodes to be updated
        List<int[]> tempPossibleCodes = new ArrayList<int[]>(); // storing the codes which would then be later removed
        // bulls and cows values stored in tempBulls and tempCows
        int tempBulls = this.bulls;
        int tempCows = this.cows;
        for (int i = 0; i < this.possibleCodes.size(); i++){
            this.checkAnswer(this.possibleCodes.get(i), player.guess); // the secret code is assumed to be the guess of the player
            if (tempBulls != this.bulls || tempCows != this.cows){
                tempPossibleCodes.add(this.possibleCodes.get(i)); //to be removed later

            }
        }
        // retrieving values of bulls and cows
        this.bulls = tempBulls;
        this.cows = tempCows;
        // deletion of code that does not equate to same result
        for (int i = 0; i < tempPossibleCodes.size(); i++){
            this.possibleCodes.remove(tempPossibleCodes.get(i));
        }
    }
}

import Exceptions.DataDuplicationException;
import java.util.*;


public abstract class Players {

    private String name;
    static final int CODE_LENGTH = 4;
    protected int[] secretCode = new int[CODE_LENGTH];
    protected int[] guess = new int[CODE_LENGTH];
    protected int bulls, cows;
    Deque<String> codeFromFile = new ArrayDeque<>();


    public boolean checkingInput(String input) {
        try {
            if (input.length() > CODE_LENGTH || input.length() < CODE_LENGTH) {
                throw new IndexOutOfBoundsException();
            }
            for (int i = 0; i < CODE_LENGTH; i++) {
                //checking for data duplication
                for (int j = 0; j < CODE_LENGTH; j++) {
                    if (i != j && input.charAt(i) == input.charAt(j)) {
                        throw new DataDuplicationException();
                    }
                }
                //verifying if string can be converted to integer
                int numberForChecking = Integer.parseInt(input.charAt(i) + "");
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("The length of the input was invalid, try again:");
            return false;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + ". Invalid input, try again:");
            return false;
        } catch (DataDuplicationException e) {
            System.out.println("The input contains duplicate data, try again:");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage() + ". Invalid input, try again:");
            return false;
        }
        return true;
    }

    public abstract void guess(Players player, Players answer);

    public void checkAnswer(int[] guess, int[] secretCode) {
        this.bulls = 0;
        this.cows = 0;
        // checking the number of bulls
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (guess[i] == secretCode[i]) {
                this.bulls++;
            }
        }
        // checking the number of cows
        for (int i = 0; i < CODE_LENGTH; i++) {
            for (int j = 0; j < CODE_LENGTH; j++) {
                if (i != j && guess[i] == secretCode[j]) {
                    this.cows++;
                }
            }
        }
    }

    public abstract void setSecretCode(); // this methods would be implemented in botht the user and computer classes


    public String toStringForCode(int[] code) {
        String s = "";
        for (int i = 0; i < CODE_LENGTH; i++) {
            s = s + code[i];
        }
        return s;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

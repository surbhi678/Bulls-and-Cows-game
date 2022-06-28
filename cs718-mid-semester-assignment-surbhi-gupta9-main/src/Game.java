import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private int levels;
    private int totalTurns = 7; //a maximum of 7 turns per player
    private String winner = null;
    private String mode;
    private boolean saveTheResults;
    List<String> generatedData = new ArrayList();

    public Game() {
        System.out.println("Welcome to the bulls & cows game.");
        generatedData.add("Bulls & Cows game result.");
    }

    public void play(User user, Computer computer) {
        for (int i = 1; i <= this.totalTurns; i++){
            if (this.winner != null){
                break;
            }
            generatedData.add("Turn " + Integer.toString(i) + ": ");
            System.out.println("Turn " + Integer.toString(i) + ": ");

            // the guess would first be input by the user
            if (this.getMode().equals("Manually") || (this.getMode().equals("AUTOMATICALLY") && user.codeFromFile.size() == 0)){
                System.out.println("Please enter your guess: ");
            }
            user.guess(user, computer);
            this.printResults(user);
            this.printWinner(user, i);

            //after the user the computer would input the guess
            if (this.winner == null) {
                computer.guess(computer, user);
                this.printResults(computer);
                this.printWinner(computer, i);
            }
            generatedData.add("------------------------------------------------------------------------");
        }
    }

    public void printResults(Players player){
        String output = player.getName() + " has guessed " + player.toStringForCode(player.guess) + " and scored " + player.bulls + " bulls and " + player.cows + " cows!";
        System.out.println(output);
        generatedData.add(output);
    }

    public void printWinner(Players player, int count){
        // user or computer wins
        if (player.bulls == player.CODE_LENGTH){
            generatedData.add("------------------------------------------------------------------------");
            String output = "The winner is of the game is: " + player.getName() + "!";
            System.out.println(output);
            generatedData.add(output);
            this.winner = player.getName();
            return;
        }
        // it's a draw
        if (count == this.totalTurns && player.getName().equals("Computer")){
            generatedData.add("------------------------------------------------------------------------");
            String output = "The game ends in a draw.";
            System.out.println(output);
            generatedData.add(output);
            return;
        }
    }

    public void setLevel() {
        String input;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("(Enter: \"1\",\"2\" or \"3\")");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            input = Keyboard.readInput();
            input = input.toUpperCase();
            switch (input) {
                case "1":
                case "Easy":
                    this.levels = 1;
                    isValid = true;
                    break;
                case "2":
                case "Medium":
                    this.levels = 2;
                    isValid = true;
                    break;
                case "3":
                case "Hard":
                    this.levels = 3;
                    isValid = true;
                    break;
                default:
                    System.out.println("Whoops, invalid input. Try again");
                    break;
            }
        }
    }

    public int getLevel() {
        return this.levels;
    }


    public void setMode(){
        String input;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("1. Automatic");
            System.out.println("2. Manual");
            input = Keyboard.readInput();
            input = input.toUpperCase();
            switch (input) {
                case "1":
                case "Automatic":
                    this.mode = "Automatic";
                    isValid = true;
                    break;
                case "2":
                case "Manual":
                    this.mode = "Manual";
                    isValid = true;
                    break;
                default:
                    System.out.println("Whoops, invalid input. Try again");
                    break;
            }
        }
    }
    public String getMode(){
        return this.mode;
    }

    public void readFile(Players user){
        while (true){
            System.out.println("Kindly enter a valid file name ");
            String filename = Keyboard.readInput();
            File inputFile = new File(filename);
            try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
                String line = null;
                while ((line = reader.readLine()) != null){
                    // assume each line of the file contain a valid guess
                    // otherwise, need to check the value, use "user.checkInput(line)"
                    user.codeFromFile.addLast(line);
                }
            }
            catch (IOException e){
                System.out.println("Whoops, this file does not exist, try again");
                continue;
            }
            break;
        }
    }

    public void setSaveResult(){
        String input;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("1. Yes");
            System.out.println("2. No");
            input = Keyboard.readInput();
            input = input.toUpperCase();
            switch (input) {
                case "1":
                case "Yes":
                    this.saveTheResults = true;
                    isValid = true;
                    break;
                case "2":
                case "No":
                    this.saveTheResults = false;
                    isValid = true;
                    break;
                default:
                    System.out.println("Whoops, invalid input. Try again");
                    break;
            }
        }
    }

    public boolean getSaveResult(){
        return this.saveTheResults;
    }

    public void saveFile(){
        while (true){
            System.out.println("Kindly enter a valid file name");
            String filename = Keyboard.readInput();
            File outputFile = new File(filename);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (int i = 0; i < generatedData.size(); i++){
                    writer.write(generatedData.get(i));
                    writer.newLine();
                }
            }
            catch (IOException e){
                System.out.println("Error " + e.getMessage());
                continue;
            }
            break;
        }
    }

}

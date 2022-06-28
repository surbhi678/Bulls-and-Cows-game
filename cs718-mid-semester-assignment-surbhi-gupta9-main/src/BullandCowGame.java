public class BullandCowGame {
    public static void main(String[] args){
        BullandCowGame bullAndcowGame = new BullandCowGame();
        bullAndcowGame.start();
    }
    public void start(){
        // we begin by creating the game
        Game game = new Game();

        // creating the AI/Computer and as per the selected level the AI/Computer would be implemented
        Computer computer = null;
        System.out.println("Select the game level you would like to play:");
        game.setLevel();
        switch (game.getLevel()){
            case 1:
                computer = new EasyLevel();
                computer.setLevel("Easy");
                break;
            case 2:
                computer = new MediumLevel();
                computer.setLevel("Medium");
                break;

            case 3:
                computer = new HardLevel();
                computer.setLevel("Hard");
                break;

            default:
                break;
        }

        System.out.println("Your chosen level is:" + computer.getLevel());

        //creating the User
        User user = new User();

        //Generating the secret code of the user
        System.out.println("Enter your chosen secret code:");
        user.setSecretCode();
        System.out.println("Your chosen secret code is:" + user.toStringForCode(user.secretCode));
        game.generatedData.add("Your chosen secret code is:" + user.toStringForCode(user.secretCode));

        //generating the secret code of the AI/Computer
        computer.setSecretCode();
        game.generatedData.add("The secret code of the computer is: " + computer.toStringForCode(computer.secretCode));
        game.generatedData.add("------------------------------------------------------------------------");


        //Mode selection by the player
        System.out.println("Please select the mode at which you would like to play:");
        game.setMode();

        //Using a file to read the data
        if (game.getMode() == "Automatically"){
            game.readFile(user);
        }

        //Initiating the game
        game.play(user, computer);
//      System.out.println(computer.toStringForCode(computer.secretCode)); // this would print out the secret code of the computer

        //ending the game and then saving the results of the game
        System.out.println("Would you like to save the game results?");
        game.setSaveResult();
        if (game.getSaveResult()){
            game.saveFile();
        }
    }
}

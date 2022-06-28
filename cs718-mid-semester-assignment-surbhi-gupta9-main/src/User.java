public class User extends Players {

    public User() {
        this.setName("You");
    }

    public void setCode(int[] target){
        String input;
        while (true) {
            // automatic
            if (this.codeFromFile.size() > 0){
                input = this.codeFromFile.removeFirst();
            }
            // manual
            else {
                input = Keyboard.readInput();
            }
            // checking the input
            if (this.checkingInput(input)) {
                break;
            }
        }
        // setting the values
        for(int i = 0; i < CODE_LENGTH; i++){
            target[i] = Integer.parseInt(input.charAt(i) + "");
        }
    }

    @Override
    public void guess(Players player, Players answer) {
        this.setCode(this.guess);
        this.checkAnswer(player.guess, answer.secretCode);
    }

    @Override
    public void setSecretCode() {
        this.setCode(this.secretCode);
    }
}


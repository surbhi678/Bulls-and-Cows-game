public abstract class Computer extends Players {
    private String level;

    public Computer() {
        this.setName("Computer");
    }
    public int[] generateRandomNumbers(){
        //this would generate 4 random numbers
        int[] randomNumbers= new int[CODE_LENGTH];
        for (int i = 0; i< CODE_LENGTH; i++) {
            randomNumbers[i] = (int) (Math.random() *10);
            for (int j=0; j<i; j++) {
                if (randomNumbers[i] == randomNumbers[j]) {
                    i--;
                    break;
                }
            }
        }
        return randomNumbers;

    }
    @Override
    public void setSecretCode() {
        this.secretCode = generateRandomNumbers();
    }

    public void setLevel(String input) {
        this.level = input;
    }

    public String getLevel() {
        return this.level;
    }


}

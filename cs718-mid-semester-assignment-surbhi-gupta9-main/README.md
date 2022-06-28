# Bulls & Cows 


The bulls and cows game is a code-breaking game designed for two or more players. Each player chooses a secret code of 4 digits from 0 – 9. The digits must be all different. The goal of the game is for each player to guess the other player's secret code.

The players in turn present their guesses to the opponents. The opponents respond by telling the players:
1. The number of bulls, i.e. the number of matching digits in their right positions, and
2. The number of cows, i.e. the number of matching digits but in different positions.

For example, if the computer's secret code is 4281, the match responses for the following guesses are shown as follows:



### Requirements
The game stores two secret codes, one from the player and one from the computer. The player and the computer will try to guess each other’s secret code. Both the player and the computer only have seven attempts for guessing the secret code. If the player enters an invalid input, the game should ask the player to try again. The game also lets the player choose the difficulty level to play against the computer. There are three levels: easy, medium and hard. The details of the difficulty levels will be described in later sections. In addition, the game can read from a text file that contains multiple guesses from the player, and save the results to another text file.



 The Beginning
Implement the first part of the game allowing the player to guess the computer's secret code. The computer randomly generates the secret code at the beginning of the game, which it then lets the player guess. Remember that when generating the computer's secret code, each of the four digits must be different. Note that the player only has seven attempts to guess the secret code. The prompt for player input, results for each guess and the final outcome (i.e. whether the player has won the game or not) should be displayed appropriately to the console.

Task Three: Easy AI
The player can now also enter a secret code when the game begins, which the computer must guess. Remember to verify that the player has chosen a valid secret code. The player and computer each take turns guessing the other's code. The game ends when either side successfully guesses the other's code (resulting in a win for that side), or when each side has made seven incorrect guesses (resulting in a draw).



## Medium AI 
At the beginning of the game (before the player enters their own secret code), they will be asked to select either an easy or medium AI opponent to play against.

If the player chooses to play against an easy AI, the game should proceed in exactly the same manner as in Task Three. However, if a medium AI is selected, the AI should keep track of guesses it has already made. The AI will not make the same guess twice.

##  Hard AI 
The player can additionally choose to play against a hard AI opponent.

If the player chooses to play against an easy or medium AI, the game should proceed in exactly the same manner as in Task Three or Four. However, if a hard AI is selected, the computer should be much more intelligent when guessing, rather than just choosing at random. 

##  Reading Guesses from a File 
Before the game begins, the player is asked whether they wish to enter their guesses manually, or to automatically guess based on pre-supplied guesses in a file.

If the first option is chosen, then the game should progress in the same fashion as in Task Five above. If the second option is chosen, then the following actions should be taken:

Firstly, the player should be asked to enter a filename. If the player enters an invalid filename, they should be re-prompted until they enter the name of a file that actually exists. This file should then be read and interpreted as a text file, where each line contains a separate guess


Once the file has been read, then the game should proceed as normal. However, when the player would be prompted to enter a guess, the next guess in the list of pre-supplied guesses should automatically be chosen instead. If there are no more pre-supplied guesses (for example, if the player needs to enter their fifth guess but the file only contains four guesses), then the player should be prompted as normal.

## Saving to a File
When the game ends (win, lose, or draw), the player is asked if they wish to save the results to a text file. If they do, then they’ll be prompted to enter a filename. The game should then save the following information to the given file:
* The player and computer’s secret number
* Each guess that was made, in the same order as occurred during the game, along with the result of that guess (i.e. how many bulls & cows it got)
* The identity of the winner (or a message stating that the game was a draw)


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DieGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user for the number of sides on the dice
        System.out.print("Enter the number of sides for the dice: ");
        int numSides = input.nextInt();

        // Ask the user for the number of players
        System.out.print("Enter the number of players: ");
        int numPlayers = input.nextInt();

        // Create an array to store Player objects
        Player[] players = new Player[numPlayers];

        // Create a Die object with the specified number of sides
        Die1 commonDie = new Die1(numSides);

        // Initialize players
        for (int i = 0; i < numPlayers; i++) {
            input.nextLine(); // Consume newline left by previous nextInt()
            System.out.print("Enter the name for player " + (i + 1) + ": ");
            String playerName = input.nextLine();
            players[i] = new Player(playerName, commonDie);
        }

        // Roll the die for each player and print the results
        for (Player player : players) {
            player.getDie().roll();
            System.out.println(player.getName() + " rolled a " + player.getDie().getValue() +
                    " on a " + numSides + "-sided die.");
        }

        // Decide the winner
        int winnerIndex = decideWinner(players);
        if (winnerIndex != -1) {
            System.out.println(players[winnerIndex].getName() + " won the game!");
        } else {
            System.out.println("It's a tie!");
        }

        // Extra credit: Write results to a file
        try {
            FileWriter fileWriter = new FileWriter("DiceGameOutput.txt");
            for (Player player : players) {
                fileWriter.write(player.getName() + " rolled a " + player.getDie().getValue() +
                        " on a " + numSides + "-sided die.\n");
            }
            fileWriter.write("Winner: " + players[winnerIndex].getName());
            fileWriter.close();
            System.out.println("Results written to DiceGameOutput.txt");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        input.close();
    }

    // Method to decide the winner (returns index of winner or -1 for a tie)
    private static int decideWinner(Player[] players) {
        int maxRoll = -1;
        int winnerIndex = -1;

        for (int i = 0; i < players.length; i++) {
            if (players[i].getDie().getValue() > maxRoll) {
                maxRoll = players[i].getDie().getValue();
                winnerIndex = i;
            } else if (players[i].getDie().getValue() == maxRoll) {
                // It's a tie
                winnerIndex = -1;
            }
        }

        return winnerIndex;
    }
}

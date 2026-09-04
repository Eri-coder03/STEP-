import java.util.Scanner;
import java.util.Random;

public class E1{

    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int rounds = 5;

        String[] moves = {"Rock", "Paper", "Scissors"};

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < rounds; i++) {

            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String playerMove = sc.nextLine();

            int randomIndex = random.nextInt(3);
            String computerMove = moves[randomIndex];

            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            System.out.println("Round " + (i + 1) +
                    " - Player: " + playerMove +
                    ", Computer: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("----- Final Summary -----");
        System.out.println("Round | Player Move | Computer Move | Result");

        for (int i = 0; i < rounds; i++) {
            System.out.println((i + 1) + "     | " +
                    playerMoves[i] + "      | " +
                    computerMoves[i] + "       | " +
                    results[i]);
        }

        System.out.println();
        System.out.println("Wins: " + wins +
                " | Losses: " + losses +
                " | Draws: " + draws +
                " | Win % = " + winPercentage);

        sc.close();
    }
}

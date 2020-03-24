import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Board board = Board.buildEmptyBoard();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public void playGame() {
        Player human = new Player(board, getPlayerMark(random), false, "You win! Good job!");
        Player computer = new Player(board, getComMark(human.getMark()), true, "You have lost, sorry. Try again?");
        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("Player: " + human);
        System.out.println("Computer: " + computer);
        System.out.println("CROSS starts");

        if (human.getMark() == Mark.CROSS) {
            player1.setPlayer(human);
            player2.setPlayer(computer);
        } else {
            player1.setPlayer(computer);
            player2.setPlayer(human);
        }
        for (int i = 0; i < 5; i++) {
            drawBoard();
            turn(player1);
            drawBoard();

            // kontroll kas esimene mängija on võitnud
            if (checkIfWin(player1)) break;

            // kontrollib, kas on mängu viimane samm. Kui on, siis deklareerib viigi sest kõik ruudud on täis ja võitu pole siiani kuulutatud .
            if (i == 4) {
                drawBoard();
                System.out.println("It seems you have reached a tie... try again?");
                break;
            }
            turn(player2);

            // kontroll kas teine mängija on võitnud
            if (checkIfWin(player2)) break;
        }
    }

    //Kontrollib, kas vastav mängija on võitnud, kui on, siis prindib võidu või kaotussõnumi.
    private boolean checkIfWin(Player player) {
        if (board.hasWon(player.getMark())) {
            drawBoard();
            System.out.println(player.getMessage());
            return true;
        }
        return false;
    }

    //Käigufunktsioon. Eristab inimest ja arvutit.
    private void turn(Player player) {
        if (player.isComputer())
            player.setPick(getRandomPick(board, random));
        else
            player.setPick(getPlayerPick(board, scanner));
        board.setSpaceMark(player.getPick(), player.getMark());
    }

    private static int getRandomPick(Board board, Random random) {
        while (true) {
            int randomPick = random.nextInt(9) + 1;
            if (board.checkSpace(randomPick)) {
                return randomPick;
            }
        }
    }

    private static int getPlayerPick(Board board, Scanner scanner) {
        while (true) {
            System.out.println("which field?");
            int playerPick = scanner.nextInt();
            if (board.checkSpace(playerPick)) {
                return playerPick;
            }
            System.out.println("filed already filled!");
        }
    }

    private static Mark getPlayerMark(Random random) {
        Mark playerMark;

        if (random.nextInt(2) == 0) {
            playerMark = Mark.CROSS;
        } else {
            playerMark = Mark.NOUGHT;
        }
        return playerMark;
    }

    private static Mark getComMark(Mark playerMark) {
        if (playerMark == Mark.CROSS)
            return Mark.NOUGHT;
        return Mark.CROSS;
    }

    //funktsioon, mis joonistab mängulaua
    public void drawBoard() {
        System.out.println("┌───┬───┬───┐");
        System.out.println("│ " + markToString(board.getSpaceMark(1)) + " │ " + markToString(board.getSpaceMark(2)) + " │ " + markToString(board.getSpaceMark(3)) + " │");
        System.out.println("├───┼───┼───┤");
        System.out.println("│ " + markToString(board.getSpaceMark(4)) + " │ " + markToString(board.getSpaceMark(5)) + " │ " + markToString(board.getSpaceMark(6)) + " │");
        System.out.println("├───┼───┼───┤");
        System.out.println("│ " + markToString(board.getSpaceMark(7)) + " │ " + markToString(board.getSpaceMark(8)) + " │ " + markToString(board.getSpaceMark(9)) + " │");
        System.out.println("└───┴───┴───┘");
    }

    public static String markToString(Mark mark) {
        switch (mark) {
            case CROSS:
                return "X";

            case NOUGHT:
                return "O";

            default:
                return " ";
        }
    }
}

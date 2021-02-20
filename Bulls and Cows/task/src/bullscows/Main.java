package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int codeLength = scanner.nextInt();
        BullsAndCowsGame game = BullsAndCowsGame.init(codeLength);
        System.out.println("Okay, let's start a game!");
        String guessNumber;
        int turn = 1;
        do {
            System.out.println("Turn " + turn + ":");
            guessNumber = scanner.next();
            turn++;
        } while (!game.successGuess(guessNumber));
    }
}
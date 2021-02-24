package bullscows;

import java.util.Scanner;

public class Main {
    private static boolean isNumber(String str) {
        if (str == null) {
            return false;
        }
        try {
            int n = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String codeLength = scanner.nextLine();
        if (!isNumber(codeLength)) {
            System.out.println("Error: " + codeLength + " isn't a valid number.");
            return;
        }
        System.out.println("Input the number of possible symbols in the code:");
        String possibleSymbols = scanner.nextLine();
        if (!isNumber(possibleSymbols)) {
            System.out.println("Error: " + possibleSymbols + " isn't a valid number.");
            return;
        }
        BullsAndCowsGame game = BullsAndCowsGame.init(Integer.parseInt(codeLength), Integer.parseInt(possibleSymbols));
        if (game == null) {
            return;
        }
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
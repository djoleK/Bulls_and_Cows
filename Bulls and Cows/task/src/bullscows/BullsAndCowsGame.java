package bullscows;

import java.util.Random;

public class BullsAndCowsGame {
    private String code;

    static BullsAndCowsGame init(int codeLength, int possibleSymbols) {
        if (codeLength <= 0) {
            System.out.println("Error: code length must be greater than 0.");
            return null;
        }
        if (possibleSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return null;
        }
        if (codeLength > possibleSymbols) {
            System.out.println("Error: it's not possible to generate a code with a length of " + codeLength + " with " + possibleSymbols + " unique symbols.");
            return null;
        }
        return new BullsAndCowsGame(codeLength, possibleSymbols);
    }

    private BullsAndCowsGame(int codeLength, int possibleSymbols) {
        code = prepareCode(codeLength, possibleSymbols);
        StringBuilder wildcard = new StringBuilder();
        for (int i = 0; i < codeLength; i++) {
            wildcard.append('*');
        }
        String range = (possibleSymbols <= 10 ? "0-" + (char) ('0' + possibleSymbols - 1) : "0-9, a-" + (char) ('a' + possibleSymbols - 11));
        System.out.println("The secret is prepared: " + wildcard + " (" + range + ") " + code + ".");
    }

    private String prepareCode(int codeLength, int possibleSymbols) {
        Random random = new Random();
        int number;
        String code = "";
        do {
            number = random.nextInt(possibleSymbols);
            String symbol = String.valueOf(number < 10 ? (char) (number + '0') : (char) (number - 10 + 'a'));
            if (!code.contains(symbol)) {
                code += symbol;
            }
        } while (code.length() < codeLength);
        return code;
    }

    public boolean successGuess(String guessNumber) {
        System.out.println("Grade: " + getGrade(guessNumber));
        if (guessNumber.equals(code)) {
            System.out.println("Congrats! The secret code is " + code + ".");
            return true;
        }
        return false;
    }

    private String getGrade(String guessNumber) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == guessNumber.charAt(i)) {
                bulls++;
            } else if (code.contains(guessNumber.substring(i, i + 1))) {
                cows++;
            }
        }
        if (bulls == 0 && cows == 0) {
            return "None";
        }
        String result = "";
        if (bulls > 0) {
            result = bulls + " bull(s)";
        }
        if (cows > 0) {
            if (bulls > 0) {
                result += " and ";
            }
            result += cows + " cow(s)";
        }

        return result;
    }
}
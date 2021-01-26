package bullscows;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final int input = scanner.nextInt();

        grader(String.valueOf(input), String.valueOf(9305));

    }

    static void grader(String input, String answer) {
        int countBulls = 0;
        int countCows = 0;

        Map<Character, Integer> inputMap = new HashMap<>();
        Map<Character, Integer> answerMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            inputMap.put(input.charAt(i), i);
            answerMap.put(answer.charAt(i), i);
        }

        for (Map.Entry<Character, Integer> inputEntry : inputMap.entrySet()) {
            for (Map.Entry<Character, Integer> answerEntry : answerMap.entrySet()) {
                if (inputEntry.getKey() == answerEntry.getKey() && inputEntry.getValue() == answerEntry.getValue()) {
                    countBulls++;
                } else if (inputEntry.getKey() == answerEntry.getKey() && inputEntry.getValue() != answerEntry.getValue()) {
                    countCows++;
                }
            }
        }

        if (countBulls == 0 && countCows == 0) {
            System.out.println("Grade: None. The secret code is 9305.");
        } else if (countBulls == 0) {
            System.out.println("Grade: " + countCows + " cow(s). The secret code is 9305.");
        } else {
            System.out.println("Grade: " + countBulls + " bull(s) and " + countCows + " cow(s). The secret code is 9305.");
        }


    }
}

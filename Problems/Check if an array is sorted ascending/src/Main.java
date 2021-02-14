import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int arrLength = scanner.nextInt();
        final int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(isAscending(arr));
    }

    static boolean isAscending(int[] arr) {
        boolean ascending = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                ascending = false;
                break;
            }
        }
        return ascending;
    }
}
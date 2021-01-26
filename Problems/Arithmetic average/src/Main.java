import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int a = scanner.nextInt();
        final int b = scanner.nextInt();

        System.out.println(average(a, b));
    }

    static double average(int a, int b) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = a; i <= b; i++) {
            if (i % 3 == 0) {
                list.add(i);
            }
        }
        for (Integer integer : list) {
            sum += integer;
        }
        return (double) sum / list.size();
    }
}
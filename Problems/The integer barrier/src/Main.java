import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int n = sc.nextInt();
        sum += n;

        while (n != 0) {
            if (sum >= 1000) {
                sum = sum - 1000;
                break;
            }
            n = sc.nextInt();
            sum += n;
        }

        System.out.println(sum);

    }


}
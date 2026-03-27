package Lab01;
import java.util.Scanner;

public class Tamgiacsao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            // mỗi dòng in (2*i - 1) dấu *
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println(); // xuống dòng
        }

        sc.close();
    }
}

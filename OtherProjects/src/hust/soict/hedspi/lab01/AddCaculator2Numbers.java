package hust.soict.hedspi.lab01;
import java.util.Scanner;


public class AddCaculator2Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập dữ liệu dạng String
        System.out.print("Enter first number: ");
        String strNum1 = sc.nextLine();

        System.out.print("Enter second number: ");
        String strNum2 = sc.nextLine();

        // Chuyển String -> double
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        // Tính toán
        double sum = num1 + num2;
        double diff = num1 - num2;
        double product = num1 * num2;

        System.out.println("Sum = " + sum);
        System.out.println("Difference = " + diff);
        System.out.println("Product = " + product);

        // Kiểm tra chia cho 0
        if (num2 != 0) {
            double quotient = num1 / num2;
            System.out.println("Quotient = " + quotient);
        } else {
            System.out.println("Cannot divide by 0!");
        }

        sc.close();
    }
}

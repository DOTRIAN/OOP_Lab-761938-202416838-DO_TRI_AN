import java.util.Scanner;


public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose problem:");
        System.out.println("1. Linear equation (ax + b = 0)");
        System.out.println("2. System of linear equations (2 variables)");
        System.out.println("3. Quadratic equation (ax^2 + bx + c = 0)");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                solveLinear(sc);
                break;
            case 2:
                solveSystem(sc);
                break;
            case 3:
                solveQuadratic(sc);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }

    public static void solveLinear(Scanner sc) {
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Infinite solutions");
            } else {
                System.out.println("No solution");
            }
        } else {
            double x = -b / a;
            System.out.println("Solution x = " + x);
        }
    }


    public static void solveSystem(Scanner sc) {
        System.out.print("Enter a1, b1, c1: ");
        double a1 = sc.nextDouble();
        double b1 = sc.nextDouble();
        double c1 = sc.nextDouble();

        System.out.print("Enter a2, b2, c2: ");
        double a2 = sc.nextDouble();
        double b2 = sc.nextDouble();
        double c2 = sc.nextDouble();

        double D = a1 * b2 - a2 * b1;
        double Dx = c1 * b2 - c2 * b1;
        double Dy = a1 * c2 - a2 * c1;

        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
                System.out.println("Infinite solutions");
            } else {
                System.out.println("No solution");
            }
        } else {
            double x = Dx / D;
            double y = Dy / D;
            System.out.println("x = " + x + ", y = " + y);
        }
    }

    public static void solveQuadratic(Scanner sc) {
        System.out.print("Enter a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        if (a == 0) {

            if (b == 0) {
                if (c == 0) {
                    System.out.println("Infinite solutions");
                } else {
                    System.out.println("No solution");
                }
            } else {
                double x = -c / b;
                System.out.println("Linear solution x = " + x);
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta < 0) {
                System.out.println("No real root");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("Double root x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }
}

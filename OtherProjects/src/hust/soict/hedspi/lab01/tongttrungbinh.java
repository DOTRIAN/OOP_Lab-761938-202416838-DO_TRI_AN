package hust.soict.hedspi.lab01;
import java.util.Arrays;
import java.util.Scanner;

public class tongttrungbinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }

        double avg = (double) sum / n;
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + avg);
        sc.close();
    }
}

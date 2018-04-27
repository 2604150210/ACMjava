package newcoder.contest;

import java.util.Scanner;

/**
 * Created by jal on 2018/4/27 0027.
 */
public class B2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int []a = new int[n];
        int []sum = new int[n];
        a[0] = scanner.nextInt();
        sum[0] = a[0];
        for (int i = 1; i < n; i++){
            a[i] = scanner.nextInt();
            sum[i] = sum[i-1] + a[i];
        }
        for (int i  = 0; i < a.length; i++){

        }
    }
}

package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/11/9 0009.
 */
public class P1807 {
    private static final int MAXN = 2000000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            arr[i] = a;
        }
        int gcd = greatestCommonDivisor(arr);

        if (gcd == 1) {
            //TODO
        } else {
            System.out.println(0);
        }
    }

    private static int greatestCommonDivisor(int[] arr) {
        int ret = arr[0];
        for (int i = 0; i < arr.length; i++) {
            ret = GCD(ret, arr[1]);
        }
        return ret;
    }

    private static int GCD(int a, int b) {
        if (a <= b) {
            int t = a;
            a = b;
            b = t;
        }
        return a % b == 0 ? b : GCD(b, a % b);
    }
}

package oj.ahstu.cc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2017/12/19 0019.
 */
public class P2119 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            if (n == 1) {
                System.out.println(a[0]);
                System.out.println(-1);
            } else {
                Arrays.sort(a);
                System.out.println(a[n - 1]);
                System.out.print(a[0]);
                for (int i = 1; i < n - 1; i++) {
                    System.out.print(" " + a[i]);
                }
                System.out.println();
            }

        }
    }
}

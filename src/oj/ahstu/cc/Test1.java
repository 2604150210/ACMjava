package oj.ahstu.cc;

/**
 * Created by jal on 2017/11/7 0007.
 */

import java.util.Scanner;

public class Test1 {
    public static Scanner cs = new Scanner(System.in);

    public static void main(String[] args) {
        int m = cs.nextInt();
        int sum = 0;
        int a[];
        while (m >= 1) {
            a = getInt();
            for (int i = 0; i < a.length; i++) {
                if (isSushu(a[i])) {
                    sum += a[i];
                }
            }
            m--;
            System.out.println(sum);
        }
    }
    public static int[] getInt() {
        int n = cs.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = cs.nextInt();
        }
        return a;
    }

    public static boolean isSushu(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0 && n != i) {
                return false;
            }
        }
        return true;
    }

}
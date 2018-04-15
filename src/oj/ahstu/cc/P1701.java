package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/11/8 0008.
 */
public class P1701 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = q(n, n);
        System.out.println(s);

    }

    private static int q(int n, int m) {
        if (n < 1 || m < 1) return 0;
        if (n == 1 || m == 1) return 1;
        if (n < m) return q(n, n);
        if (n == m) return q(n, m - 1) + 1;
        return q(n, m - 1) + q(n - m, m);
    }


}

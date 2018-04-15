package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/11/8 0008.
 */
public class P1730 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c, d, e, f;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();
        e = scanner.nextInt();
        f = scanner.nextInt();
        int x, y;
        y = (a * f - d * c) / (a * e - d * b);
        x = (c - b * y) / a;
        System.out.println(x + " " + y);
    }
}

package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/11/13 0013.
 */
public class P1655 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double delta = Math.sqrt(b * b - 4 * a * c);
        double x1 = (-b + delta) / (2 * a);
        double x2 = (-b - delta) / (2 * a);
        if (a < 0) {
            double t = x1;
            x1 = x2;
            x2 = t;
        }
        System.out.printf("%.2f %.2f\n", x1, x2);
    }
}

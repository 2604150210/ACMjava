package oj.ahstu.cc;


import java.util.Scanner;

/**
 * Created by jal on 2017/11/10 0010.
 */
public class P1525 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double Pi = 3.1415926;
        Double H = scanner.nextDouble();
        Double R = scanner.nextDouble();
        Double r = scanner.nextDouble();
        Double h = scanner.nextDouble();
        Double d = H - h;
        Double x = d * r / H;
        R = x;
        Double V = 1.0 / 3 * Pi * h * (R * R + r * r + R * r);
        System.out.printf("%.2f\n", V);
    }
}

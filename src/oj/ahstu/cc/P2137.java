package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/19 0019.
 */
public class P2137 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            double c = a + b;
            if (Double.toString(c).substring(Double.toString(c).length() - 2).equals(".0")) {
                System.out.println(Double.toString(c).substring(0, Double.toString(c).length() - 2));
            } else {


                String str = String.format("%.4e", c);
                if (str.contains("e+0")) {
                    int index = str.indexOf('e');
                    str = new StringBuffer(str).delete(index + 1, index + 3).toString();
                }
                System.out.println(str);
            }
        }
    }
}

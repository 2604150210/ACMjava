package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/11/24 0024.
 */
public class Strcat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            double c = a + b;
            //System.out.println(c);


            if (c < 0) {
                System.out.print("-");
                c *= -1;
            }

            String s = Double.toString(c);
            //System.out.println(s);
            int index = s.length() - 2;
            if (s.substring(s.length() - 2, s.length()).equals(".0")) {
                System.out.println(s.substring(0, s.length() - 2));
            } else {
                for (int i = 0; i < s.length() - 1; i++) {
                    if (s.substring(i, i + 1).equals(".")) {
                        index = i;
                        break;
                    }
                }

                if (index != s.length() - 1) {
                    System.out.print(s.substring(0, 1) + ".");
                    for (int i = 1; i < index; i++) {
                        System.out.print(s.substring(i, i + 1));
                    }
                    for (int i = index + 1; i < s.length(); i++) {
                        System.out.print(s.substring(i, i + 1));
                    }
                    System.out.println("+e" + (index - 1));
                }
            }

        }
    }
}

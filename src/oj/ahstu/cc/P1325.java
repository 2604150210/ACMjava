package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/16 0016.
 */
public class P1325 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String str = "";
            for (int i = 0; i < n; i++) {
                str = str + (char) ('A' + i) + str;
            }
            System.out.println(str);
        }
    }
}

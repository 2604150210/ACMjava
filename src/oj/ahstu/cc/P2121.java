package oj.ahstu.cc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2017/12/19 0019.
 */
public class P2121 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            char cs[] = str.toCharArray();
            Arrays.sort(cs);
            str = String.valueOf(cs);
            System.out.println(str);
        }
    }
}

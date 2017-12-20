package oj.ahstu.cc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by jal on 2017/11/27 0027.
 */
public class P2128 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        while(m-->0){
            String str = scanner.nextLine();

            char []arr = str.toCharArray();

            Arrays.sort(arr);
            for(char i: arr){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}

package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/5 0005.
 */
public class FullArray {
    private static int n;
    private static int []book,out;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        book = new int[10];
        out = new int[10];
        dfs(n);
    }

    private static void dfs(int step) {
        if(step >= 9){

        }
    }
}

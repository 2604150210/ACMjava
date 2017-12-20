package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/20 0020.
 */
public class P2130 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n= scanner.nextInt();
            int a[][] = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    a[j][i] = scanner.nextInt();
                }
            }
            for(int i = 0; i < n; i++){
                System.out.print(a[i][0]);
                for(int j = 1; j < n; j++){
                    System.out.print(" "+a[i][j]);
                }
                System.out.println();
            }
        }
    }
}

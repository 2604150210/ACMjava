package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/19 0019.
 */
public class P2125 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a[][]  = new int[2][3];
            int b[][] = new int[3][2];
            for(int i = 0; i < 2; i++){
                for(int  j = 0; j < 3; j++){
                    a[i][j] = scanner.nextInt();
                }
            }
            for(int i = 0; i < 3; i++){
                for(int  j = 0; j < 2; j++){
                   b[i][j] = scanner.nextInt();
                }
            }
            int c[][] = new int[2][2];
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    for(int k = 0; k < 3; k++){
                        c[i][j] +=a[i][k]*b[k][j];
                    }
                }
            }
            System.out.println(c[0][0]+" " + c[0][1]);
            System.out.println(c[1][0] + " " + c[1][1]);
        }
    }
}

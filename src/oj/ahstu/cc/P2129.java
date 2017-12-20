package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/19 0019.
 */
public class P2129 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int a[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                int max = 0,sum = 0,j;
                for (j = 0; j < m; j++){
                    a[i][j] = scanner.nextInt();
                    sum+=a[i][j];
                    if(a[i][j] > a[i][max]){
                        max = j;
                    }
                }
                a[i][max] = sum;
            }
            for(int i = 0; i < n; i++){
                System.out.print(a[i][0]);
                for(int j = 1; j < m ;j++){
                    System.out.print(" "+a[i][j]);
                }
                System.out.println();
            }

        }
    }
}

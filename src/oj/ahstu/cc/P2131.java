package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/20 0020.
 */
public class P2131 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int a[][] = new int[n][n];
            for(int  i = 0; i < n; i++){
                for(int j = 0; j<n; j++)
                    a[i][j] = scanner.nextInt();
            }
            int flag = 0;
            for (int i = 0; i < n; i++){
                for(int j = 0; j <= i;j++){
                    if(a[i][j] != a[j][i]){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1)break;
            }
            if(flag == 0){
                System.out.println("Yes!");
            }
            else System.out.println("No!");
        }
    }
}

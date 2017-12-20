package oj.ahstu.cc;

import java.awt.*;
import java.util.Scanner;

/**
 * Created by jal on 2017/11/13 0013.
 */
public class P1777 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        int m = scanner.nextInt();
        Point[] arr = new Point[m+1];
        arr[0] = new Point(0,0);
        for(int i = 1; i <= m; i++){
            arr[i] = new Point(scanner.nextInt(),scanner.nextInt());
        }
        int [][]dp = new int[m+1][capacity+1];//表示最大价值
        for(int i = 1;  i <= m; i++){
            for(int j = 1; j <=capacity; j++){//j表示容量打表
                if(arr[i].x <= j) {//装的进去
                    //dp[j][i] = Math.max(dp[j][i - 1], dp[j - arr[i].x][i - 1] + arr[i].y);//不取，取
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-arr[i].x]+arr[i].y);
                }else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        System.out.println(dp[m][capacity]);
    }
}
/*
*
70 3
71 100
69 1
1 2
*
* */
package jiSuanKe.test_5_13;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2018/5/13 0013.
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-->0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int []a = new int[n];
            int []dp = new int[n];
            for (int i = 0; i < n; i++){
                a[i] = scanner.nextInt();
            }
            Arrays.fill(dp,1);
            for (int i = 0; i < n; i++){
                for (int j = 0; j < i; j++){
                    if (Math.abs(a[j] - a[i]) <= k){
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
            }
            Arrays.sort(dp);
            System.out.println(dp[n-1]);

        }
    }
}

package newcoder.contest.test_5_13;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2018/5/13 0013.
 */
public class I2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int []a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = (scanner.nextInt());
            }
            int sum = 0;
            int []dp = new int[n];
            Arrays.fill(dp,-1);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < i; j++){
                    if(a[i] <= a[j]){
                        dp[j] = Math.max(dp[j], dp[i] + 1);
                    }
                }
            }
            for(int i = 0; i < n; i++){
                sum = Math.max(sum, dp[i]);
            }
            if (sum == n){
                System.out.println(0);
                continue;
            }
            System.out.println(n - sum);
        }
    }

    private static int getMax(int[]a, int left, int right) {
        int maxResult = a[left];
        int index = left;
        for (int i = left+1; i <= right; i++){
            if (a[i] > maxResult){
                index = i;
                maxResult = a[i];
            }
        }
        return index;
    }

}

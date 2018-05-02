package classical_algorithm.DP.digital;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2018/5/2 0002.
 */
public class HDU2089不要62 {
    static int []a;
    static int [][]dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            if (left == 0 && right == 0) break;
            dp = new int[20][2];
            for (int i = 0; i < 20; i++){
                for (int j = 0; j <= 1; j++){
                    dp[i][j] = -1;
                }
            }
            System.out.println(solve(right) - solve(left-1));
        }
    }

    private static int solve(int n) {
        int pos = 0;
        a = new int[20];
        while (n > 0){
            a[pos++] = n % 10;
            n /= 10;
        }
        return dfs(pos -1, -1, 0, true);//dfs(当前位，前一位的值， 前一位的值是否为6，当前位是够受限)

    }

    private static int dfs(int pos, int pre, int state, boolean limited) {
        if (pos == -1)return 1;
        if (!limited && dp[pos][state] != -1){
            return dp[pos][state];
        }
        int cnt = 0;
        int up = limited ? a[pos] : 9;
        for (int i = 0; i <= up; i++){
            if (i == 4)continue;
            if (pre == 6 && i == 2)continue;
            cnt += dfs(pos - 1, i, i == 6 ? 1 : 0, limited && i == a[pos]);
        }
        if (!limited){
            dp[pos][state] = cnt;//如果不受限，则记忆当前的状态
        }
        return cnt;
    }
}

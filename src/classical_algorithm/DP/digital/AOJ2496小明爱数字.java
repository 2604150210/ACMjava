package classical_algorithm.DP.digital;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by jal on 2018/5/2 0002.
 */
public class AOJ2496小明爱数字 {
    static int[]a;
    static BigInteger[][]dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String n = scanner.nextLine();
            dp = new BigInteger[100001][10];
            for (int i = 0; i < 100001; i ++){
                for (int j = 0; j < 10; j++){
                    dp[i][j] = BigInteger.valueOf(-1);
                }
            }
            System.out.println(solve(n).subtract(BigInteger.valueOf(1)));
        }
    }

    private static BigInteger solve(String str) {
        char[] n = str.toCharArray();
        int len = n.length;
        a = new int[100001];
        int pos = 0;
        for (pos = 0; pos < len; pos ++){
            a[pos] = n[len-pos-1] - '0';
        }
        return dfs(pos-1, -1, 0, true);//dfs(当前位，前一位的值，当前状态，当前位是否受限)
    }

    private static BigInteger dfs(int pos, int pre, int state, boolean limited) {
        if (pos == -1)return BigInteger.ONE;
        if (!limited && dp[pos][state] != BigInteger.valueOf(-1)) return dp[pos][state];
        int up = limited ? a[pos] : 9;
        BigInteger cnt = BigInteger.ZERO;

        for (int i = 0; i <= up; i++){
            if (pre > i)continue;
            cnt =cnt.add(dfs(pos-1, i, i, limited && i == a[pos]));
        }
        if (! limited){
            dp[pos][state] = cnt;
        }
        return cnt;
    }
}

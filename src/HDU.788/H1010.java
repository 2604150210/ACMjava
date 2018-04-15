package HDU788;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/9 0009.
 */
public class H1010 {
    private static int[] a;
    private static char[] out;
    private static int cnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            a = new int[5];
            for (int i = 0; i < 5; i++) {
                a[i] = scanner.nextInt();
            }
            cnt = 0;
            out = new char[4];
            dfs(0);
            System.out.println(cnt);
        }

    }

    private static void dfs(int step) {
        if (step >= 4) {
            int sum = a[0];
            if (out[0] == '+') sum += a[1];
            if (out[0] == '-') sum -= a[1];
            if (out[1] == '+') sum += a[2];
            if (out[1] == '-') sum -= a[2];
            if (out[2] == '+') sum += a[3];
            if (out[2] == '-') sum -= a[3];
            if (out[3] == '+') sum += a[4];
            if (out[3] == '-') sum -= a[4];
            if (sum == 24) cnt++;
            return;
        }
        out[step] = '+';
        dfs(step + 1);

        out[step] = '-';
        dfs(step + 1);
    }
}

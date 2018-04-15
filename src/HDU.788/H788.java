package HDU788;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/9 0009.
 */
public class H788 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int a[] = new int[n];
            int sum[] = new int[n + 1];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            sum[0] = 0;
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + a[i - 1];
            }
            int flag = 0;
            int i = 0, j = 0;
            for (i = 1; i < n; i++) {
                for (j = i + 1; j <= n; j++) {
                    if (sum[j] - sum[i - 1] == k) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) break;
            }
            System.out.println(i + " " + j);
        }
    }
}

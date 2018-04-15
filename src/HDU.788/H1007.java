package HDU788;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/9 0009.
 */
public class H1007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            long s = 1;
            for (int i = 1; i < n; i++) {
                s *= i;
            }
            System.out.println(s);
        }
    }
}

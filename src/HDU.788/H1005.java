package HDU788;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/9 0009.
 */
public class H1005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int s = a * b;
            s %= 10007;
            System.out.println(s);
        }
    }
}

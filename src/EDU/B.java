package EDU;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/8 0008.
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        if (n > m) {
            long t = n;
            n = m;
            m = n;
        }
        if (n == 1) System.out.println(0);
        else if (n == 2) System.out.println((m - 2) * 2);
        else
            System.out.println(2 * m * n - 3 * n - 3 * m + 8);
    }
}

package HDU788;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/9 0009.
 */
public class H1002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            double maxn = 0.0;
            while (n-- > 0) {
                String first = scanner.next();
                String[] arr = {};
                double s = 0.0;
                if (first.equals("T")) {
                    s = Integer.parseInt(arr[1]) * Integer.parseInt(arr[2]) / 2.0;

                } else if (first.equals("R")) {
                    s = Integer.parseInt(arr[1]) * Integer.parseInt(arr[2]);

                } else {
                    s = 3.14159 * Integer.parseInt(arr[1]) * Integer.parseInt(arr[1]);
                }
                if (maxn < s) {
                    maxn = s;
                }
            }
            System.out.println(String.format("%.2f\n", maxn));

        }
    }
}

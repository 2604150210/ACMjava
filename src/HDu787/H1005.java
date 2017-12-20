package HDu787;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/10 0010.
 */
public class H1005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int j = 1; j <= T; j++){
            int n = scanner.nextInt();
            int s = 0;
            for (int i = 0; i < n;i++){
                int a =scanner.nextInt();
                s += a + (int)Math.ceil(a*0.1);
            }

            System.out.println("Case #"+j+": "+s);
        }
    }
}

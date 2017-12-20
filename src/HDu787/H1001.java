package HDu787;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/10 0010.
 */
public class H1001 {
    private static int []book,out;
    private static int cns,n,sum;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int  t = 1; t <= T; t++) {
            n = scanner.nextInt();
            cns = 0;
            sum = 0;
            out = new int[n];
            book = new int[n];
            dfs(0);
            double v = sum * 1.0 / cns;
            System.out.println(String.format("Case #%d: %.10f", t, v));

        }
    }

    private static void dfs(int step) {
        if(step >= n){
            cns++;
            for(int i = 0; i < n; i++){
                if (out[i] != i)sum++;
            }
        }
        for(int i = 0;i<n;i++){
            if(book[i]==0){
                book[i]=1;
                out[step]=i;
                dfs(step+1);
                book[i]=0;
            }
        }
    }
}

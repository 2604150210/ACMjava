package classical_algorithm.segment_tree;

import java.io.*;
import java.util.Arrays;

import static java.util.Arrays.deepToString;

/**
 * Created by jal on 2018/5/2 0002.
 */
public class nyist228士兵杀敌5_AC {
    static int n,c,q;
    static int[] a = new int[1000003];

    public static void main(String[] args) throws IOException{
        // 这句是io流包装，记住就好
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        //StreamTokenizer.TT_EOF这个是个参数，就是EOF
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            in.nextToken();
            c = (int) in.nval;
            in.nextToken();
            q = (int) in.nval;
            Arrays.fill(a,0);
            int left,right,val;
            for(int i = 1; i <= c; i++){
                in.nextToken();
                left = (int)in.nval;
                in.nextToken();
                right = (int)in.nval;
                in.nextToken();
                val = (int)in.nval;
                a[left] += val;
                a[right+1] -= val;
            }
            for(int i = 1; i <= n; i++){
                a[i] += a[i-1];
            }
            for(int i = 1; i <= n; i++){
                a[i] = (a[i] + a[i-1]) % 10003;
            }
            for(int i = 1; i <= q; i++){
                in.nextToken();
                left = (int) in.nval;
                in.nextToken();
                right = (int) in.nval;
                out.print(String.format("%d\n",(a[right] - a[left-1] + 10003 ) % 10003));
                out.flush();
            }
        }
    }

}

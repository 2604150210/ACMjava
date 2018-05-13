package classical_algorithm.unknown;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jal on 2018/5/9 0009.
 */
import java.io.*;
public class NYIST133子序列 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int T = (int) in.nval;
        while (T-- > 0){
            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Integer, Integer> map2 = new HashMap<>();
            in.nextToken();
            int n = (int) in.nval;
            int []a = new int[n];
            for(int i = 0; i < n;i++){
                in.nextToken();
                a[i] = (int) in.nval;
                if (map.containsKey(a[i])){
                    map.put(a[i], map.get(a[i])+1);
                    map2.put(a[i], map2.get(a[i])+1);
                }
                else {
                    map.put(a[i], 1);
                    map2.put(a[i], 1);

                }
            }
            int i = 0, j = n-1;
            while (i <= n-1){
                if (map.get(a[i]) > 1){
                    map.put(a[i], map.get(a[i])-1);
                    i++;
                }else {
                    break;
                }
            }
            while (j >= i){
                if (map.get(a[j]) > 1){
                    map.put(a[j], map.get(a[j])-1);
                    j--;
                }
                else {
                    break;
                }
            }
            int len1 = j - i + 1;
           i = 0;
           j = n-1;

            while (j >= i){
                if (map2.get(a[j]) > 1){
                    map2.put(a[j], map2.get(a[j])-1);
                    j--;
                }
                else {
                    break;
                }
            }
            while (i <= n-1){
                if (map2.get(a[i]) > 1){
                    map2.put(a[i], map2.get(a[i])-1);
                    i++;
                }else {
                    break;
                }
            }
            int len2 = j - i + 1;
            out.println(Math.min(len1,len2));
            out.flush();
        }
    }
}

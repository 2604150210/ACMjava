package classical_algorithm.unknown;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**离散化、滑窗法
 * Created by jal on 2018/5/9 0009.
 */

public class NYIST133子序列2 {
    static StreamTokenizer in = null;
    static {
        try{
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(new FileInputStream("./bin/in.txt"))));
        }catch (IOException e){
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int T = (int) in.nval;
        while (T-- > 0){
            in.nextToken();
            int n = (int) in.nval;
            int []a = new int[n];
            ArrayList<Integer>b = new ArrayList<>();
            for(int i = 0; i < n;i++){
                in.nextToken();
                a[i] = (int) in.nval;
                if (!b.contains(a[i])){
                    b.add(a[i]);
                }
            }
            Collections.sort(b);
            int []c = new int[n];
            for (int i = 0; i < n; i++){
                c[i] = b.indexOf(a[i]);
            }
            int len = b.size();
            HashMap<Integer,Integer>map = new HashMap<>();
            int min = n;
            int left = 0, right = 0;
            while(right < n){
                while (map.size() < len && right < n){
                    if (map.containsKey(c[right])){
                        map.put(c[right],map.get(c[right])+1);
                    }else {
                        map.put(c[right],1);
                    }
                    right++;
                }
                while (map.size()>=len && left <= right){
                    min = Math.min(min, right - left);
                    if (map.get(c[left])>1){
                        map.put(c[left],map.get(c[left])-1);
                    }else {
                        map.remove(c[left]);
                    }
                    left++;

                }
            }
            out.print(String.format("%d\n",min));
            out.flush();
        }
    }
}

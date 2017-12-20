package EDU;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jal on 2017/12/8 0008.
 */
public class C {
    private static String str;
    private static int len,find = 0;
    private static char[] out,book,a,b;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        len = str.length();
        a = str.toCharArray();
        b = str.toCharArray();
        Arrays.sort(b);
        int flag = 0;
        out = new char[len];
        book = new char[len];
        HashMap<Character,Integer>hashMap = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(hashMap.containsKey(a[i])){
                int t = hashMap.get(a[i]);
                hashMap.put(a[i],t+1);
            }else {
                hashMap.put(a[i],1);
            }
            if(hashMap.get(a[i]) > len / 2){
                flag = 1;
                System.out.println("impossible");
                break;
            }
        }

        if(flag == 0) {
            dfs(0);
            if (find == 0) {
                System.out.println("impossible");
            }
        }
    }

    private static void dfs(int step) {
        if(find == 0){
            if(step >= len ){
                find = 1;
                System.out.println(String.valueOf(out));

                return;
            }
            for(int i = 0; i < len; i++){
                if(book[i] == 0 && a[step] != b[i]){
                    book[i] = 1;
                    out[step] = b[i];
                    dfs(step + 1);
                    book[i] = 0;
                }
            }
        }
        }

}

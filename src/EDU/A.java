package EDU;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jal on 2017/12/8 0008.
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int []a = new int[6];
        int []b = new int[6];
        for(int i= 0; i < 6; i++){
            a[i] = scanner.nextInt();
        }
        for(int i= 0; i < 6; i++){
           b[i] = scanner.nextInt();
        }

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                int t = a[i]+b[j];
                t = t % p;
                if(hashMap.containsKey(t)){
                    int val = hashMap.get(t);
                    hashMap.put(t,val+1);
                }else{
                    hashMap.put(t,1);
                }
            }
        }
        int flag = 0;
        for (Integer i: hashMap.keySet()){
            if(hashMap.get(i) != 36/p){
                flag = 1;
                System.out.println("NO");
                break;
            }
        }
        if (flag == 0) System.out.println("YES");
    }
}

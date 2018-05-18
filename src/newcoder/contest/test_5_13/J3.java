package newcoder.contest.test_5_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2018/5/13 0013.
 */
public class J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 10002;
        int []a = new int[max];
        Arrays.fill(a,1);
        for(int i = 2; i < max;i++){
            if (a[i] == 1){
                for (int j = i*i; j<max;j+=i){
                    a[j] = 0;
                }
            }
        }
        ArrayList<Integer>list = new ArrayList<>();
        for (int i = 2; i < max; i++){
            if (a[i] == 1){
                list.add(i);
            }
        }
        System.out.println(list);
    }
}

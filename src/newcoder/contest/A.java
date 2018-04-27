package newcoder.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jal on 2018/4/27 0027.
 */
public class A {
    static char[]chars;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            chars = str.toCharArray();
            int []dp = new int[chars.length];
            Arrays.fill(dp,1);
            for (int i = 1; i < chars.length; i++){
                for (int j = 0; j < i; j++){
                    if(chars[i] <= chars[j]){
                        if(dp[j] + 1 > dp[i]){
                            dp[i] = dp[j] + 1;
                        }
                    }
                }
            }
            System.out.println(dp[chars.length-1]);
    }

    }
}

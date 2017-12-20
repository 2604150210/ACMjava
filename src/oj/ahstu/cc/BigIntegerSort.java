package oj.ahstu.cc;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2017/11/27 0027.
 */
public class BigIntegerSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = Integer.parseInt(scanner.nextLine());
            String[] arr = new String[n];
            for(int i = 0 ;i < n; i++){
                arr[i] = scanner.nextLine();
            }
            //Arrays.sort(arr,new cmp());
            for(String i : arr){
                System.out.println(i);
            }
        }
    }
}

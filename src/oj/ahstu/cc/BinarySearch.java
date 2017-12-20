package oj.ahstu.cc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2017/11/24 0024.
 */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            if (n == 0)break;
            int [] a = new int[n+1];
            for(int i = 1; i <= n; i++){
                a[i] = scanner.nextInt();
            }
            int deep = scanner.nextInt();

            int i;
            int t = 1;
            int index = 0;
            for( i = 1; i < deep; i ++){
                index += t;
                t *= 2;
            }
            index ++;
            if(index > n ){
                System.out.println("EMPTY");
            }else {
                System.out.print(a[index]);
                int k = 1;
                for(int j = index+1; j <= n; j++){
                    k++;
                    if(k > Math.pow(2,deep-1))break;
                    System.out.print(" "+ a[j]);
                }
                System.out.println();
            }
        }
    }
}

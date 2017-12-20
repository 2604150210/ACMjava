package oj.ahstu.cc;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2017/12/19 0019.
 */
public class P2122 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            BigInteger a[ ] = new BigInteger[n];
            for(int i = 0; i < n; i++)a[i] = scanner.nextBigInteger();
            Arrays.sort(a);
            for (BigInteger i : a){
                System.out.println(i);
            }
        }
    }
}

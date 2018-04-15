package oj.ahstu.cc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2017/12/6 0006.
 */
public class SievePrime {
    private static final int MAXN = 2000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int isPrime[] = new int[MAXN];
        Arrays.fill(isPrime, 1);
        isPrime[0] = 0;
        isPrime[1] = 0;
        for (int i = 2; i < MAXN; i++) {
            if (isPrime[i] == 1) {
                for (int j = i * i; j < MAXN; j += i) {
                    isPrime[j] = 0;
                }
            }
        }
        int n = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            if (isPrime[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }
}

package oj.ahstu.cc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2017/11/8 0008.
 */
public class P1712 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prime = new int[n + 1];
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = 0;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i] == 1)
                primes.add(i);
        }
        int n1 = n;
        ArrayList<Integer> fab = new ArrayList<>();
        int index = 0;
        while (n1 != 1) {
            if (n1 % primes.get(index) == 0) {
                fab.add(primes.get(index));
            }
            while (n1 % primes.get(index) == 0) {
                n1 /= primes.get(index);
            }

            index++;
        }
        //System.out.println(fab.toString());
        long s = n;
        for (int i = 0; i < fab.size(); i++) {
            s = s / fab.get(i) * (fab.get(i) - 1);
        }
        System.out.println(s);
    }
}

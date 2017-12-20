package oj.ahstu.cc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2017/11/8 0008.
 */
public class P1732 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Boolean [] isPrime = new Boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i*i <= n; i++){
            if(isPrime[i] == true){
                for(int j = i * i; j <= n; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(isPrime[i] == true){
                primes.add(i);
            }
        }
        ArrayList<Integer> fab = new ArrayList<>();
        int n1 = n;
        int t = 0;
        while(n1 != 1){
            if(n1 % primes.get(t) == 0){
                fab.add(primes.get(t));
            }
            while (n1%primes.get(t) == 0){
                n1 /= primes.get(t);
            }
            t++;
        }
        int flag = 0;
        for(int i : fab){
            if(flag == 0){
                flag = 1;
                System.out.print(i);
            }
            else System.out.print(" " + i);
        }
    }
}

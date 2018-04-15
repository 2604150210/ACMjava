package EDU;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by jal on 2017/12/8 0008.
 */
public class D {
    private static Vector<Integer> v;
    private static int[] out;
    private static int n;

    public static void main(String[] args) {
        int maxn = 1000000;
        int isPrime[] = new int[maxn];
        Arrays.fill(isPrime, 1);
        isPrime[0] = isPrime[1] = 0;
        for (int i = 2; i < maxn; i++) {
            if (isPrime[i] == 1) {
                for (int j = i * i; j * j < maxn; j += i) {
                    isPrime[j] = 0;
                }
            }
        }
        v = new Vector<>();
        for (int i = 0; i < maxn; i++) {
            if (isPrime[i] == 1) {
                v.add(i);
            }
        }
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] a = new int[n];
        LinkedList<Integer> list[] = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            list[i] = factor(a[i]);
        }

    }

    private static LinkedList<Integer> factor(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = 0;
        while (n > 0) {
            if (n % v.get(i) == 0) list.add(v.get(i));
            while (n % v.get(i) == 0) {
                n /= v.get(i);
            }
            i++;
        }
        return list;
    }


}

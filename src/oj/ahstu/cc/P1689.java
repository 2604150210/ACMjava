package oj.ahstu.cc;

import java.util.Arrays;

/**
 * Created by jal on 2017/11/13 0013.
 */
public class P1689 {
    private static int t = 0;
    private static int[] a, book;

    public static void main(String[] args) {
        a = new int[10];
        book = new int[10];
        for (int i = 1; i < 10; i++) {
            a[i] = 0;
        }

        Arrays.fill(book, 0);
        dfs(1);

    }

    private static void dfs(int step) {
        if (step >= 10) {
            int x = a[1] * 100 + a[2] * 10 + a[3];
            int y = a[4] * 100 + a[5] * 10 + a[6];
            int z = a[7] * 100 + a[8] * 10 + a[9];
            if (y % x == 0 && z % x == 0 && y / x == 2 && z / x == 3) {
                System.out.println("" + x + " " + y + " " + z);
            }

            return;
        }
        for (int i = 1; i < 10; i++) {
            if (book[i] == 0) {
                a[step] = i;
                book[i] = 1;
                dfs(step + 1);
                book[i] = 0;
            }
        }
    }
}

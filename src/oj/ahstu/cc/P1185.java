package oj.ahstu.cc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jal on 2017/11/8 0008.
 */
public class P1185 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int t = 0;
        while (scanner.hasNext()) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            if (key == 0 && value == 0) break;
            for (int i = 0; i < value; i++) {
                arr.add(key);
            }
        }
        int d = n * n - arr.size();
        for (int i = 0; i < d; i++) {
            arr.add(0);
        }
        for (int i = 0; i < arr.size(); i++) {
            if (i % n == n - 1) {
                System.out.println(arr.get(i));
            } else {
                System.out.print(arr.get(i) + " ");
            }
        }
    }
}

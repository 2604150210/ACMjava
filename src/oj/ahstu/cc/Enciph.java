package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/11/28 0028.
 */
public class Enciph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int k = Integer.parseInt(scanner.nextLine());
            System.out.println(enciph(str, k));
        }
    }

    private static String enciph(String str, int k) {

        char[] arr = str.toCharArray();
        if (k >= 0) {
            k %= 26;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != ' ') {
                    if (arr[i] <= 'z' && arr[i] >= 'a') {
                        arr[i] += k;
                        if (arr[i] > 'z') {
                            arr[i] -= 26;
                        }
                    }
                    if (arr[i] <= 'Z' && arr[i] >= 'A') {
                        arr[i] += k;
                        if (arr[i] > 'Z') {
                            arr[i] -= 26;
                        }
                    }
                }
            }
        } else {
            k *= -1;
            k %= 26;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != ' ') {
                    if (arr[i] <= 'z' && arr[i] >= 'a') {
                        arr[i] -= k;
                        if (arr[i] < 'a') {
                            arr[i] += 26;
                        }
                    }
                    if (arr[i] <= 'Z' && arr[i] >= 'A') {
                        arr[i] -= k;
                        if (arr[i] < 'a') {
                            arr[i] += 26;
                        }
                    }
                }
            }
        }
        str = String.valueOf(arr);
        return str;
    }
}

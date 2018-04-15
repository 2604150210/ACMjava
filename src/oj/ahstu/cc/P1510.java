package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/11/10 0010.
 */
public class P1510 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int n = Integer.valueOf(line.split(" ")[0]);
            int m = Integer.valueOf(line.split(" ")[1]);

            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            int ans1 = 0, ans2 = 0;
            String[] s1 = str1.split(" ");
            String[] s2 = str2.split(" ");
            int a1 = 0, a2 = 0;
            for (int i = 0; i < s1.length; i++) {
                try {
                    int value = Integer.valueOf(s1[i]);
                    ans1 += value;
                } catch (NumberFormatException e) {
                    if (!s1[i].equals("A")) {
                        ans1 += 10;
                    } else {
                        a1++;
                    }
                }
            }
            ans1 += a1;
            for (int i = 0; i < a1; i++) {
                if (ans1 + 10 <= 21) {
                    ans1 += 10;
                } else {
                    break;
                }
            }
            if (ans1 > 21) ans1 = 0;
            for (int i = 0; i < s2.length; i++) {
                try {
                    int value = Integer.valueOf(s2[i]);
                    ans2 += value;
                } catch (NumberFormatException e) {
                    if (!s2[i].equals("A")) {
                        ans2 += 10;
                    } else {
                        a2++;
                    }
                }
            }
            ans2 += a2;
            for (int i = 0; i < a2; i++) {
                if (ans2 + 10 <= 21) {
                    ans2 += 10;
                } else {
                    break;
                }
            }
            //System.out.println(ans2);
            if (ans2 > 21) ans2 = 0;
            if (ans1 >= ans2) {
                System.out.println(ans1 + " vs " + ans2 + " HOST WIN");
            } else {
                System.out.println(ans1 + " vs " + ans2 + " GUEST WIN");

            }
        }
    }
}

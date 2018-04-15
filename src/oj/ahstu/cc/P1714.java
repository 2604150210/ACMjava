package oj.ahstu.cc;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by jal on 2017/11/7 0007.
 */
public class P1714 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, String> tm = new TreeMap<>();
        tm.put("WYS", "KXZSMR");
        tm.put("CQ", "CHAIQIANG");
        tm.put("LC", "DRAGONNET");
        tm.put("SYT", "STUDYFATHER");
        tm.put("SSD", "STUDYFATHER");
        tm.put("LSS", "STUDYFATHER");
        tm.put("LYF", "STUDYFATHER");
        String s1 = "DENOMINATOR";
        while (n-- > 0) {
            String str = scanner.nextLine();
            if (tm.containsKey(str)) {
                System.out.println(tm.get(str));
            } else System.out.println(s1);
        }
    }
}

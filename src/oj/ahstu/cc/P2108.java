package oj.ahstu.cc;


import java.util.Scanner;

/**
 * Created by jal on 2017/12/19 0019.
 */
public class P2108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String obeject = scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String strs[] = line.split("\\s+");
            String tmp = "";
            for (String i : strs) {
                tmp += i;
            }
            line = tmp;
            while (true) {
                int i;
                for (i = 0; i <= line.length() - obeject.length(); i++) {
                    if (line.substring(i, i + obeject.length()).toUpperCase().equals(obeject.toUpperCase())) {
                        line = new StringBuffer(line).delete(i, i + obeject.length()).toString();
                        break;
                    }
                }
                if (i > line.length() - obeject.length()) {
                    break;
                }
            }

            System.out.println(line);

        }
    }
}

package HDU788;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by jal on 2017/12/9 0009.
 */
public class H1006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> v = new Vector<>();
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int i = 5; i <= 1000000000; i += 5) {
            p.add(i);
        }
        for (int i = 7; i <= 1000000000; i += 7) {
            p.add(i);
        }
        System.out.println(p.peek());
        for (Integer i : p) {
            v.add(p.peek());
        }

        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            long sum = 0;
            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) > n) {
                    break;
                }
                sum += v.get(i);
            }
            System.out.println(sum);
        }
    }
}

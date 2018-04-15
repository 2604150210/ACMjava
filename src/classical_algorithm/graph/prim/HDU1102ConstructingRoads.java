package classical_algorithm.graph.prim;

/**
 * Created by jal on 2018/4/13 0013.
 */

import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

public class HDU1102ConstructingRoads {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";
    private static final int INFINITY = 9999;

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner sc = new Scanner(System.in);
    private int n;
    private int[][]a;
    private int []dis;//标记每个点到源点的最短距离
    private int []book;//标记每个点是否加入源点集合
    void run() {
        while (sc.hasNext()) {
            n = sc.nextInt();
            a = new int[n + 1][n + 1];
            dis = new int[n + 1];
            book = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int q = sc.nextInt();
            for (int i = 1; i <= q; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                a[u][v] = a[v][u] = 0;
            }
            for (int i = 1; i <= n; i++) {
                dis[i] = a[1][i];
            }
            int count = 0;
            book[1] = 1;
            dis[1] = 0;
            count++;
            int sum = 0;
            while (count < n) {
                int min = INFINITY;
                int j = 1;
                for (int i = 1; i <= n; i++) {
                    if (book[i] == 0 && dis[i] < min) {
                        min = dis[i];
                        j = i;
                    }
                }
                book[j] = 1;
                count++;
                sum += dis[j];
                for (int i = 1; i <= n; i++) {
                    if (book[i] == 0 && dis[i] > a[j][i]) {
                        dis[i] = a[j][i];
                    }
                }
            }
            System.out.println(sum);
        }
    }
    public void debug(Object ... objects){
        System.err.println(deepToString(objects));
    }
    public static void main(String[] args) {
        if (LOCAL) {
            try {
                System.setIn(new FileInputStream(INPUT_FILE));
            } catch (Throwable e) {
                LOCAL = false;
            }
        }
        if (TO_FILE) {
            try {
                System.setOut(new PrintStream(OUTPUT_FILE));
            } catch (FileNotFoundException e) {
                TO_FILE = false;
            }
        }
        new HDU1102ConstructingRoads().run();
    }
}
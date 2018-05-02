package classical_algorithm.graph.BFS_DFS;
import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

import java.util.Scanner;

/**
 * Created by jal on 2018/5/2 0002.
 */
public class AOJ1584炸弹人 {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = false;
    Scanner scanner = new Scanner(System.in);
    static int n,m;
    static char[][]G;
    void run() {
        while (scanner.hasNext()){
            n = scanner.nextInt();
            m = scanner.nextInt();
            G = new char[n][m];
            for (int i = 0; i < n; i++){
                G[i] = scanner.next().toCharArray();
                //System.out.println(G[i].length);
            }
            int max = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if (G[i][j] == '.')
                    max = Math.max(max, dfs(i,j));
                }
            }
            System.out.println(max);
        }
    }

    private int dfs(int x0, int y0) {
        int ret = 0;
        for (int i = x0+1; i <m; i++){
            if (G[i][y0] == 'G' )ret++;
            if (G[i][y0] == '#' )break;
        }
        for (int i = x0-1; i >= 0; i--){
            if (G[i][y0] == 'G' )ret++;
            if (G[i][y0] == '#' )break;
        }
        for (int i = y0+1; i <n; i++){
            if (G[x0][i] == 'G' )ret++;
            if (G[x0][i] == '#' )break;
        }
        for (int i = y0-1; i >=0; i--){
            if (G[x0][i] == 'G' )ret++;
            if (G[x0][i] == '#' )break;
        }
        return ret;
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
        new AOJ1584炸弹人().run();
    }
}

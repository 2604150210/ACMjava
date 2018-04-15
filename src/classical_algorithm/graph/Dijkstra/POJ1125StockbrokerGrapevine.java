package classical_algorithm.graph.Dijkstra;
//http://poj.org/problem?id=1125
import static java.util.Arrays.*;
import java.io.*;
import java.util.*;
/**
 * Created by jal on 2018/4/13 0013.
 */
public class POJ1125StockbrokerGrapevine {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner sc = new Scanner(System.in);
    private int n;
    private int[][]a;
    private final int INFINITY = 9999;
    void run() {
        while (sc.hasNext()){
            n = sc.nextInt();
            if (n == 0)break;
            a = new int[n+1][n+1];
            for (int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    a[i][j] = INFINITY;
                }
            }
            for(int i = 1; i <= n; i++){
                int m = sc.nextInt();
                while (m-->0){
                    int v = sc.nextInt();
                    int w = sc.nextInt();
                    a[i][v] = w;
                }
            }
            int index = 1, min = INFINITY;
            for(int i = 1; i <= n; i++){
                int maxDis = Dijkstra(i);
                if(min > maxDis){
                    min = maxDis;
                    index = i;
                }
            }
            if (min == INFINITY)
                System.out.println("disjoint");
            System.out.println(index+ " " + min);
        }
    }

    private int Dijkstra(int start) {
        int[] dis = new int[n+1];
        dis[0] = 0;
        int[] book = new int[n+1];
        fill(book,0);
        book[start] = 1;
        for (int i = 1; i <= n; i++){
            dis[i] = a[start][i];
        }
        dis[start] = 0;
        //Dijkstra核心语句
        for(int i = 1; i < n; i++){
            int min = INFINITY;
            int v = 1;
            for(int j = 1; j <= n; j++){
                if (book[j] == 0 && dis[j] < min ){
                    min = dis[j];
                    v = j;
                }
            }
            book[v] = 1;
            for (int j = 1; j <= n; j++){
                if(a[v][j] < INFINITY){
                    if (dis[j] > dis[v] + a[v][j]){
                        dis[j] = dis[v] + a[v][j];
                    }
                }
            }
        }
        sort(dis);
        return dis[n];
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
        new POJ1125StockbrokerGrapevine().run();
    }
}

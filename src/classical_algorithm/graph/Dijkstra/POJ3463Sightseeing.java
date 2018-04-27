package classical_algorithm.graph.Dijkstra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.deepToString;
import static java.util.Arrays.spliterator;

/**
 * Created by jal on 2018/4/26 0026.
 * 求最短路，次短路
 */
public class POJ3463Sightseeing {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner scanner = new Scanner(System.in);

    int n,m,s,f;
    int[]head;
    int cnt;
    class Edge{
        int to,next,value;
    }
    int [][]vis,dis,count;
    Edge[]edges;
    void run() {
        while (scanner.hasNext()){
            n = scanner.nextInt();
            m = scanner.nextInt();
            head = new int[n+1];
            Arrays.fill(head,-1);
            edges = new Edge[m+1];
            vis = new int[n+1][2];
            dis = new int[n+1][2];
            count = new int[n+1][2];
            Arrays.fill(vis, 0);
           Arrays.fill(dis, Integer.MAX_VALUE);
            Arrays.fill(count, 0);
            cnt = 1;
            for (int i = 0; i < m; i++){
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                addEdge(u,v,w);
            }
            s = scanner.nextInt();
            f = scanner.nextInt();
            int sum = Dijkstra(s,f);
            System.out.println(sum);
        }
    }

    private int Dijkstra(int s, int f) {
        vis[s][0] = 1;
        dis[s][0] = 0;
        count[s][0] = 1;
        int k = 0,flag = 0;
        for (int i = 1; i < 2 * n; i++){
            int tmp = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++){
                if(vis[j][0] != 0 && dis[j][0] < tmp){
                    tmp = dis[j][0];
                    k = j;
                    flag = 0;
                }
                else if(vis[j][1] != 0 && dis[j][1] < tmp){
                    tmp = dis[j][0];
                    k = j;
                    flag = 1;
                }
            }
            if (tmp == Integer.MAX_VALUE)break;
            vis[k][flag] = 1;
            for (int j = head[k]; j != -1; j = edges[j].next){
                int v = edges[j].to;
                if(vis[v][0] > tmp + edges[j].value){
                    dis[v][1] = dis[v][0];
                    count[v][1] = count[v][0];
                    dis[v][0] = tmp + edges[j].value;
                    count[v][0] = count[k][flag];
                }
                else if (vis[v][0] == tmp + edges[j].value){
                    count[v][0] += count[k][flag];;
                }
                else if (vis[v][1] > tmp + edges[j].value){
                    dis[v][1] = tmp + edges[j].value;
                    count[v][1] = count[k][flag];
                }else if (vis[v][1] == tmp + edges[j].value){
                    count[v][1] += count[k][flag];
                }
            }

        }
        if (dis[f][0] == dis[f][1] + 1){
            count[f][0] += count[f][1];
        }
        return count[f][0];
    }

    private void addEdge(int u, int v, int w) {
        edges[cnt].to = v;
        edges[cnt].value = w;
        edges[cnt].next = head[u];
        head[u] = cnt++;
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
        new POJ3463Sightseeing().run();
    }
}

package classical_algorithm.graph.Kruskal;

import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

public class HDU1102ConstructingRoads {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner cin = new Scanner(System.in);
    int [][]a;
    int n,q;
    Vector<Edge>edges;
    int []f;
    class Edge implements Comparable<Edge>{
       public int u,v,w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public Edge(){}

        @Override
        public String toString() {
            return "Edge{" +
                    "u=" + u +
                    ", v=" + v +
                    ", w=" + w +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
    void run() {
        while (cin.hasNext()){
            n = cin.nextInt();
            f = new int[n+1];
            for (int i = 1; i <= n; i++)f[i] = i;
            a = new int[n+1][n+1];
            edges  = new Vector<>();
            for (int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    a[i][j] = cin.nextInt();
                }
            }
            q = cin.nextInt();
            int M = n - q - 1;//实际需要的边数
            int sum = 0;
            int count = 0;
            for (int i = 1; i <= q; i++){
                int u = cin.nextInt();
                int v = cin.nextInt();
                a[u][v] = a[v][u] = 0;
            }
            for (int i = 1; i <= n; i++){
                for (int j = 1; j < i; j++){
                    edges.add(new Edge(i,j,a[i][j]));
                }
            }
            Collections.sort(edges);
          //  debug(edges);
            for (int i = 0; i < edges.size(); i++){
                int u = edges.get(i).u;
                int v = edges.get(i).v;
                int w = edges.get(i).w;
                if(merge(u,v)){
                    sum += w;
                    count++;
                    if (count > n){
                        break;
                    }
                }
            }
            System.out.println(sum);
        }
    }

    private boolean merge(int u, int v) {
        int fu = find(u);
        int fv = find(v);
        if(fu == fv)return false;
        f[fu] = fv;
        return true;
    }

    private int find(int u) {
        if(f[u] == u)return u;
        return f[u] = find(f[u]);
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
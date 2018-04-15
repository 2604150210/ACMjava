package classical_algorithm.graph.FloydWarshall;
//http://poj.org/problem?id=3615
/**
 * Created by jal on 2018/4/13 0013.
 */


import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

public class POJ3615CowHurdles{

    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    //Scanner sc = new Scanner(System.in);
    private int N,M,T;
    private final int INFINITY = 9000000;
    private int [][]a;
    void run() throws Exception{
         reader = new InputStreamReader(System.in);
        writer = new OutputStreamWriter(System.out);

        while (reader.ready()){
            N = getInt();
            M = getInt();
            T = getInt();
           // debug("N=",N,"M=",M,"T=",T);
            a = new int[N+1][N+1];
            for (int i = 1;i <= N; i++){
                for (int j = 1; j<=N;j++){
                    a[i][j] = INFINITY;
                }
            }
            for (int i = 1; i <= M; i++){
                int v = getInt();
                int u = getInt();
                int w = getInt();
               // debug("v=",v,"u=",u,"w=",w);
                a[v][u] = w;
            }
            FloydWarshall();
            //debug(a);
            for (int i = 1; i <= T; i++){
                int u = getInt();
                int v = getInt();
                if (a[u][v] >= INFINITY)
                    writer.write("-1\n");

                else
                    writer.write(a[u][v]+"\n");
                writer.flush();
            }
        }
    }

    private void FloydWarshall() {
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j= 1; j <= N; j++){
                    if (a[i][j] > Math.max(a[i][k],a[k][j])){
                        a[i][j] = Math.max(a[i][k],a[k][j]);
                    }
                }
            }
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
        try {
            new POJ3615CowHurdles().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取键盘输入的整数
     *
     * @return 输入的整数
     */
    public static int getInt() {
        int read;
        int res = 0;
        boolean isNegative = false;// 是不是负数
        try {
            while ((read = reader.read()) != -1) {
                if ((char) read == '-') {
                    res = 0;
                    isNegative = true;
                    break;
                } else if (isNumber((char) read)) {
                    res = read - '0';
                    break;
                }
            }
            while ((read = reader.read()) != -1) {
                char ch = (char) read;
                if (isNumber(ch)) {
                    res = res * 10 + (read - '0');
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (isNegative == true) {
            res = -1 * res;
        }
        return res;
    }

    /**
     * 判断字符是否空白
     *
     * @param ch
     *            字符
     * @return 判断结果
     */
    public static boolean isBlank(char ch) {
        if (ch == '\r' || ch == '\n' || ch == ' ') {
            return true;
        }
        return false;
    }

    /**
     * 判断字符是不是数字
     *
     * @param ch
     *            字符
     * @return 判断结果
     */
    public static boolean isNumber(char ch) {
        if (ch <= '9' && ch >= '0') {
            return true;
        }
        return false;
    }
    private static Reader reader = null;
    private static Writer writer = null;
}
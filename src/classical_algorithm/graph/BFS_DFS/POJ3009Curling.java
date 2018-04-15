package classical_algorithm.graph.BFS_DFS;
import static java.util.Arrays.*;

import java.awt.*;
import java.io.*;
import java.util.*;
/**
 * Created by jal on 2018/4/13 0013.
 */
// http://poj.org/problem?id=3009
public class POJ3009Curling {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;

    Scanner sc = new Scanner(System.in);
    private int w, h;
    private int [][]a;
    private int min;
    private final Point UP = new Point(0,-1);
    private final Point DOWN = new Point(0,1);
    private final Point LEFT = new Point(-1,0);
    private final Point RIGHT = new Point(1,0);
    private Point[] direction = {UP, DOWN, LEFT, RIGHT};
    void run() {
        while (sc.hasNext()){
            min = 99999;
            h = sc.nextInt();
            w = sc.nextInt();
            if ( w == 0 && h == 0 ){
                break;
            }
            a = new int[w][h];
            for (int i = 0; i < w; i++){
                for (int j = 0; j < h; j++){
                    a[i][j] = sc.nextInt();
                }
            }
            for(int i = 0; i < w; i ++){
                for(int j = 0; j < h; j++){
                    if(a[i][j] == 2){
                        dfs(i,j,0);
                    }
                }
            }
            if( min <= 10)
            System.out.println(min);
            else System.out.println(-1);
        }
    }

    private void dfs(int x, int y, int step) {
        if( step >= 10)return;
        for (int i = 0; i < 4; i++){
            boolean flagOver = false;
            boolean isBump = false;
            Point next = (Point) direction[i].clone();
            int tx = (int) (x + next.getX());
            int ty = (int) (y + next.getY());
            while (true){
                if (isOverBoundary(tx, ty)){
                    flagOver = true;
                    break;
                }
                if (a[tx][ty] == 1){
                    isBump = true;
                    break;
                }
                if (a[tx][ty] == 3){
                    if (min > ++step){
                        min = step;
                        debug("min",min,step);
                        return;
                    }

                }
                tx += next.getX();
                ty += next.getY();
            }
            if (flagOver){
                continue;
            }
            if (isBump){
                a[tx][ty] = 0;
                tx -= next.getX();
                ty -= next.getY();
                if (tx == x && ty == y){
                    a[(int) (tx+next.getX())][(int) (ty+next.getY())] = 1;
                    continue;
                }
                dfs(tx, ty, step + 1);
                a[(int) (tx+next.getX())][(int) (ty+next.getY())] = 1;
            }
        }
    }

    private boolean isOverBoundary(int x, int y) {
        if(x >= w || y >= h || x < 0 || y < 0)return true;
        return false;
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
        new POJ3009Curling().run();
    }

}

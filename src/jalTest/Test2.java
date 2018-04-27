package jalTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class Test2 {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner sc = new Scanner(System.in);

    void run() {
        //提交时需要注释debug函数
        // debug(1,2,3+4,new String("hello"),true,0.8f);
        // System.out.println(sc.nextInt()+sc.nextInt());
        out = new  double[6];
        dfs(0,0);
    }

    private void dfs(int step,int t) {
        if(step>=6){
            double sum = 0;
            for (int i = 0; i < 6 ; i ++){
                sum+=out[i];
            }
            if (Math.abs(sum - 0.41)<0.001){
                debug(out);
            }
            return;
        }
        for (int i = t; i <5;i++){
            out[step] = a[i];
            dfs(step+1,i);
        }
    }

    double []a = {0.01,0.05,0.1,0.25,0.5};
    double []out ;


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
        new Test2().run();
    }
}
package jalTest;

import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

public class Test1{
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner sc = new Scanner(System.in);

    void run() {
        //提交时需要注释debug函数
        // debug(1,2,3+4,new String("hello"),true,0.8f);
        // System.out.println(sc.nextInt()+sc.nextInt());
        for(int i = 1000; i < 2000;i++){
            int n = 2015 - i;
            int m = 2012 - i;
            if(f(m)==f(n)*3){
                debug(f(i));
            }
        }
    }

    private int f(int n) {
        int ret=0;
        while (n>0){
            ret+=n%10;
            n/=10;
        }
        return  ret;
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
        new Test1().run();
    }
}
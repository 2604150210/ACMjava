package nyist;

/**
 * Created by jal on 2018/4/13 0013.
 */


        import static java.util.Arrays.*;
        import java.io.*;
        import java.util.*;

public class 余数之和 {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner sc = new Scanner(System.in);

    void run() {
        for(int i = 1; i <= 101; i++){
           // if (prime(i))
           // debug(i,Integer.toBinaryString(i),f(i));

        }


    }

    private boolean prime(int n) {
        for(int i = 2; i *i <= n; i++){
            if(n % i == 0)return false;
        }
        return true;
    }

    private int f(int n) {
        int ret = 0;
        for(int j = 1; j <= n; j++){
            ret += n % j;
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
        new 余数之和().run();
    }
}

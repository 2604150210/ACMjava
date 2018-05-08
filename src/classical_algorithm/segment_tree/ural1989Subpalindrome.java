/*
http://acm.timus.ru/problem.aspx?num=1989
 */
package classical_algorithm.segment_tree;
import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

/**
 * Created by jal on 2018/4/27 0027.
 */
public class ural1989Subpalindrome {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner sc = new Scanner(System.in);

    void run() {

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
        new ural1989Subpalindrome().run();
    }
}

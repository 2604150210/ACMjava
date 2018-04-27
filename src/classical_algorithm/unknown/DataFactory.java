package classical_algorithm.unknown;

import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

public class DataFactory {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/in.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner sc = new Scanner(System.in);

    void run() {
       Random r = new Random();
       int n = r.nextInt(100)+1;
        System.out.println(n);
       for (int i = 1; i <= n; i++){
           for (int j = 1; j < n; j++){
               int x = r.nextInt(128);
               boolean f = r.nextBoolean();
               if (f){
                   System.out.print(x + " ");
               }
               else {
                   System.out.print("-" + x + " ");
               }
           }
           int x = r.nextInt(128);
           boolean f = r.nextBoolean();
           if (f){
               System.out.print(x);
           }
           else {
               System.out.print("-" + x);
           }
           System.out.println();
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
        new DataFactory().run();
    }
}
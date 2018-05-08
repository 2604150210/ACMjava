package jalTest;
import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class Test1{
        public static final String INPUT_FILE = "./bin/in.txt";
        public static final String OUTPUT_FILE = "./bin/output.txt";

        static boolean LOCAL = System.getSecurityManager() == null;
        static boolean TO_FILE = true;
        Scanner sc = new Scanner(System.in);

        void run() {
            Random r = new Random();
            int t = 1000000;
            System.out.println("1000000 1000000 1000000");
            for(int i = 1; i <= 1000000; i++) {
                int left = r.nextInt(t+1);
                int right = r.nextInt(t+1);
                if(left > right){
                    int x  = left; left = right; right = x;
                }
                int val = r.nextInt(100)+1;
                System.out.println(left + " " + right + " " + val);
            }
            for(int i = 1; i <= 1000000; i++) {
                int left = r.nextInt(t+1);
                int right = r.nextInt(t+1);
                if(left > right){
                    int x  = left; left = right; right = x;
                }
                System.out.println(left + " " + right);
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
            new Test1().run();
        }
    }

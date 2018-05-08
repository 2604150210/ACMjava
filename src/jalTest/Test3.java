package jalTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class Test3 {
        public static final String INPUT_FILE = "./bin/in.txt";
        public static final String OUTPUT_FILE = "./bin/output2.txt";

        static boolean LOCAL = System.getSecurityManager() == null;
        static boolean TO_FILE = true;
        Scanner sc = new Scanner(System.in);

        void run() {
            Random r = new Random();
            for(int i= 1; i <= 10; i++){
                int n = r.nextInt(101);
                System.out.println(n);
                for(int j = 1; j <= n; j++){
                    int a = r.nextInt(128);
                    boolean f = r.nextBoolean();
                    if (f)a = -a;
                    String str = "" + a;
                    for(int k = 2; k <= n; k++){
                         a = r.nextInt(128);
                        f = r.nextBoolean();
                        if (f)a = -a;
                        str += " " + a;
                    }
                    System.out.println(str);
                }
                //System.out.println("bound line ~");
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
            new Test3().run();
        }
    }

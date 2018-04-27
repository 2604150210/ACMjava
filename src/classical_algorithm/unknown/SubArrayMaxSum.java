package classical_algorithm.unknown;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

/**
 * Created by jal on 2018/4/24 0024.
 */
public class SubArrayMaxSum {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner scanner = new Scanner(System.in);

    private void run() {
        int []a = {-3,-2,-3,-4};
        int maxSum = getSubArrayMaxSum(a);
        debug(maxSum);
    }

    public int getSubArrayMaxSum(int[] a) {
        int cur = 0;
        int result = a[0];
        int i = 0;
        while(i < a.length){
            if(cur < 0)cur = 0;
            cur += a[i];
            result = Math.max(result, cur);
            i++;
        }
        return result;
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
        new SubArrayMaxSum().run();
    }

}

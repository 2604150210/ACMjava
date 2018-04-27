package classical_algorithm.unknown;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

/**
 * Created by jal on 2018/4/24 0024.
 */
public class SubMatrixMaxSum {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner scanner = new Scanner(System.in);

    private void run(){
//        int [][]a = {
//                {1, 2, -1, 4},
//                {2, -1, 4, 8},
//                {-1, 2, -3, 5},
//                {2, -3, 2, 4}
//        };
        int n = scanner.nextInt();
        int [][]a = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                a[i][j] = scanner.nextInt();
            }
        }
        int maxSum = getSubMatrixMaxSum(a);
      //  debug(maxSum);
        System.out.println(maxSum);
    }

    private int getSubMatrixMaxSum(int[][] a) {
        int result = Integer.MIN_VALUE;
        int []temp = new int[a[0].length];

        for (int i = 0; i < a.length; i++){
            Arrays.fill(temp,0);
            for (int j = i; j < a.length; j++){
                int cur = 0;
                for (int k = 0; k < a[0].length; k++){
                    temp[k] += a[j][k];
                    cur += temp[k];
                    if(cur < 0)cur = 0;
                    result = Math.max(result, cur);
                }
            }
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
        new SubMatrixMaxSum().run();
    }
}

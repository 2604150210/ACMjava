package newcoder.contest;

import java.util.Scanner;

/**
 * Created by jal on 2018/4/26 0026.
 */
public class B {

      static String str;
      static String S= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      static char cs[][];

    public static void main(String[] args) {

        cs=new char[6][6];
        for(int i=0;i<36;i++)
            cs[i/6][i%6]=S.charAt(i);
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        int [][]out;
        while (T-->0){
            str = scanner.nextLine();
            out = new int[6][6];
            for(int i = 0; i < 6; i++){
                for(int j  = 0; j < 6; j++){
                    
                }
            }
        }
    }

    private static int line(int c) {
        for(int i = 0;  i < 6; i++){

        }
        return 0;
    }
}

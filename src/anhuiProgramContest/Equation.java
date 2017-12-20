package anhuiProgramContest;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/8 0008.
 */
public class Equation {
    private static int a,b,c,p;;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            a= scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            p = scanner.nextInt();
            for(int i = 1;  i< 100; i++){
                if(y(i) % p == 0){
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    private static int y(int i) {
        return a*i*i+b*i+c;
    }
}

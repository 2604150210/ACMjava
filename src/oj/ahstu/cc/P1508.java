package oj.ahstu.cc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2017/11/9 0009.
 */
public class P1508 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int []a = new int[n];
            int []b = new int[m];
            for(int i = 0; i < n; i++){
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);
            for(int i = 0; i < m; i++){
                b[i] = scanner.nextInt();
            }
            Arrays.sort(b);
            int k = scanner.nextInt();
            int i;
            for(i = 0; i < b.length; i++){
                if(b[i] != a[i] ){
                    if(a[i] == k){
                        System.out.println("YES");
                    }
                    else {
                        System.out.println("NO");
                    }
                    break;
                }
            }
            if(i >= b.length){

                    if (a[i] == k) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }

            }
        }
    }
}
/*
*4 3
1 2 3 4
1 2 3
4
5 1
4 6 8 10 12
8
10
5 1
44 45 46 47 48
44
45
*/
package oj.ahstu.cc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2017/11/16 0016.
 */
public class P04 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str1 = scanner.nextLine();
            //if(str1.equals("!"))break;

            char []arr = str1.toCharArray();
            if(arr[0] >='a' && arr[0] <= 'z')arr[0] -= 32;
            for(int i = 1; i < arr.length; i++){
                if(arr[i] >= 'a' && arr[i] <= 'z' && arr[i-1] == ' '){
                    arr[i] -= 32;
                }
            }
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }
}

package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/11/7 0007.
 */
public class P1716 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for(int i = str.length(); i >= 1; i--){

            if(str.length() % i != 0)continue;
            int len = str.length() / i;
            String tmp = str.substring(0,len);
           //System.out.println("tmp:" + tmp);
            int flag = 0;
            for(int j = len; j <= str.length() - len; j += len){
             //System.out.println("str.substring(j,j+len):" + str.substring(j,j+len) + "str.substring(j,j+len).equals(tmp)" + str.substring(j,j+len).equals(tmp));

                if(str.substring(j,j+len).equals(tmp) == false){
                    flag = 1; // 0  1  2  3 4 5 6  7 8
                    break;
                }
            }
            if(flag == 0){
                System.out.println(i);
                break;
            }
        }

    }
}

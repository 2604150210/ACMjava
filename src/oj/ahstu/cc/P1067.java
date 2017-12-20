package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/11/11 0011.
 */
public class P1067 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = "";
        int yi = n / 100000000;
        int yi1 = yi / 10;
        int yi2 = yi % 10;
        if(yi1 == 1){
            str += "shi ";
        }else if (yi1 == 2){
            str += "er shi ";
        }
        switch (yi2){
            case 1 : str += "yi ";break;
            case 2 : str += "er ";break;
            case 3 : str += "san ";break;
            case 4 : str += "si ";break;
            case 5 : str += "wu ";break;
            case 6 : str += "liu ";break;
            case 7 : str += "qi ";break;
            case 8 : str += "ba ";break;
            case 9 : str += "jiu ";break;
        }
        if(!str.equals("")){
            str += "yi";
        }
        n %= 100000000;
        int wan = n / 10000;
        if(wan == 0){
            
        }
    }
}

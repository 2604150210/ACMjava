package jalTest;

import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class Test1{
    static int[]a;
    static class SegTree{
        int left,right,val;
    }
    static SegTree []tree;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long y = Long.MAX_VALUE;
        String str = String.valueOf(y);
        System.out.println(str.length());
        String s = "2856455463283736313999";
        System.out.println(s.length());
        System.out.println(y);
    }


}
/*
5 2
1 2 3 4 5
1 3
2 4
* */
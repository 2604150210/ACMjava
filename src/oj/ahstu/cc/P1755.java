package oj.ahstu.cc;

import com.intellij.icons.AllIcons;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by jal on 2017/11/8 0008.
 */
public class P1755 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();
        BigInteger c = a.multiply(b);
        System.out.println(c);
    }
}

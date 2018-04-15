package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/11/11 0011.
 */
public class P1606 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        //System.out.println("h:" + h + " m:" + m);
        String hour = "";
        switch (h) {
            case 0:
                hour = "zero";
                break;
            case 1:
                hour = "one";
                break;
            case 2:
                hour = "two";
                break;
            case 3:
                hour = "three";
                break;
            case 4:
                hour = "four";
                break;
            case 5:
                hour = "five";
                break;
            case 6:
                hour = "six";
                break;
            case 7:
                hour = "seven";
                break;
            case 8:
                hour = "eight";
                break;
            case 9:
                hour = "nine";
                break;
            case 10:
                hour = "ten";
                break;
            case 11:
                hour = "eleven";
                break;
            case 12:
                hour = "twelve";
                break;
            case 13:
                hour = "thirteen";
                break;
            case 14:
                hour = "fourteen";
                break;
            case 15:
                hour = "fifteen";
                break;
            case 16:
                hour = "sixteen";
                break;
            case 17:
                hour = "seventeen";
                break;
            case 18:
                hour = "eighteen";
                break;
            case 19:
                hour = "nineteen";
                break;
            case 20:
                hour = "twenty";
                break;
            case 21:
                hour = "twenty one";
                break;
            case 22:
                hour = "twenty two";
                break;
            case 23:
                hour = "twenty three";
                break;
            case 24:
                hour = "twenty four";
                break;
        }
        if (m == 0) {
            hour += " o'clock";
            System.out.println(hour);
        } else {
            String minite = "";
            switch (m) {
                case 0:
                    minite = "zero";
                    break;
                case 1:
                    minite = "one";
                    break;
                case 2:
                    minite = "two";
                    break;
                case 3:
                    minite = "three";
                    break;
                case 4:
                    minite = "four";
                    break;
                case 5:
                    minite = "five";
                    break;
                case 6:
                    minite = "six";
                    break;
                case 7:
                    minite = "seven";
                    break;
                case 8:
                    minite = "eight";
                    break;
                case 9:
                    minite = "nine";
                    break;
                case 10:
                    minite = "ten";
                    break;
                case 11:
                    minite = "eleven";
                    break;
                case 12:
                    minite = "twelve";
                    break;
                case 13:
                    minite = "thirteen";
                    break;
                case 14:
                    minite = "fourteen";
                    break;
                case 15:
                    minite = "fifteen";
                    break;
                case 16:
                    minite = "sixteen";
                    break;
                case 17:
                    minite = "seventeen";
                    break;
                case 18:
                    minite = "eighteen";
                    break;
                case 19:
                    minite = "nineteen";
                    break;
                case 20:
                    minite = "twenty";
                    break;
                case 30:
                    minite = "thirty";
                    break;
                case 40:
                    minite = "forty";
                    break;
                case 50:
                    minite = "fifty";
                    break;
            }
            int m1 = m / 10;
            int m2 = m % 10;
            if (m1 >= 2 && m2 >= 1) {
                if (m1 == 2) {
                    minite = "twenty ";

                } else if (m1 == 3) {
                    minite = "thirty ";
                } else if (m1 == 4) {
                    minite = "forty ";
                } else if (m1 == 5) {
                    minite = "fifty ";
                }
                switch (m2) {
                    case 1:
                        minite += "one";
                        break;
                    case 2:
                        minite += "two";
                        break;
                    case 3:
                        minite += "three";
                        break;
                    case 4:
                        minite += "four";
                        break;
                    case 5:
                        minite += "five";
                        break;
                    case 6:
                        minite += "six";
                        break;
                    case 7:
                        minite += "seven";
                        break;
                    case 8:
                        minite += "eight";
                        break;
                    case 9:
                        minite += "nine";
                        break;
                }
            }
            hour += " " + minite;
            System.out.println(hour);
        }
    }
}

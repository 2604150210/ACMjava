package oj.ahstu.cc;


import java.util.Scanner;

/**
 * Created by jal on 2017/11/29 0029.
 */
public class DemonAB {
    private static int carry = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            String A = scanner.next();
            String B = scanner.next();
            int indexA = A.indexOf('.');
            int indexB = B.indexOf('.');
            /***************************************************************************/
            if (indexA == -1 && indexB == -1) {
                String sum = add(A, B);
                System.out.println(sum);

            }
            /***************************************************************************/

            else if ((indexA == -1 && indexB != -1) || (indexA != -1 && indexB == -1)) {
                int index = indexB;
                if (indexB == -1) {
                    String tmp = A;
                    A = B;
                    B = tmp;
                    index = indexA;
                }
                String decimal = B.substring(index, B.length());
                B = B.substring(0, index);
                String sum = add(A, B);
                sum += decimal;
                System.out.println(sum);
            }
            /***************************************************************************/

            else { // indexA != -1 && indexB != -1
                String decimalA = A.substring(indexA + 1, A.length());
                String decimalB = B.substring(indexB + 1, B.length());
                A = A.substring(0, indexA);
                B = B.substring(0, indexB);
                String sum = add(A, B);
                String sum2 = addDecimal(decimalA, decimalB);
                if (carry != 0) {
                    sum = add(sum, "b");
                }
                sum += ".";
                sum += sum2;
                sum = trim2(sum);
                System.out.println(sum);
            }
        }
    }

    private static String trim2(String value) {
        int len = value.length();
        int st = 0;
        char[] val = value.toCharArray();    /* avoid getfield opcode */

       /*  while ((st < len) && (val[st] <= 'a')) {
            st++;
        }*/
        while ((st < len) && (val[len - 1] <= 'a')) {
            len--;
        }
        if (val[len - 1] == '.') {
            len--;
        }
        return ((st > 0) || (len < value.length())) ? value.substring(st, len) : value;

    }

    private static String addDecimal(String A, String B) {
        String sum = null;
        int len = Math.min(A.length(), B.length());
        int maxlen = Math.max(A.length(), B.length());
        char[] longStr = A.length() >= B.length() ? A.toCharArray() : B.toCharArray();
        char[] shortStr = A.length() < B.length() ? A.toCharArray() : B.toCharArray();
        char[] arrC = new char[maxlen];
        carry = 0;
        for (int i = maxlen - 1; i >= 0; i--) {
            if (i >= len) {
                arrC[i] = longStr[i];
            } else {
                int tmp = carry + longStr[i] - 'a' + shortStr[i] - 'a';
                carry = tmp / 26;
                tmp %= 26;
                arrC[i] = (char) (tmp + 'a');

            }
        }
        sum = String.valueOf(arrC);
        return sum;
    }

    private static String add(String A, String B) {
        A = new StringBuffer(A).reverse().toString();
        char[] arrA = A.toCharArray();
        B = new StringBuffer(B).reverse().toString();
        char[] arrB = B.toCharArray();
        char[] arrC = new char[Math.max(arrA.length, arrB.length) + 1];
        int c = 0;
        int i;
        for (i = 0; i < Math.min(arrA.length, arrB.length); i++) {
            int temp = arrA[i] - 'a' + arrB[i] - 'a' + c;
            c = temp / 26;
            temp %= 26;
            arrC[i] = (char) (temp + 'a');
        }
        char[] maxStr = arrA.length > arrB.length ? arrA : arrB;
        for (; i < Math.max(arrA.length, arrB.length); i++) {
            int temp = maxStr[i] - 'a' + c;
            c = temp / 26;
            temp %= 26;
            arrC[i] = (char) (temp + 'a');
        }
        arrC[i] = (char) (c + 'a');
        String C = String.valueOf(arrC);
        C = new StringBuffer(C).reverse().toString();
        C = t(C);
        return C;
    }

    private static String t(String value) {
        int len = value.length();
        int st = 0;
        char[] val = value.toCharArray();    /* avoid getfield opcode */

        while ((st < len) && (val[st] <= 'a')) {
            st++;
        }
       /* while ((st < len) && (val[len - 1] <= 'a')) {
            len--;
        }*/
        return ((st > 0) || (len < value.length())) ? value.substring(st, len) : value;
    }
}

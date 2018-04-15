package oj.ahstu.cc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2017/12/6 0006.
 */

/**
 * Author:Cathy
 */
public class FFT {
    private static Complex[] arrA, first, second;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numstr1 = scanner.next();
        String numstr2 = scanner.next();
        int len = Math.max(numstr1.length(), numstr2.length());
        int maxn = 0;
        double temp = log2(len);
        double floortemp = Math.floor(temp);
        if (floortemp == temp) {
            maxn = len;
        } else {
            maxn = (int) Math.pow(2, floortemp + 1);
        }
        Complex[] arra = createArray(maxn);
        Complex[] arrb = createArray(maxn);
        Complex[] arrc = createArray(maxn);
        arrA = createArray(maxn);
        int[] arrB = new int[maxn];
        int[] arrC = new int[maxn];

        char[] a = numstr1.toCharArray();
        int j = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            arra[j++] = new Complex(a[i] - '0');
        }
        j = 0;
        char[] b = numstr2.toCharArray();
        for (int i = b.length - 1; i >= 0; i--) {
            arrb[j++] = new Complex(a[i] - '0');
        }
        invert(arra);
        arrA = Arrays.copyOf(arra, arra.length);



        /*   recursion of  DFT       */
        int left = 0, right = arrA.length, interval = 1;
        int lens = arrA.length;
        System.out.println(Arrays.toString(DIT_FFT(arrA, 0, arrA.length - 1)));

    }

    private static Complex[] createArray(int maxn) {
        Complex[] result = new Complex[maxn];
        for (int i = 0; i < maxn; i++)
            result[i] = new Complex(0, 0);
        return result;
    }

    //[start,end]
    //Complex[] result= DIFFT(arr,0,arrA.length-1);
    private static Complex[] DIT_FFT(Complex[] arr, int start, int end) {
        if (start == end) {
            Complex ret[] = new Complex[1];
            ret[0] = new Complex(0, 0);
            return ret;
        }
        System.out.println(String.format("[%d %d]", start, end));
        int mid = (end + start) / 2;
        Complex[] resultLeft = DIT_FFT(arr, start, mid);
        Complex[] resultRight = DIT_FFT(arr, mid + 1, end);

        Complex result[] = new Complex[end - start + 1];
        // Arrays.fill(result,start,mid,resultLeft);
        for (int i = 0; i < resultLeft.length; i++)
            result[i] = resultLeft[i];
        // Arrays.fill(result,mid+1,end,resultRight);
        for (int i = resultLeft.length; i < result.length; i++)
            result[i] = resultRight[i - resultLeft.length];
        return result;
    }

    private static Complex w(int n, int i) {
        Complex ans = new Complex(0, -2 * Math.PI / n * i);
        return ans.exp();
    }

    private static void invert(Complex[] arra) {
        for (int i = 0; i < arra.length / 2; i++) {
            int j = Integer.valueOf(new StringBuffer(Integer.toBinaryString(i)).reverse().toString(), 2);
            swap(arra, i, j);
        }
    }

    private static void swap(Complex[] arra, int i, int j) {
        Complex tmp = arra[i];
        arra[i] = arra[j];
        arra[j] = tmp;
    }

    public static double log2(int n) {
        return Math.log(n) / Math.log(2);
    }
}

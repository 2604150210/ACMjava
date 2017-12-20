package oj.ahstu.cc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by jal on 2017/12/6 0006.
 */
public class DIT_FFT {
    private static int maxn;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numstr1 = scanner.next();
        String numstr2 = scanner.next();
        int len =numstr1.length()+numstr2.length();
        maxn = 0;
        double temp = log2(len);
        double floortemp = Math.floor(temp);
        if(floortemp == temp){
            maxn = len;
        }else {
            maxn = (int)Math.pow(2,floortemp+1);
        }
        Complex []arra = createArray(maxn);
        Complex []arrb =createArray(maxn);
        Complex []arrc =createArray(maxn);
        Complex []arrA = createArray(maxn);
        Complex []arrB = createArray(maxn);
        Complex []arrC = createArray(maxn);

        char []a = numstr1.toCharArray();
        int j = 0;
        for(int i = a.length - 1; i >= 0; i--){
            arra[j++] = new Complex(a[i] - '0');
        }
        j = 0;
        char []b = numstr2.toCharArray();
        for(int i = b.length - 1; i >= 0; i--){
            arrb[j++] = new Complex(b[i] - '0');
        }
        //System.out.println(Arrays.toString(arra));

        //invert(arra);



        arrA = fft(arra);
        System.out.println(Arrays.toString(arrA));
        //invert(arrb);

        arrB = fft(arrb);
        //System.out.println(Arrays.toString(arrB));
        for(int i = 0; i < arrC.length; i++){
            arrC[i] = arrA[i].times(arrB[i]);
        }
        //System.out.println(Arrays.toString(arrC));
        arrc = ifft(arrC);
        Vector<Integer> vector = new Vector<>();
        vector = toIntOfString(arrc);
        String str = "";
        char vectorCHar[] = new char[vector.size()];
        for(int i = 0; i < vectorCHar.length; i++){
            vectorCHar[i] = (char)(vector.get(i) + '0');
        }
        str =String.valueOf(vectorCHar);
        str = new StringBuffer(str).reverse().toString();
        //System.out.println("str:"+str);
        str = trim(str);
        System.out.println(str);

    }
    private static String trim(String value) {

        int len = value.length();
        int st = 0;
        char[] val = value.toCharArray();    /* avoid getfield opcode */

        while ((st < len) && (val[st] <= '0')) {
            st++;
        }
//            while ((st < len) && (val[len - 1] <= ' ')) {
//                len--;
//            }
        return value.substring(st, len);

    }
    private static Vector<Integer> toIntOfString(Complex[] arrc) {
        Vector<Integer> result = new Vector<>();
        int n = arrc.length;
        int arrayTemp [] = new int[n+1];
        for(int i = 0; i < arrc.length; i++){
            arrayTemp[i] = (int)arrc[i].re();
        }
        int i;
        arrayTemp[n] = 0;
        for(i = 0; i < n; i++){
            result.add(arrayTemp[i]%10);
            arrayTemp[i+1] += arrayTemp[i] / 10;
        }
        int t = arrayTemp[n];
        while(t > 0){
            result.add(t % 10);
            t/= 10;
        }
        return result;
    }

    private static Complex[] ifft(Complex[] arrC) {
        int n = arrC.length;
        Complex arrayResult[] = new Complex[n];
        for(int i = 0; i < arrC.length; i++){
            arrC[i] = arrC[i].conjugate();
        }
        arrayResult= fft(arrC);
        for(int i = 0; i < arrayResult.length; i++){
            arrayResult[i] = arrayResult[i].conjugate().divides(new Complex(n));
        }
        return arrayResult;
    }

    private static Complex[] fft(Complex[] arrA) {
        int N = arrA.length;
        if(N == 1){
            return arrA;
        }
        Complex [] arrayEven = new Complex[N/2];
        Complex [] arrayOdd = new Complex[N/2];
        for(int i = 0; i < arrayEven.length; i++){
            arrayEven[i] = arrA[2*i];
            arrayOdd[i] = arrA[2*i+1];
        }
        arrayEven = fft(arrayEven);
        arrayOdd = fft(arrayOdd);
        Complex[]arrayResult = new Complex[N];
        for(int i = 0; i < N/2; i++){
            Complex W = new Complex(0,-2*Math.PI*i/N).exp();
            arrayResult[i] = arrayEven[i].plus(arrayOdd[i].times(W));
            arrayResult[i+N/2] = arrayEven[i].minus(arrayOdd[i].times(W));
        }
        return arrayResult;
    }

    private static  void bit_reverse_swap(Complex [] a) {
        int n = a.length;
        for (int i = 1, j = n >> 1, k; i < n - 1; ++i) {
            if (i < j) swap(a,i,j);
            // tricky
            for (k = n >> 1; j >= k; j -= k, k >>= 1)  // inspect the highest "1"
                ;
            j += k;
        }
    }

    private static void invert(Complex[] arra) {
        int n = (int)log2(maxn);
        for(int i = 0; i < arra.length; i++){
            String temp = Integer.toBinaryString(i);
            temp = new StringBuffer(temp).reverse().toString();
            int len = n - temp.length();
            char [] zeros = new char[len];
            Arrays.fill(zeros,'0');
            temp+=String.valueOf(zeros);

            int j = Integer.valueOf(temp,2);
            System.out.println("i:" + i +"j:" + j);
            if(j>i){
                swap(arra,i,j);
            }
        }
    }

    private static void swap(Complex[] arra, int i, int j) {
        Complex tmp = arra[i];
        arra[i] = arra[j];
        arra[j] = tmp;
    }
    private static Complex[] createArray(int maxn) {
        Complex[] result =new Complex[maxn];
        for(int i=0;i<maxn;i++)
            result[i]=new Complex(0,0);
        return result;
    }

    public static double log2(int n){
        return Math.log(n)/Math.log(2);
    }
}

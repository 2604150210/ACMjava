package classical_algorithm.sort;

import java.io.*;
import java.util.Arrays;

/**
 * Created by jal on 2018/5/8 0008.
 */
public class NYIST117MergeSort {
    static long C = 0;
    static int[] b;
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int T = (int) in.nval;
        while (T-->0){
            in.nextToken();
            int n = (int)in.nval;
            int []a = new int[n+1];
            b = new int[n+1];
            for (int i = 1; i <= n; i++){
                in.nextToken();
                a[i] = (int) in.nval;
            }
            C = 0;
            //out.print(Arrays.toString(a));
            //out.flush();
            mergeSort(a,1,n);
            //out.print(Arrays.toString(a));
            out.print(String.format("%d\n",C));
            out.flush();
        }
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (right == left){
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        int i = left, j = mid + 1,k = 0;
        while (i <= mid && j <= right){
            if (a[i] <= a[j]){
                b[k++] = a[i++];
            }
            else{
                b[k++] = a[j++];
                C += mid - i+1;
            }
        }
        if (i > mid){
            while (j <= right){
                b[k++] = a[j++];
            }
        }
        else if (j > right){
            while (i <= mid){
                b[k++] = a[i++];
            }
        }
        k = 0;
        for (int r = left; r <= right; r++){
            a[r] = b[k++];
        }
    }
}

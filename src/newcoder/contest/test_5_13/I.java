package newcoder.contest.test_5_13;

import java.awt.geom.Line2D;
import java.util.*;

/**
 * Created by jal on 2018/5/13 0013.
 */
public class I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int []a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = (scanner.nextInt());
            }
            int sum = 0;
            int left = 0,right = n-1;
            while (right > left){
                int max = getMax(a,left, right);
                sum += right - max;
                int cnt = 0;
                while(max > left && a[max-1] == a[max]){
                    max--;
                    cnt++;
                }
                sum += cnt;
                right = max-1;
            }
            System.out.println(sum);
        }
    }

    private static int getMax(int[]a, int left, int right) {
        int maxResult = a[left];
        int index = left;
        for (int i = left+1; i <= right; i++){
            if (a[i] >= maxResult){
                index = i;
                maxResult = a[i];
            }
        }
        return index;
    }

}

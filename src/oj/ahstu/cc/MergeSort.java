package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/5 0005.
 */
public class MergeSort {
    private static int sum = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int left = 0,right = n;
        mergeSort(arr, left,right);
    }

    private static void mergeSort(int[] arr, int left, int right) {

    }
}

package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/11/24 0024.
 */
public class BinarySort {
    public static int n;
    public static int []a;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            n = scanner.nextInt();
            a = new int[n+1];
            for(int i = 1; i <= n; i++){
                a[i] = scanner.nextInt();
            }
            
            BinarySort root = new BinarySort();
            root = createBinary(1);

            preOrder(root);
            System.out.println();
            inOrder(root);
            System.out.println();
            formOrder(root);
            System.out.println();
        }
    }

    private static void formOrder(BinarySort root) {
        if(root != null){
            formOrder(root.left);
            formOrder(root.right);
            System.out.print(root.value + " ");
        }
    }

    private static void inOrder(BinarySort root) {
        if (root!=null){
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }

    private static void preOrder(BinarySort root) {
        if(root!=null){
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

    }

    int value;
    BinarySort left;
    BinarySort right;
    private static BinarySort createBinary(int index) {
        try {
            BinarySort root = new BinarySort();
            root.value = a[index];
            root.left = createBinary(index * 2);
            root.right = createBinary(index * 2 + 1);
            return root;
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
}

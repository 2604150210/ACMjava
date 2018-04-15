package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/11/13 0013.
 */
public class P1768 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(scanner.next(), scanner.nextDouble(), scanner.nextInt());
        }
        Double s = 0.0;
        for (int i = 0; i < n; i++) {
            s += arr[i].price * arr[i].number;
        }
        System.out.printf("%.6f\n", s);
    }

    private static class Node {
        String name;
        Double price;
        int number;

        public Node(String name, Double price, int number) {
            this.name = name;
            this.price = price;
            this.number = number;
        }
    }
}
/*

 4
 book 12.5 3
 pen 2.5 10
 computer 3200 1
 flower 47 5
* */
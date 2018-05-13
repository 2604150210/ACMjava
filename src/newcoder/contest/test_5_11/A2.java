package newcoder.contest.test_5_11;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jal on 2018/5/11 0011.
 */
public class A2 {
    static class Node implements Comparable<Node>{
        int maxPeople;
        int price;

        public Node(int maxPeople, int price) {
            this.maxPeople = maxPeople;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            if (this.price == o.price){
                return o.maxPeople - this.maxPeople;
            }
            else
            return this.price - o.price;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int []a = new int[n+1];
            LinkedList<Node> list = new LinkedList<>();
            for (int i = 1; i <= n; i++){

                a[i] = scanner.nextInt();
            }
            for (int i = 1; i <= m; i++){
                int maxPeop = scanner.nextInt();
                int pri = scanner.nextInt();
                list.add(new Node(maxPeop, pri));
            }
           Collections.sort(list);
            Arrays.sort(a);
            int cnt = n;
            int sum = 0;
            while (cnt >= 1){
                int index = binaryFind(list, a[cnt]);
                if (index == -1){
                    sum = -1;
                    break;
                }
                cnt --;
                sum += list.get(index).price;
               list.remove(index);
            }
            System.out.print(sum);
        }
    }

    private static int binaryFind(LinkedList<Node> list, int val) {

       int index = -1;
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).maxPeople >= val){
                index = i;
                break;
            }
        }
        return index;
    }
}

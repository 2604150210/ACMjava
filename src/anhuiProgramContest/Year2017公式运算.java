package anhuiProgramContest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jal on 2018/5/11 0011.
 */
public class Year2017公式运算 {
    static class Node{
        String operator;
        int num;

        public Node(String operator, int num) {
            this.operator = operator;
            this.num = num;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++){
            System.out.println(String.format("Case %d:\n",t));

            LinkedList<Node>list = new LinkedList<>();
            int n = scanner.nextInt();
            for (int i = 1; i <= n; i++){
                String str = scanner.next();
                if (str.equals("query")){
                    Long sum = 1L;
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()){
                        //if (iterator.next().)
                    }
                }
                else if (str.equals("add")){
                    String op = scanner.next();
                    int val = scanner.nextInt();
                    list.add(new Node(op,val));
                }
                else if (str.equals("delete")){
                    list.remove(2);
                }
                else if (str.equals("modify")){
                    int index = scanner.nextInt();
                    String op = scanner.next();
                    int val = scanner.nextInt();
                    list.set(index-1, new Node(op,val));
                }
            }
        }
    }
}

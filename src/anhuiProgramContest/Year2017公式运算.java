package anhuiProgramContest;

import java.util.Arrays;
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
        boolean isExit;
        public Node(String operator, int num,boolean isExit) {
            this.operator = operator;
            this.num = num;
            this.isExit = isExit;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++){
            System.out.println(String.format("Case %d:",t));
            LinkedList<Node>list = new LinkedList<>();
            int n = scanner.nextInt();
            for (int i = 1; i <= n; i++){
                String str = scanner.next();
                if (str.equals("query")){
                    String expression = "1";
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()){
                        Node node = (Node) iterator.next();
                        if (node.isExit)
                        expression += " " + node.operator + " " + node.num;
                    }
                    String[]e = expression.split(" ");
                   LinkedList<String >listStr = new LinkedList<String>();
                    for (int k = 0; k < e.length; k++)listStr.add(e[k]);
                    for (int j = 0; j < listStr.size(); j++){
                        if (listStr.get(j).equals("*")){
                            int left = j-1;
                            int right = j+1;
                            while(listStr.get(left).equals(""))left--;
                            while(listStr.get(right).equals(""))right++;
                            long mu = 1L * Integer.parseInt(listStr.get(left))*Integer.parseInt(listStr.get(right))%100000007;
                            listStr.set(j,Long.toString(mu));
                            listStr.set(left,"");
                            listStr.set(right,"");
                        }
                    }
                    long sum = 0;
                    for (int j = 0; j < listStr.size(); j++){
                        if (listStr.get(j).equals("") || listStr.get(j).equals("+"))
                            continue;
                        try {
                            int r = Integer.parseInt(listStr.get(j));
                            sum =( sum + r ) % 100000007;
                        }catch (NumberFormatException ne){
                            ne.printStackTrace();
                        }
                    }
                    System.out.println(sum);
                }
                else if (str.equals("add")){
                    String op = scanner.next();
                    int val = scanner.nextInt();
                    list.add(new Node(op,val,true));
                }
                else if (str.equals("delete")){
                    int index = scanner.nextInt();
                    Node q = list.get(index-2);
                    Node temp = new Node(q.operator,q.num,false);
                    list.set(index-2,temp);
                }
                else if (str.equals("modify")){
                    int index = scanner.nextInt();
                    String op = scanner.next();
                    int val = scanner.nextInt();
                    list.set(index-2, new Node(op,val,true));
                }
            }
        }
    }
}

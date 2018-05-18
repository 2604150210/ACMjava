package newcoder.contest.test_5_13;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jal on 2018/5/13 0013.
 */
public class J33 {
    static class Node implements Comparable<Node>{

        public boolean equals(Node obj) {
            return this.x == obj.x && this.y == obj.y;
        }

        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(){}


        @Override
        public String toString(){
            return String.format("%d/%d",x,y);
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.x*1.0/this.y, o.x*1.0/o.y);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Node> listF = new LinkedList<>();

        listF.add(new Node(0,1));
        listF.add(new Node(1,1));
        for(int i=0;i<3;i++){
           // Node node=new

        }

    }

    private static int gcd(int x, int y) {
        if(x < y){
            int t = x;x = y; y=t;
        }
        return x % y == 0 ? y : gcd(y, x%y);
    }
}

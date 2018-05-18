package newcoder.contest.test_5_13;

import java.util.*;

/**
 * Created by jal on 2018/5/13 0013.
 */
public class J {
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
        LinkedList<Integer> len = new LinkedList<>();
        listF.add(new Node(0,1));
        listF.add(new Node(1,1));
        len.add(listF.size());
        for (int j = 1; j <= 50; j++) {
            int l = len.get(len.size()-1);
            for (int i = 0; i < l - 1; i++) {
                Node temp;
                Node first = listF.get(i);
                Node second = listF.get(i + 1);
                int x = first.x + second.x;
                int y = first.y + second.y;
                int r = gcd(x, y);
                x /= r;
                y /= r;
                temp = new Node(x, y);
                if (listF.contains(temp))continue;
                if (y > j+1 || x > j + 1) continue;
                listF.add(temp);

            }
            Collections.sort(listF);
            System.out.println(listF);
            len.add(listF.size());
        }
        for (int  i = 1; i < len.size(); i++){
            System.out.println(i + " --> " + (len.get(i)));
        }

//        int T = scanner.nextInt();
//        while (T-->0){
//            int n = scanner.nextInt();
//            System.out.println(len.get(n-1));
//        }
    }

    private static int gcd(int x, int y) {
        if(x < y){
            int t = x;x = y; y=t;
        }
        return x % y == 0 ? y : gcd(y, x%y);
    }
}

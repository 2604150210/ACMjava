package newcoder.contest;

import java.util.*;

import static java.util.Arrays.deepToString;

/**
 * Created by jal on 2018/4/26 0026.
 */
public class E {
    static int n,m;
    static class Node implements Comparable<Node>{
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Node o) {

            return o.y - this.y;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-->0){
            n = scanner.nextInt();
            m = scanner.nextInt();
            Vector<Node>vector = new Vector<>();
            for (int i = 0; i < n; i++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                vector.add(new Node(x,y));
            }
            //System.out.println(vector);
            for(int i = 0; i < m; i++){
                int money = scanner.nextInt();
                PriorityQueue<Node> hashSet = new PriorityQueue<>();
                for (int j = 0; j <vector.size(); j++){
                    if(vector.get(j).x <= money){
                        hashSet.add(vector.get(j));
                    }
                }
                //System.out.println(hashSet);
                System.out.println(hashSet.peek().y);
            }
        }
    }
}
/*

1
3 3
1 100
10 1000
1000000000 1001
9
10
1000000000
* */
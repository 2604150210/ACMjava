package newcoder.contest.test_5_11;

import java.util.Scanner;

/**
 * Created by jal on 2018/5/11 0011.
 */
public class E {
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static class Node {
        Node(int x, int y)

        {
            int g = gcd(x, y);
            x /= g;
            y /= g;
            this.x = x;
            this.y = y;
        }

        int x, y;

        double getSlope() {
            return x * 1.0 /y;
        }

        @Override
        public String toString() {
            return String.format("%d %d",x,y);
        }
    }

    static double difAngle(Node a, Node b) {

        return Math.abs(a.getSlope() - b.getSlope());
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int x=cin.nextInt();
        int y=cin.nextInt();
        Node p = new Node(x,y);
        Node q = new Node(cin.nextInt(), cin.nextInt());
        double min = difAngle(p, q);
        Node best = q;/**/
        for (int i = 0; i < n - 1; i++) {
            Node r = new Node(cin.nextInt(), cin.nextInt());
            System.out.println(r+"****"+difAngle(p, r));
            if (difAngle(p, r) < min) {
                best = r;
                min = difAngle(p, r);
            }
        }
        System.out.println(best.x + "/" + best.y);

        cin.close();
    }
}
/*
 6 15698 17433
 112412868 636515040
 122123982 526131695
  58758943 343718480
  447544052 640491230
  162809501 315494932
  870543506 895723090
 */

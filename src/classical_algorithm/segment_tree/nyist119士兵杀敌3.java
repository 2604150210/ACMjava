package classical_algorithm.segment_tree;

import java.io.*;

/**
 * Created by jal on 2018/5/2 0002.
 */
public class nyist119士兵杀敌3 {
    static int n,m;
    static int[] a;
    static class SegTree{
        int left,right,max,min;
    };
    static SegTree[]tree;
    static int MAX = 0,MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        // 这句是io流包装，记住就好
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        //StreamTokenizer.TT_EOF这个是个参数，就是EOF
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            a = new int[n+1];
            tree = new SegTree[4 * n];
            for (int i = 0; i < 4*n; i++){
                tree[i] = new SegTree();
            }
            for(int i = 1; i <= n; i++){
                in.nextToken();
                a[i] = (int) in.nval;
            }
            build(1, 1, n);
            for (int i = 1; i <= m; i++){
                in.nextToken();
                int x = (int) in.nval;
                in.nextToken();
                int y = (int) in.nval;
                MAX = 0;
                MIN = Integer.MAX_VALUE;
                query(1,x,y);

                out.print(String.format("%d\n",MAX-MIN));
                out.flush();
            }
        }
    }

    private static void build(int root, int left, int right) {
        tree[root].left = left;
        tree[root].right = right;
        if (left == right){
            tree[root].max = tree[root].min = a[left];
            return;
        }
        int mid = (left + right) >> 1;
        build(root << 1, left, mid);
        build(root << 1 | 1, mid + 1, right);
        tree[root].max = Math.max(tree[root << 1].max , tree[root <<1|1].max);
        tree[root].min = Math.min(tree[root << 1].min , tree[root <<1|1].min);
    }

    private static void query(int root,int left, int right){
        if (left <= tree[root].left && tree[root].right <= right){
            MAX = Math.max(MAX, tree[root].max);
            MIN = Math.min(MIN, tree[root].min);
            return;
        }
        int mid = (tree[root].left + tree[root].right) >> 1;
        if (mid >= left){
            query(root << 1, left, right);
        }
        if (mid < right){
            query(root << 1 |1, left, right);
        }
    }

}

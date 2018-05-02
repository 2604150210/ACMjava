package classical_algorithm.segment_tree;

import java.io.*;
import java.util.Scanner;

/**
 * Created by jal on 2018/5/2 0002.
 */
public class nyist116士兵杀敌2 {
    static int n,m;
    static int[] a;
    static class SegTree{
        int left,right,val,add;
    };
    static SegTree[]tree;
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
                String str = in.sval;
                in.nextToken();
                int x = (int) in.nval;
                in.nextToken();
                int y = (int) in.nval;
                if (str.equals("QUERY")){
                    out.println(query(1,x,y));
                    out.flush();
                }
                if (str.equals("ADD")){
                    add(1,x,y);
                }
            }
        }
    }

    private static void build(int root, int left, int right) {
        tree[root].left = left;
        tree[root].right = right;
        if (left == right){
            tree[root].val = a[left];
            return;
        }
        int mid = (left + right) >> 1;
        build(root << 1, left, mid);
        build(root << 1 | 1, mid + 1, right);
        tree[root].val = tree[root << 1].val + tree[root <<1|1].val;
    }

    private static int query(int root,int left, int right){
        if (left <= tree[root].left && tree[root].right <= right){
            return tree[root].val;
        }
        int mid = (tree[root].left + tree[root].right) >> 1;
        if (right <= mid){
            return query(root << 1, left, right);
        }
        if (left > mid){
            return query(root << 1 | 1, left, right);
        }
        return query(root << 1, left, mid) + query(root << 1 | 1, mid + 1, right);
    }
    private static void add(int root, int index, int val){
        if (tree[root].left == tree[root].right){
            tree[root].val += val;
            return;
        }
        int mid = (tree[root].left + tree[root].right) >>1;
        if (index <= mid){
            add(root <<1, index, val);
        }
        else add(root <<1|1, index, val);
        tree[root].val = tree[root<<1].val + tree[root<<1|1].val;
    }
}

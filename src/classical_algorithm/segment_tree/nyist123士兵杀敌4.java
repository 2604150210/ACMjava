package classical_algorithm.segment_tree;

import java.io.*;
import java.util.Arrays;

/**
 * Created by jal on 2018/5/2 0002.
 */
public class nyist123士兵杀敌4 {
    static int t,m;
    static int[] a;
    static class SegTree{
        int left,right,val,add;

        @Override
        public String toString() {
            return "SegTree{" +
                    "val=" + val +
                    '}';
        }
    };
    static SegTree[]tree;
    public static void main(String[] args) throws IOException{
        // 这句是io流包装，记住就好
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        //StreamTokenizer.TT_EOF这个是个参数，就是EOF
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            t = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            a = new int[m+1];
            Arrays.fill(a, 0);
            tree = new SegTree[m << 2];
            for (int i = 0; i < 4*m; i++){
                tree[i] = new SegTree();
            }
            build(1, 1, m);
            for (int i = 1; i <= t; i++){
                in.nextToken();
                String str = in.sval;
                if (str.equals("QUERY")){
                    in.nextToken();
                    int x = (int) in.nval;
                    out.print(String.format("%d\n",query(1,x)));
                    out.flush();
                }
                if (str.equals("ADD")){
                    in.nextToken();
                    int left = (int) in.nval;
                    in.nextToken();
                    int right = (int) in.nval;
                    in.nextToken();
                    int val = (int) in.nval;
                    update(1,left,right,val);
              //      System.out.println(Arrays.toString(tree));
                }
            }
        }
    }

    /*
    建树
     */
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
        pushUp(root);
    }

    /*
    上推
     */
    private static void pushUp(int root) {
        tree[root].val = tree[root << 1].val + tree[root <<1|1].val;
    }

    /*
    单点查询
     */
    private static int query(int root,int index){
        if (tree[root].left == tree[root].right){
            return tree[root].val;
        }
        pushDown(root);
        int mid = (tree[root].left + tree[root].right) >> 1;
        if (index <= mid){
            return query(root << 1, index);
        }else return query(root << 1 |1, index);
    }

    /*
    区间查询
     */
    private static int query(int root, int left, int right){
        if (left <= tree[root].left && tree[root].right >= right){
            return tree[root].val;
        }
        pushDown(root);
        int mid = (tree[root].left + tree[root].right) >> 1;
        int ret = 0;
//        if (left <= mid) ret += query(root << 1, left, right);
//        if (mid < right) ret += query(root<<1|1, left, right);
        if (left <= mid) ret += query(root << 1, left, right);
        if (mid < right) ret += query(root<<1|1,left, right);
        return ret;
    }

    /*
    单点更新
     */
    private static void update(int root, int index, int C){
        if (tree[root].left == tree[root].right){
            tree[root].val += C;
            return;
        }
        int mid = (tree[root].left + tree[root].right) >> 1;
        if(index <= mid){
            update(root <<1, index, C);
        }
        else update(root << 1 | 1, index, C);
        pushUp(root);
    }
    /*
    区间更新：【left, right】+ C
     */
    private static void update(int root, int left, int right, int C){
        if (left <= tree[root].left && tree[root].right <= right){
            tree[root].val += C * (tree[root].right - tree[root].left + 1);
            tree[root].add += C;
            return;
        }
        pushDown(root);
        int mid = (tree[root].left + tree[root].right) >> 1;
        if (left <= mid){
            update(root <<1, left, right,C);
        }
        if (mid < right){
            update(root << 1 | 1, left, right, C);
        }
        pushUp(root);
    }

    /*
    下推
     */
    private static void pushDown(int root) {
        if (tree[root].add!= 0){
            tree[root << 1].add += tree[root].add;
            tree[root << 1 | 1].add += tree[root].add;
            tree[root<<1].val += tree[root<<1].add * (tree[root<<1].right - tree[root<<1].left + 1);
            tree[root<<1|1].val += tree[root<<1|1].add * (tree[root<<1|1].right - tree[root<<1|1].left + 1);
            tree[root].add = 0;
        }
    }
}

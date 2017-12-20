package oj.ahstu.cc;


import java.util.Scanner;

/**
 * Created by jal on 2017/11/21 0021.
 */
public class BinaryTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String pre = scanner.nextLine();
            String in = scanner.nextLine();
            BinaryTree root = new BinaryTree();
            root = reSearch(pre,in);
            formorder(root);
            System.out.println();
        }
    }

    private static void formorder(BinaryTree root) {
        if(root == null)return;
        formorder(root.left);
        formorder(root.right);
        System.out.print(root.value);
    }

    String value;
    BinaryTree left;
    BinaryTree right;

    private static BinaryTree reSearch(String pre,String in) {

        pre=pre.trim();
        in=in.trim();
        if(pre.isEmpty()|| pre.isEmpty()){
            return null;
        }
        BinaryTree root = new BinaryTree();
        String first = pre.substring(0,1);
        int r = 0;
        for(int i = 0; i < in.length()-1; i++){
            if(in.substring(i,i+1).equals(first)){
                r = i;
                break;
            }
        }
        root.value = first;

        try {

            root.left=reSearch(pre.substring(1,r+1),in.substring(0,r));
        }catch (StringIndexOutOfBoundsException e){
            root.left = null;
        }

        try {
            root.right=reSearch(pre.substring(r+1,pre.length()),in.substring(r+1,in.length()));

        }catch (StringIndexOutOfBoundsException e){
            root.right = null;
        }
        return root;
    }
}

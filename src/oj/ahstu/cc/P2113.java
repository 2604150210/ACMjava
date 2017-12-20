package oj.ahstu.cc;


import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jal on 2017/11/18 0018.
 */
public class P2113 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n;
            n = Integer.parseInt(scanner.nextLine());
            if(n==0)break;
            Stack<Integer>stack = new Stack<>();
            for(int i = 0; i < n; i++){
                String str = scanner.nextLine();
                if(str.equals("0")||str.equals("O")){
                    if (!stack.empty()) {
                        stack.pop();
                    }
                }
                else if(str.equals("A")){
                    if(!stack.empty()){
                        System.out.println(stack.peek());
                    }
                    else System.out.println("E");
                }
                else {
                    stack.push(Integer.valueOf(str.split(" ")[1]));
                }
            }
            System.out.println();
        }
    }
}

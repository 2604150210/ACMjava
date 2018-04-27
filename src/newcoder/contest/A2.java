package newcoder.contest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import static java.util.Arrays.deepToString;

/**
 * Created by jal on 2018/4/27 0027.
 */
public class A2 {
    static char[]chars;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            chars = str.toCharArray();
            Stack<Character>stack = new Stack<>();
            stack.push(chars[0]);
            for (int i = 1; i < chars.length; i++){
                while (!stack.empty()){
                   if( chars[i] > stack.peek()){
                       stack.pop();
                       if (stack.empty()){
                           stack.push(chars[i]);
                           break;
                       }
                   }else {
                       stack.push(chars[i]);
                       break;
                   }
                }
            }
            char[] out = new char[stack.size()];
            int j = 0;
            for (Character i : stack){
                out[j++] = i;
            }
            System.out.println(String.valueOf(out));
    }

    }
}

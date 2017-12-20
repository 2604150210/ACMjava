package EDU;

import java.util.Scanner;

/**
 * Created by jal on 2017/12/8 0008.
 */
public class G1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        while(n-->0){
            int l = Integer.parseInt(scanner.next());
            int r = Integer.parseInt(scanner.next());
            String z = scanner.next();
            String str1 = str.substring(l,r+1);
            int sum = 0;
            int len = z.length();
            for(int i = 0; i < str1.length() - len + 1; i++){
                if(str1.substring(i,i+len).equals(z))sum++;
            }
            System.out.println(sum);
        }
    }
}

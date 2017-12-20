package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2017/11/24 0024.
 */
public class BinarySearch2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = Integer.parseInt(scanner.nextLine());
            if(n == 0)break;
            String str = scanner.nextLine();
          //  BinarySearch2 root = new BinarySearch2();

            str = str.trim();
            for(int i = 0; i < n; i++){
                String second = scanner.nextLine();
                second = second.trim();
                if(str.equals(second)){
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }

            }
        }
    }


}

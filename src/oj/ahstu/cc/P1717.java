package oj.ahstu.cc;

import kotlin.Pair;

import java.awt.*;
import java.util.*;

/**
 * Created by jal on 2017/11/8 0008.
 */
public class P1717 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 1; i <= n; i++){
            String name = scanner.nextLine();

        }
        int m = Integer.parseInt(scanner.nextLine());
        while (m-->0){
            ArrayList<Pair<String, Integer> > arr = new ArrayList<Pair<String, Integer> >();
            for(int i = 0; i < n; i++){

                String str = scanner.nextLine();
                String nam = str.split(" ")[1];
                Integer sore = Integer.valueOf(str.split(" ")[0]);
                arr.add(new Pair<String,Integer>(nam,sore));
            }

        }
    }
}

package anhuiProgramContest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static java.util.Objects.hash;

/**
 * Created by jal on 2018/5/16 0016.
 */
public class Year2017版本依赖 {
    static Scanner cin = null;
    static {
        try {
            cin = new Scanner(new FileInputStream(new File("./bin/in.txt")));
        }catch (IOException e){
            cin = new Scanner(System.in);
        }
    }
    static class Node{
        String name;
        int operator;
        String num;

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", operator=" + operator +
                    ", num='" + num + '\'' +
                    '}';
        }

        public Node(String name, int operator, String num) {
            this.name = name;
            this.operator = operator;
            this.num = num;
        }
    }
    public static void main(String[] args) {
        int T = cin.nextInt();
        int t = 0;
        while (T-- > 0) {t++;
            Vector<Node> set = new Vector<>();
            int n = cin.nextInt();
            for (int i = 1; i <= n; i++) {
                String str = cin.next();
                if (str.contains("==")) {
                    int index = str.indexOf("==");
                    set.add(new Node(str.substring(0, index), 0, str.substring(index+2)));
                } else if (str.contains("<=")) {
                    int index = str.indexOf("<=");
                    set.add(new Node(str.substring(0, index), -1, str.substring(index+2)));
                } else if (str.contains(">=")) {
                    int index = str.indexOf(">=");
                    set.add(new Node(str.substring(0, index), 1, str.substring(index+2)));
                } else if (str.contains("<")) {
                    int index = str.indexOf("<");
                    set.add(new Node(str.substring(0, index), -2, str.substring(index+1)));
                } else if (str.contains(">")) {
                    int index = str.indexOf(">");
                    set.add(new Node(str.substring(0, index), 2, str.substring(index+1)));
                }
            }
            int m = cin.nextInt();
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                String name = cin.next();
                String num = cin.next();
                map.put(name, num);
            }
            ArrayList<String> list = new ArrayList<>();
            for (Node node : set){
                String name = node.name;
                if (!map.containsKey(name)){
                    list.add(name);
                    continue;
                }
                else {
                    boolean flag = ok(node, map.get(name));
                    if (!flag){
                        list.add(name);
                    }
                }
            }
            System.out.print(String.format("Case %d: ",t));
            if (list.size() == 0){
                System.out.println("OK");
            }
            else {
                System.out.print(list.get(0));
                for (int i = 1; i < list.size(); i++){
                    System.out.print(" " + list.get(i));
                }
                System.out.println();
            }
        }
    }

    private static boolean ok(Node node, String num) {
        int x = hash(num);
        int y = hash(node.num);
        int operator = node.operator;
        if (operator == -2) {
            if (x < y)return true;
            else return false;
        }
        if (operator == -1) {
            if (x <= y)return true;
            else return false;
        }
        if (operator == 0){
            if (x == y)return true;
            else return false;
        }
        if (operator == 1) {
            if (x >= y)return true;
            else return false;
        }
        if (operator == 2){
            if (x > y)return true;
            else return false;
        }
        return false;
    }

    static int hash(String str){
        String[] strings = str.split("\\.");
        int ret = 0;
        for (String string :strings){
            ret = ret * 100 + Integer.parseInt(string);
        }
        return ret;
    }
}

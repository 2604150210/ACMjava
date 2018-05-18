package jiSuanKe.test_5_13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by jal on 2018/5/13 0013.
 */
import java.io.*;
public class B {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int T = (int) in.nval;
        while (T-->0){
            in.nextToken();
            int n = (int) in.nval;
            HashMap<String,Integer>map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                in.nextToken();
                String str = in.sval;
                if (str.equals("insert")) {
                    in.nextToken();
                    String word = in.sval;
                    in.nextToken();
                    int num = (int) in.nval;
                    if (map.containsKey(word)) {
                        map.put(word, num + map.get(word));
                    } else {
                        map.put(word, num);
                    }
                }
                else if (str.equals("delete")){
                    in.nextToken();
                    String word = in.sval;
                    if (map.containsKey(word)){
                        map.remove(word);
                    }
                    else {
                        out.println("Empty");
                        out.flush();
                    }
                }
                else if (str.equals("query")){
                    in.nextToken();
                    String word = in.sval;
                    int sum = 0;
                    for (String s : map.keySet()){
                        if (s.endsWith(word)){
                            sum += map.get(s);
                        }
                    }
                    System.out.println(sum);
                }
                else if (str.equals("update")){
                    in.nextToken();
                    String word1 = in.sval;
                    in.nextToken();
                    String word2 = in.sval;
                    boolean isWord1 = false;
                    boolean isWord2 = false;
                    for (String s : map.keySet()){
                        if (s.endsWith(word1)){
                            isWord1 = true;
                        }
                        else if (s.endsWith(word2)){
                            isWord2 = true;
                        }
                    }

                    if (!isWord1){
                        out.println("Empty");
                        out.flush();
                    }

                    else if (isWord2){
                        out.println("Conflict");
                        out.flush();
                    }
                    else{
                        HashMap<String,Integer>set = new HashMap<>();
                        HashMap<String,Integer>set2 = new HashMap<>();

                        for (String s : map.keySet()){
                            if (s.endsWith(word1)){
                                int num = map.get(s);
                                //map.remove(s);
                                set.put(s,map.get(s));
                                s = s.substring(0,s.length() - word1.length()) + word2;
                                set2.put(s,num);
                            }
                        }
                        for (String s : set.keySet()){
                            map.remove(s);
                        }
                        map.putAll(set2);

                    }
                }
            }
        }

    }
}

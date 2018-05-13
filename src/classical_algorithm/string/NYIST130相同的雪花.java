package classical_algorithm.string;

import java.io.*;
import java.util.*;

/**
 * Created by jal on 2018/5/9 0009.
 */
public class NYIST130相同的雪花 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-->0){
            int n = scanner.nextInt();
            HashMap<ArrayList, Vector<ArrayList>>map = new HashMap<>();
            for(int i = 0; i < n; i++){
                ArrayList temp = new ArrayList();
                for (int j = 0; j < 6; j++){
                    temp.add(scanner.nextInt());
                }
                ArrayList temp2 = (ArrayList) temp.clone();
                Collections.sort(temp2);
                if (!map.containsKey(temp2)){
                    Vector v = new Vector<>();
                    v.add(temp);
                    map.put(temp2,v);
                }
                else {
                    Vector v = map.get(temp2);
                    v.add(temp);
                    map.put(temp2, v);
                }
            }
            boolean result = false;
            for (ArrayList listSort : map.keySet()){
                if (map.get(listSort).size() > 360){
                    result = true;
                    break;
                }
                else {
                    Vector v = map.get(listSort);
                    for (int i = 0; i < v.size(); i++){
                        for(int j = i+1; j < v.size(); j++){
                            result = check((ArrayList)v.get(i),(ArrayList)v.get(j));
                            if (result)break;
                        }
                        if (result)break;
                    }
                }
            }
            if (result){
                System.out.print("Twin snowflakes found.\n");
            }
            else {
                System.out.print("No two snowflakes are alike.\n");
            }
        }
    }
    private static boolean check(ArrayList list, ArrayList list1) {
        list1.addAll(list1);
        int index = Collections.indexOfSubList(list1,list);
        if (index != -1)return true;
        Collections.reverse(list1);
        index = Collections.indexOfSubList(list1,list);
        if (index != -1)return true;
        return false;
    }
}
/*
3
1 1 2 3 4 5
2 1 3 4 5 1
3 4 2 1 1 5
 */
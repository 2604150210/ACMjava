package oj.ahstu.cc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by jal on 2017/12/16 0016.
 */
class Party{
    String person,party;
    int num;

    public Party(String person, String party, int num) {
        this.person = person;
        this.party = party;
        this.num = num;
    }

    public Party(String person, String party) {
        this.person = person;
        this.party = party;
    }
}
public class P1991 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            if(n == 1){
                String person = scanner.nextLine();
                String party = scanner.nextLine();
                int m = Integer.parseInt(scanner.nextLine());
                for(int i = 0; i < m; i++){
                    scanner.nextLine();
                }
                System.out.println(party);
                continue;
            }
            Party []p = new Party[n];
            for(int i = 0; i < n; i++){
                String person = scanner.nextLine();
                String party = scanner.nextLine();
                p[i] = new Party(person,party,0);
            }
            int m =Integer.parseInt(scanner.nextLine());
            for(int i = 0; i < m; i++){
                String temp = scanner.nextLine();
                for(int j = 0; j < n; j++){
                    if(temp.equals(p[j].person)){
                        p[j].num++;
                        break;
                    }
                }
            }
            Arrays.sort(p, new Comparator<Party>() {
                @Override
                public int compare(Party o1, Party o2) {
                    return o2.num - o1.num;
                }
            });
            if(p[0].num == p[1].num){
                System.out.println("tie");
            }else {
                System.out.println(p[0].party);
            }
        }
    }
}

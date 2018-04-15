package oj.ahstu.cc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by jal on 2017/12/19 0019.
 */
class Student {
    String num, name;
    int age;

    public Student(String num, String name, int age) {
        this.num = num;
        this.name = name;
        this.age = age;
    }
}

public class P2120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = 1;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int c = scanner.nextInt();
            if (n == 0) break;
            Student a[] = new Student[n];
            for (int i = 0; i < n; i++) {
                a[i] = new Student(scanner.next(), scanner.next(), scanner.nextInt());
            }
            if (c == 1) {
                Arrays.sort(a, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.num.compareTo(o2.num);
                    }
                });
            } else if (c == 2) {
                Arrays.sort(a, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        if (o1.name.equals(o2.name))
                            return o1.num.compareTo(o2.num);
                        else {
                            return o1.name.compareTo(o2.name);
                        }
                    }
                });
            } else if (c == 3) {
                Arrays.sort(a, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        if (o1.age != o2.age)
                            return o1.age - o2.age;
                        else return o1.num.compareTo(o2.num);
                    }
                });
            }

            System.out.println(String.format("Case %d:", t++));
            for (Student i : a) {
                System.out.println(i.num + " " + i.name + " " + i.age);
            }
        }
    }
}

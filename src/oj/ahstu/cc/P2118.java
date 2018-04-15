package oj.ahstu.cc;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jal on 2017/12/19 0019.
 */
class Stu implements Comparable<Stu> {
    String name;
    int age;
    double grade;

    public Stu(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public int compareTo(Stu that) {
        if (this.grade != that.grade) {
            return Double.compare(this.grade, that.grade);
        } else {
            if (this.name.equals(that.name)) {
                return this.age - that.age;
            }
            return this.name.compareTo(that.name);
        }
    }
}

public class P2118 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Stu[] stus = new Stu[n];
            for (int i = 0; i < n; i++) {
                stus[i] = new Stu(scanner.next(), scanner.nextInt(), scanner.nextDouble());
            }
            Arrays.sort(stus);
            for (Stu i : stus) {
                System.out.print(i.name + " " + i.age + " ");
                double x = i.grade;
                if (Double.toString(x).substring(Double.toString(x).length() - 2).equals(".0")) {
                    System.out.println(Double.toString(x).substring(0, Double.toString(x).length() - 2));
                } else {
                    System.out.println(x);
                }
            }
        }
    }
}

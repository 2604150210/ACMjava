package oj.ahstu.cc;

import java.util.Scanner;

/**
 * Created by jal on 2018/4/15 0015.
 */
public class P2377{
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        double a = cin.nextDouble();
        double b = cin.nextDouble();
        double c = cin.nextDouble();
        if(a==0)
        {
            System.out.println("not a quadratic");
        }
        else
        {
            double delta = b*b-4*a*c;
            if (delta==0)
            {
                System.out.print("two equal rootSs:");
                System.out.printf("%.4f\n",-b/(2*a));
            }
            else if (delta>0)
            {
                System.out.print("dictinct real tools:");
                double x1 = (-b+Math.sqrt(delta))/(2*a);
                double x2 = (-b-Math.sqrt(delta))/(2*a);
                System.out.printf("%.4f %.4f\n",x1,x2);
            }
            else
            {
                System.out.print("complex tools:");
                delta = 0-delta;
                double x_real = -b/(2*a);
                double x1_i = Math.sqrt(delta)/(2*a);
                double x2_i = -Math.sqrt(delta)/(2*a);
                if(a>0)
                    System.out.printf("%.4f+%.4fi %.4f%.4fi\n",x_real,x1_i,x_real,x2_i);
                else
                    System.out.printf("%.4f+%.4fi %.4f+%.4fi\n",x_real,x1_i,x_real,x2_i);
            }
        }
        cin.close();
    }
}

package classical_algorithm.numberTheory.matrixFastPower;

import java.util.Scanner;

/**
 * Created by jal on 2018/5/2 0002.
 */
public class AOJ2310Fibonacci数列 {
    static class Matrix {
        @Override
        public String toString() {
            return String.format("%d %d\n%d %d", data[0][0], data[0][1], data[1][0], data[1][1]);
        }

        final static Matrix ZERO = new Matrix();
        final static Matrix UNIT = new Matrix(new long[][]{{1, 0}, {0, 1}});
        static int MOD = (int) (1e9+7);
        int row = 2, col = 2;
        long[][] data = new long[row][col];

        public Matrix(long[][] ints) {
            this.data = ints;
        }

        public Matrix() {
            this(new long[2][2]);
        }

        Matrix mul(Matrix that) {
            Matrix C = new Matrix();
            C.data[0][0] = (this.data[0][0] * that.data[0][0] % MOD + this.data[0][1] * that.data[1][0] % MOD) % MOD;
            C.data[0][1] = (this.data[0][1] * that.data[1][1] % MOD + this.data[0][0] * that.data[0][1] % MOD) % MOD;
            C.data[1][0] = (this.data[1][0] * that.data[0][0] % MOD + this.data[1][1] * that.data[1][0] % MOD) % MOD;
            C.data[1][1] = (this.data[1][0] * that.data[0][1] % MOD + this.data[1][1] * that.data[1][1] % MOD) % MOD;
            return C;
        }

        Matrix pow(int n) {
            if (n == 0)
                return UNIT;
            if (n == 1)
                return this;
            if ((n & 1) == 0) {
                return this.mul(this).pow(n / 2);
            }
            return this.mul(this).pow(n / 2).mul(this);
        }
    }

    public static void main(String[] args) {
        Matrix m = new Matrix(new long[][]{{1, 1}, {1, 0}});
        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            int n = scanner.nextInt();
//
//            System.out.println(m.pow(n-1).data[0][0]);
//        }
        for (int i = 0; i < 20; i++){
            System.out.println(m.pow(i).data[0][0]);
        }
    }

}

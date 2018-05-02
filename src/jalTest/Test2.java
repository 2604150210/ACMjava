package jalTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static java.util.Arrays.deepToString;
import static java.util.Arrays.sort;

public class Test2 {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./bin/output.txt";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner scanner = new Scanner(System.in);

    class Direction{
        int head,face;
    }
    void run() {
        int T = scanner.nextInt();
        while (T-- > 0){
            int n = scanner.nextInt();
            int x,y,z;
            Direction direction = new Direction();
            direction.face = 0;
            direction.head = 2;
            for (int i = 0; i < n; i++){
                String str = scanner.next();
                int dis = scanner.nextInt();
                switch (str){
                    case "forward":direction = forward(direction);break;
                    case "back":direction = back(direction);break;
                    case "left":direction = left(direction);break;
                    case "right":direction = right(direction);break;
                    case "up":direction = up(direction);break;
                    case "down":direction = down(direction);break;
                }
            }
        }

    }

    private Direction down(Direction direction) {
        return null;
    }

    private Direction up(Direction direction) {
        return null;
    }

    private Direction right(Direction direction) {
        return left(left(left(direction)));
    }

    private Direction left(Direction direction) {
        if (direction.head == 2){
            int ret = 0;
            switch (direction.face){
                case 0: ret = 4;break;
                case 1: ret = 0;break;
                case 3: ret = 1;break;
                case 4: ret = 3;break;
            }
            direction.face = ret;
        }
        if (direction.head == 5){
            int ret = 0;
            switch (direction.face){
                case 0: ret = 1;break;
                case 1: ret = 3;break;
                case 3: ret = 4;break;
                case 4: ret = 0;break;
            }
            direction.face = ret;
        }
        if (direction.head == 0){
            int ret = 0;
            switch (direction.face){
                case 1: ret = 5;break;
                case 2: ret = 4;break;
                case 4: ret = 2;break;
                case 5: ret = 1;break;
            }
            direction.face = ret;
        }
        if (direction.head == 3){
            int ret = 0;
            switch (direction.face){
                case 1: ret = 2;break;
                case 2: ret = 4;break;
                case 4: ret = 5;break;
                case 5: ret = 1;break;
            }
            direction.face = ret;
        }
        if (direction.head == 1){
            int ret = 0;
            switch (direction.face){
                case 0: ret = 2;break;
                case 2: ret = 3;break;
                case 3: ret = 5;break;
                case 5: ret = 0;break;
            }
            direction.face = ret;
        }
        if (direction.head == 4){
            int ret = 0;
            switch (direction.face){
                case 0: ret = 5;break;
                case 2: ret = 0;break;
                case 3: ret = 2;break;
                case 5: ret = 3;break;
            }
            direction.face = ret;
        }
        return direction;
    }

    private Direction back(Direction direction) {
        int ret = 0;
        switch (direction.face){
            case 0:ret = 3;break;
            case 1:ret = 4;break;
            case 2:ret = 5;break;
            case 3:ret = 0;break;
            case 4:ret = 1;break;
            case 5:ret = 2;break;
        }
        direction.face = ret;
        return direction;
    }

    private Direction forward(Direction direction) {
        return direction;
    }


    public void debug(Object ... objects){
        System.err.println(deepToString(objects));
    }
    public static void main(String[] args) {
        if (LOCAL) {
            try {
                System.setIn(new FileInputStream(INPUT_FILE));
            } catch (Throwable e) {
                LOCAL = false;
            }
        }
        if (TO_FILE) {
            try {
                System.setOut(new PrintStream(OUTPUT_FILE));
            } catch (FileNotFoundException e) {
                TO_FILE = false;
            }
        }
        new Test2().run();
    }
}
package jalTest;

import java.io.IOException;

/**
 * Created by jal on 2018/5/8 0008.
 */
public class RuntimeDemo {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i ++){
            try {
                Runtime.getRuntime().exec("explorer.exe https://blog.csdn.net/jal517486222/article/details/80238134");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

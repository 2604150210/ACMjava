package jalTest;

import java.io.*;

/**
 * Created by jal on 2018/5/8 0008.
 */
public class JavaHighSpeedIOTest {
    public static void main(String[] args) throws IOException {
        /* 下面这是IO流包装，可以看不懂，直接套用就好*/
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

         /*StreamTokenizer.TT_EOF这是个参数，就是指文件尾，EOF*/
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int a = (int) in.nval;/*获取整数*/
            in.nextToken();/*nextToken()方法相当于让光标指向下一个位置，记得写*/
            int b = (int) in.nval;
            in.nextToken();
            int c = (int) in.nval;
            in.nextToken();
            double d = in.nval;
            in.nextToken();
            String str = in.sval;/*注意：sval是获取不带空格的字符串，含有空格的字符串貌似无法读取。*/
            in.nextToken();
            out.println(a);
            out.print(str);
            out.flush();/*刷新输出缓冲区*/
        }
    }
}

package oj.ahstu.cc;

import jdk.management.resource.internal.inst.FileInputStreamRMHooks;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by jal on 2017/12/6 0006.
 */
public class ZJTestor {
    public static void main(String[] args) throws IOException {

        BufferedReader bif=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(bif.readLine());
        bif.close();
    }
}

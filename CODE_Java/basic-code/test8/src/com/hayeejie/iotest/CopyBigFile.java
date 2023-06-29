package com.hayeejie.iotest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name Learn-basic-code
 * @date 2023/6/25 14:48
 */
public class CopyBigFile {
    public static void main(String[] args) throws IOException {
        //计算复制时间
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("E:\\2023-05-01 21-45-36.mkv");
        FileOutputStream fos = new FileOutputStream("E:\\2023-05-01 21-45-36copy.mkv");
        byte[] bytes = new byte[1024 * 1024 * 10];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
        long stop = System.currentTimeMillis();
        long time = stop - start;
        System.out.println(time);
    }
}

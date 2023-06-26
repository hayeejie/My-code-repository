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
public class CopyFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\OneDrive - glut.edu.cn\\桌面\\xuehao.txt");
        FileOutputStream fos = new FileOutputStream("E:\\OneDrive - glut.edu.cn\\桌面\\xuehaocopy.txt");
        //计算复制时间
        long start = System.currentTimeMillis();
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        long stop = System.currentTimeMillis();
        long time = stop - start;
        System.out.println(time);
        fos.close();
        fis.close();
    }
}

package com.hayeejie.iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name Learn-basic-code
 * @date 2023/6/27 10:28
 */
public class CopyFolder {
    public static void main(String[] args) throws IOException {
        // 1.创建源目录
        File src = new File("E:\\素材");
        // 2.创建目标目录
        File dest = new File("E:\\素材2");

        copyFolder(src, dest);


    }

    private static void copyFolder(File src, File dest) throws IOException {
//        创建目标文件夹，无需做是否存在判断
        dest.mkdirs();
//        1.进入数据源
        File[] files = src.listFiles();
//        2.遍历
        for (File file : files) {
//          3.判断
            if (file.isFile()) {
//                是文件，拷贝
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));
                byte[] bytes = new byte[1024 * 10];
                int len;
                while ((len = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
            } else {
//                文件夹，递归
                copyFolder(file, new File(dest, file.getName()));
            }
        }

    }
}

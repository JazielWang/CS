package com.itheima07;

import java.io.*;

/*
    需求：
        把“E:\\itcast”复制到 F盘目录下

    思路：
        1:创建数据源File对象，路径是E:\\itcast
        2:创建目的地File对象，路径是F:\\
        3:写方法实现文件夹的复制，参数为数据源File对象和目的地File对象
        4:判断数据源File是否是目录
            是：
                A:在目的地下创建和数据源File名称一样的目录
                B:获取数据源File下所有文件或者目录的File数组
                C:遍历该File数组，得到每一个File对象
                D:把该File作为数据源File对象，递归调用复制文件夹的方法
            不是：说明是文件，直接复制，用字节流
 */
public class CopyFoldersDemo {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("E:\\BaiduNetdiskDownload\\Ordeal by Innocence");
        File destFile = new File("E:\\TIM");
        copyFolder(srcFile,destFile);
    }

    private static void copyFolder(File srcFile, File destFile) throws IOException {
        if (srcFile.isDirectory()){
            String name = srcFile.getName();
            File newname = new File(destFile,name);
            if (!newname.exists()){
                newname.mkdir();
            }

            File[] files = srcFile.listFiles();
            for (File file:files){
                copyFolder(file,newname);
            }
        }else {
            File file = new File(destFile, srcFile.getName());
            copyFile(srcFile,file);
        }
    }

    //字节缓冲流复制文件
    private static void copyFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }

        bos.close();
        bis.close();
    }
}

package com.itheima10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/*
    服务器：接收到的数据在控制台输出
 */
public class ServeDemo02 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);

        Socket s = ss.accept();

        //获取输入流
//        InputStream is = s.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while ((line= br.readLine())!=null){
            System.out.println(line);
        }
        ss.close();
    }
}

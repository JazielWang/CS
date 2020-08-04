package com.itheima10;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/*
    服务器：接收数据，给出反馈
 */
public class ServeDemo01 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);

        Socket s = ss.accept();

        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        System.out.println(new String(bys, 0, is.read(bys)));

        //给出反馈
        OutputStream os = s.getOutputStream();
        os.write("收到数据".getBytes());

        ss.close();
    }
}

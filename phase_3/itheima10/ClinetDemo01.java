package com.itheima10;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/*
    客户端：发送数据，接收服务器反馈
 */
public class ClinetDemo01 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("10.171.77.101",10000);

        OutputStream os = s.getOutputStream();
        os.write("wangjie".getBytes());

        //接收服务器反馈
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        System.out.println(new String(bys,0,is.read(bys)));

        s.close();
    }
}

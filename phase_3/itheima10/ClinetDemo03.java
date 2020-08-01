package com.itheima10;

import java.io.*;
import java.net.Socket;
/*
    服务器：接收到的数据写入文本文件
 */
public class ClinetDemo03 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("10.171.77.101",10000);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //把数据写入文本文件
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String data;

        while ((data=br.readLine())!=null) {
            if ("886".equals(data)){
                break;
            }
            bw.write(data);
            bw.newLine();
            bw.flush();
        }
        s.close();
    }
}

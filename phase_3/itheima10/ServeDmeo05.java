package com.itheima10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeDmeo05 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);

        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Google\\TCP.txt"));

        String line;
        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //给出反馈
        BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw2.write("file is updated");
        bw2.newLine();
        bw2.flush();

        bw.close();
        ss.close();
    }
}

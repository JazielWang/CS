package com.itheima10;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket s;

    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Google\\wj.txt"));

            int count = 0;
            File file = new File("E:\\Google\\wj[" + count + "].txt");
            while (file.exists()) {
                count++;
                file = new File("E:\\Google\\wj[" + count + "].txt");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
            //给出反馈
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw2.write("file had updated");
            bw2.newLine();
            bw2.flush();

            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

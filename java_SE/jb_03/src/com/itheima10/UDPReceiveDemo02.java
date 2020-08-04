package com.itheima10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveDemo02 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10087);
        while (true) {
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);

            ds.receive(dp);

            System.out.println("收到的数据时：" + new String(dp.getData(), 0, dp.getLength()));
        }

//        ds.close();
    }
}

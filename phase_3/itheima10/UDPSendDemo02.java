package com.itheima10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSendDemo02 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入相关的数据:");
        String s;

        while ((s=sc.nextLine())!=null) {
            if ("886".equals(s)) {
               break;
            }
            byte[] bys = s.getBytes();
            DatagramPacket dp = new DatagramPacket(bys,bys.length, InetAddress.getByName("10.171.77.101"),10087);

            ds.send(dp);
        }

        ds.close();
    }
}

package com.itheima10;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
    InetAddress
        此类表示Internet协议（IP）地址

    public static InetAddress getByName​(String host)：确定主机名称的IP地址。主机名称可以是机器名称，也可以是IP地址
    public String getHostName​()：获取此IP地址的主机名
    public String getHostAddress​()：返回文本显示中的IP地址字符串
 */
public class InetAdressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("10.171.77.101");
//        InetAddress address = InetAddress.getByName("LAPTOP-9QPM6PGK");

        String hostName = address.getHostName();
        String hostAddress = address.getHostAddress();

        System.out.println(hostAddress);
        System.out.println(hostName);
    }
}

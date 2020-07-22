package com.itheima_20;

import java.util.Date;

public class DateDemo01 {
    public static void main(String[] args) {
        // public Date() 分配 Date对象并对其进行初始化，使其表示分配时间，测量 Date到毫秒。
        Date d1 = new Date();
        System.out.println(d1);

        // public Date(long date)分配 Date对象并初始化它以表示自标准基准时间（称为“纪元”）以来的指定毫秒数，即1970年1月1日00:00:00 GMT。
        long date = 1000*60*60;
        Date d2 = new Date(date);
        System.out.println(d2);

        // public long getTime():获取的是日期对象从纪元到现在的毫秒值
        Date d3 = new Date();
        System.out.println(d3.getTime()*1.0/1000/60/60/24/365+"year");

        // public void setTime(long time):设置时间，给的是毫秒值
//        long time = 1000*60*60;
        long time = System.currentTimeMillis();
        d3.setTime(time);
        System.out.println(d3);
    }
}

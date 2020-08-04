package com.itheima_20;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class SimpleDateDemo {
    public static void main(String[] args) throws ParseException {
        // 格式化:从 Date 到 String
        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String s = sdf.format(d);
        System.out.println(s);
        System.out.println("----------------");

        // 解析：从 String 到 Date
        String s2 = "2018年1月22日 23:34:23";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date parse = sdf2.parse(s2);
        System.out.println(parse);
    }
}

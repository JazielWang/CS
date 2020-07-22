package com.itheima_20;

import java.text.ParseException;
import java.util.Date;

public class DateDemo02 {
    public static void main(String[] args) throws ParseException {
        Date d = new Date();
        String format = "yyyy年MM月dd日 HH:mm:ss";
        String s = DateUtlis.dTs(d, format);// 由于是静态方法，可以公国类直接调用
        System.out.println(s);
        System.out.println("------------------");

        String s2 = "2020-12-23 15:12:12";
        String format2 = "yyyy-MM-dd HH:mm:ss";
        Date d2 = DateUtlis.sTd(s2, format2);
        System.out.println(d2);


    }
}

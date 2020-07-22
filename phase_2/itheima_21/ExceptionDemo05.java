package com.itheima_21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    异常种类
 */
public class ExceptionDemo05 {
    public static void main(String[] args) {
        System.out.println("start");
        method();
        try {
            method2();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
    // 编辑是异常
    public static void method2() throws ParseException{
        String s = "2018-12-3";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(s);
        System.out.println(d);
    }

    // 运行时异常
    public static void method() throws ArrayIndexOutOfBoundsException{
        int[] arr = {23, 25, 252};
        System.out.println(arr[3]); //ArrayIndexOutOfBoundsException
    }
}

package com.itheima_21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    异常种类
 */
public class ExceptionDemo04 {
    public static void main(String[] args) {
        method();
        method2();
    }

    public static void method2(){
        try {
            String s = "2018-12-3";
            SimpleDateFormat sdf = new SimpleDateFormat();
            Date d = sdf.parse(s);
            System.out.println(d);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    // 运行时异常
    public static void method(){
        int[] arr = {23, 25, 252};
        System.out.println(arr[3]); //ArrayIndexOutOfBoundsException
    }
}

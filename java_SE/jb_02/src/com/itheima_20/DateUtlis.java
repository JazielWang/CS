package com.itheima_20;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    工具类

    构造方法私有
    成员方法静态
 */
public class DateUtlis {
    private DateUtlis(){}

    public static String dTs(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(date);
        return s;
    }

    public static Date sTd(String s , String format) throws ParseException {
        SimpleDateFormat sdf =new SimpleDateFormat(format);
        Date d = sdf.parse(s);
        return d;
    }
}

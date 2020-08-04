package com.itheima_20;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
//        System.out.println(c);
        /*int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        System.out.println(year+"-"+month+"-"+date);*/

        /*  public abstract void add(int field, int amount):根据日历的规则，将指定的时间量添加或者减去给定的日历字段
        // 需要1 ：3年前的今天
        c.add(Calendar.YEAR, -3);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        System.out.println(year+"-"+month+"-"+date);*/

        /*// 需要2 ：10年后的5天前
        c.add(Calendar.YEAR, 10);
        c.add(Calendar.DATE, -5);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        System.out.println(year+"-"+month+"-"+date);*/


        // public final void set(int year, int month, int date):设置当前日历的年月日
        c.set(2048, 11, 11);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        System.out.println(year+"-"+month+"-"+date);


    }
}

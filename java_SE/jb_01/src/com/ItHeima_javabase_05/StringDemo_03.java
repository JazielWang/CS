package com.ItHeima_javabase_05;

import java.util.Scanner;

public class StringDemo_03 {
    public static void main(String[] args) {

        //用户账户和密码
        String username = "wangjei";
        String password = "123456";

        for (int i = 0; i<3; i++) {
            System.out.println("请输入用户名和密码：");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            String pwd = sc.nextLine();

            if (name.equals(username) && pwd.equals(password)) {
                System.out.println("登录成功");
                break;
            } else {
                if (2-i == 0){
                    System.out.println("登录失败，请和管理员联系");
                }else {
                    System.out.println("登录失败，你还有" + (2 - i) + "次机会");
                }
            }
        }
    }
}

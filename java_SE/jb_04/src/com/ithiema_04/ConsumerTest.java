package com.ithiema_04;

import java.util.function.Consumer;

/*
    String[] strArray = {"林青霞,30", "张曼玉,35", "王祖贤,33"};
    字符串数组中有多条信息，请按照格式："姓名：XX,年龄：XX"的格式将信息打印出来
    要求：
        把打印姓名的动作作为第一个Consumer接口的Lambda实例
        把打印年龄的动作作为第二个Consumer接口的Lambda实例
        将两个Consumer接口按照顺序组合到一起使用
 */
public class ConsumerTest {
    public static void main(String[] args) {
        String[] strArray = {"林青霞,30", "张曼玉,35", "王祖贤,33"};
        /*gitInfo(strArray, (String str) -> {
            String s = str.split(",")[0];
            System.out.print("姓名是：" + s);
        },(String str)->{
            String s = str.split(",")[1];
            System.out.println("，年龄是："+s);
        });*/

        gitInfo(strArray, str -> System.out.print("姓名是：" + str.split(",")[0]),
                str -> System.out.println("，年龄是：" + str.split(",")[1]));
    }

    private static void gitInfo(String[] str, Consumer<String> con1, Consumer<String> con2) {
        for (String string : str) {
            con1.andThen(con2).accept(string);
        }
    }
}

package com.itheima08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/*
    需求：请写程序实现猜数字小游戏只能试玩3次，如果还想玩，提示：游戏试玩已结束，想玩请充值(www.itcast.cn)

    思路：
        1:写一个游戏类，里面有一个猜数字的小游戏
        2:写一个测试类，测试类中有main方法，main()方法中按照下面步骤完成
            A:从文件中读取数据到Properties集合，用load()方法实现
                文件已经存在：game.txt
                里面有一个数据值：count=0
            B:通过Properties集合获取到玩游戏的次数
            C:判断次数是否到到3次了
                如果到了，给出提示：游戏试玩已结束，想玩请充值(www.itcast.cn)
                如果不到3次：
                    玩游戏
                    次数+1，重新写回文件，用Properties的store()方法实现
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties pps = new Properties();
        FileReader fr = new FileReader("E:\\Google\\count.txt");
        pps.load(fr);
        String count = pps.getProperty("count");
        int i = Integer.parseInt(count);
        if (i>=3){
            System.out.println("余额不足请充值（www.baidu.com）");
        }else {
            GuessNumber.start();
            i++;
            pps.setProperty("count", String.valueOf(i));
            FileWriter fw = new FileWriter("E:\\Google\\count.txt");
            pps.store(fw,null);
            fw.close();
        }
    }
}

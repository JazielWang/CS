package com.ItHeima_javabase;

public class OperatorDemo {
    public static void main(String[] var0) {
        byte var1 = 6;
        byte var2 = 4;
        System.out.println(var1 + var2);
        System.out.println(var1 - var2);
        System.out.println(var1 * var2);
        System.out.println(var1 / var2);
        System.out.println(var1 % var2);
        System.out.println(1.5D);

        boolean var3 = true;
        byte var4 = 83;
        System.out.println(var3);
        int var5 = var4 + var4;
        System.out.println(var5);

        System.out.println("fuck刘晶6666");
        System.out.println("100fuck刘晶");
        System.out.println("100fuck刘晶666");

        byte var6 = 10;
        System.out.println("i:" + var6);
        int var8 = var6 + 20;
        var8 += 20;
        System.out.println("i:" + var8);
        byte var7 = 20;
        short var9 = (short)(var7 + 20);
        System.out.println("s:" + var9);

        byte var10 = 10;
        int var11 = var1 + 1;
        System.out.println("i" + var11);
        ++var11;
        System.out.println("i:" + var11);
        ++var11;
        System.out.println("i:" + var11);
        System.out.println("j:" + var11);

        byte var12 = 12;
        byte var13 = 13;
        byte var14 = 12;
        System.out.println(var12 == var13);
        System.out.println(var12 == var14);
        System.out.println("-----------");
        System.out.println(var12 >= var13);
        System.out.println(var12 >= var14);
        System.out.println("-----------");

        /*
            三元运算符 ？ 表达式1 : 表达式2
            范例：
                a > b ? a : b
            执行流程：
                首先计算关系表达式的值
                如果值为true，表达式1的值就是运算结果
                如果值为false，表达式2的值就是运算结果
         */
        int a = 10;
        int b = 20;
        int max = a > b ? a : b;
        System.out.println("max:" + max);
        //三元运算符案例
        int tall1 = 150;
        int tall2 = 210;
        int tall3 = 165;
        int tall4 = tall1 > tall2 ? tall1 : tall2;
        int tall5 = tall4 > tall3 ? tall4 : tall3;
        System.out.println("maxtall:" + tall5);


    }
}

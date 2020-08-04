package com.itheima02;
/*
    哈希值：
        public int hashCode():返回对象的哈希码值
 */
public class HashDemo {
    public static void main(String[] args) {
        Student s1 = new Student("王杰",45);

        System.out.println(s1.hashCode());//2083562754
        System.out.println(s1.hashCode());//2083562754
        System.out.println("----------------");

        // 不同对象的哈希值是不同的
        Student s2 = new Student("王杰", 45);
        System.out.println(s2.hashCode());//1239731077
        System.out.println("-----------------");

        System.out.println("java".hashCode());//3254818
        System.out.println("world".hashCode());//113318802
        // 中文字符的哈希值被中写？中文容易重复？
        System.out.println("重地".hashCode());//1179395
        System.out.println("通话".hashCode());//1179395
    }
}

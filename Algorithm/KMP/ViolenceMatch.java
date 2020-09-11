package com.KMP;

/**
 * @
 * @date 2020/9/11 - 17:13
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        //测试暴力匹配算法
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        int index = violenceMatch(str1, str2);
        System.out.println("index=" + index);
    }

    // 暴力匹配算法实现
    public static int violenceMatch(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int i = 0; // i索引指向s1
        int j = 0; // j索引指向s2
        int c1len = c1.length;
        int c2len = c2.length;
        while (i < c1len && j < c2len) {// 保证匹配时，不越界
            if (c1[i] == c2[j]) {//匹配ok
                i++;
                j++;
            } else {//没有匹配成功
                //如果失配（即str1[i]! = str2[j]），令i = i - (j - 1)
                i = i - (j - 1);
                j = 0;
            }
        }
        //判断是否匹配成功
        if (j == c2len) {
            return i - j;
        } else {
            return -1;
        }
    }
}

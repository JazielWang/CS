package com.DivideandConquer;
/**
 * @
 * @date 2020/9/11 - 9:48
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }

    /**
     * 分治算法实现汉诺塔问题
     * @param num 移动盘子总数
     * @param a 柱子 A
     * @param b 柱子 B
     * @param c 柱子 C
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {//如果只有一个盘
            System.out.println(a + " -> " + c);
        } else {
            //如果我们有 n >= 2 情况，我们总是可以看做是两个盘 1.最下边的一个盘 2. 上面的所有盘
            //1. 先把 最上面的所有盘 A->B， 移动过程会使用到 C 塔
            hanoiTower(num - 1, a, c, b);
            //2. 把最下边的盘 A->C
            System.out.println(a + " -> " + c);
            //3. 把B塔的所有盘 从 B->C , 移动过程使用到 A 塔
            hanoiTower(num - 1, b, a, c);
        }
    }
}

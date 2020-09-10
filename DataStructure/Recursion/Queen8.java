package com.Recursion;

public class Queen8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array, 保存皇后放置位置的结果,比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];
    static int count = 0;
    static int judgecount = 0;

    public static void main(String[] args) {
        //测试一把 ， 8皇后是否正确
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("八皇后问题有" + count + "种解法");
        System.out.println(judgecount);

    }

    //编写一个方法，放置第n个皇后
    //特别注意： check 是每一次递归时，进入到check中都有  for(int i = 0; i < max; i++)，因此会有回溯
    private void check(int n) {
        if (n == max) {//n = 8 , 其实8个皇后就既然放好
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后 n , 放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                //接着放n+1个皇后,即开始递归
                check(n + 1);
            }
            //如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行得后移的一个位置
        }
    }

    //查看当我们放置第n个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突
    /**
     * @param n 表示第 n 个皇后
     * @return 将是否冲突的结果返回，true：不冲突，false：冲突
     */
    private boolean judge(int n) {
        judgecount++;
        for (int i = 0; i < n; i++) {
            // 说明
            //1. array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
            // n = 1  放置第 2列 1 n = 1 array[1] = 1
            // Math.abs(1-0) == 1  Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 判断是否在同一行, 没有必要，n 每次都在递增
            if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将皇后摆放的位置输出
    private void print() {
        count++;
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

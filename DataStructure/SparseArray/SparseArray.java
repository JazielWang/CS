package com.SparseArray;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparseArray {
    public static void main(String[] args) throws IOException {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        // 输出原始的二维数组
        // 将二维数组 转 稀疏数组的思
        // 1. 先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 2. 创建对应的稀疏数组
        // 给稀疏数组赋值
        int[][] sparseArr1 = new int[sum + 1][3];
        int count = 0;
        // 遍历二维数组，将非0的值存放到 sparseArr中
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr1[count][0] = i;
                    sparseArr1[count][1] = j;
                    sparseArr1[count][2] = chessArr1[i][j];
                }
            }
        }
        sparseArr1[0][0] = chessArr1.length;
        sparseArr1[0][1] = chessArr1.length;
        sparseArr1[0][2] = sum;

        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Google\\map.data"));
        for (int[] arr : sparseArr1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            String string = sb.toString();
            bw.write(string);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        BufferedReader br = new BufferedReader(new FileReader("E:\\Google\\map.data"));
        List<String[]> al = new ArrayList<>();
        String len;
        while ((len = br.readLine()) != null) {
            String[] s = len.split(" ");
            al.add(s);
        }
        br.close();

        int[][] chessArr2 = new int[3][3];
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(1).length; j++) {
                chessArr2[i][j] = Integer.parseInt(al.get(i)[j]);
            }
        }
        System.out.println(Arrays.deepToString(chessArr2));
        int[][] chessArr3 = new int[chessArr2[0][0]][chessArr2[0][1]];
        for (int i = 1; i < chessArr2.length; i++) {
            chessArr3[chessArr2[i][0]][chessArr2[i][1]] = chessArr2[i][2];
        }
        System.out.println(Arrays.deepToString(chessArr3));
    }
}

package com.ShortestPathProblem;

import java.util.Arrays;

/**
 * @author 王杰
 * @date 2020年9月14日15:22:22
 */
public class Floyd {
    public static void main(String[] args) {
        // 测试看看图是否创建成功
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };

        //创建 Graph 对象
        Graph2 graph = new Graph2(vertex, matrix, vertex.length);
        //调用弗洛伊德算法
        graph.floyd();
        graph.show();
    }
}

class Graph2{
    private char[] Node;
    private int[][] matrix;
    private int[][] pre;

    /**
     * 构造器
     * @param node 顶点数组
     * @param matrix 邻接矩阵记录距离
     * @param length 顶点数目
     */
    public Graph2(char[] node, int[][] matrix, int length) {
        Node = node;
        this.matrix = matrix;
        this.pre = new int[length][length];
        //对pre数组进行初始化
        for (int i = 0; i< length; i++){
            Arrays.fill(pre[i], i);
        }
    }

    //显示pre数组和dis数组
    public void show(){
        for (int k = 0; k < matrix.length; k++){
            // 显示 pre 数组
            for (int i = 0; i < matrix.length; i++){
                System.out.print(Node[pre[k][i]]+" ");
            }
            System.out.println();
            //显示 dis 数组
            for (int i = 0; i < matrix.length; i++){
                System.out.print("("+Node[k]+"到"+Node[i]+"的最短路径是"+matrix[k][i]+")");
            }
            System.out.println();
        }
    }

    public void floyd(){
        // 记录顶点的长度
        int len;
        //对中间顶点遍历， k 就是中间顶点的下标 [A, B, C, D, E, F, G]
        for (int k = 0; k < matrix.length; k++){
            //从i顶点开始出发 [A, B, C, D, E, F, G]
            for (int i = 0; i < matrix.length; i++){
                //到达j顶点 // [A, B, C, D, E, F, G]
                for (int j = 0; j < matrix.length; j++){
                    // => 求出从i 顶点出发，经过 k中间顶点，到达 j 顶点距离
                    len = matrix[i][k] + matrix[k][j];
                    if (len < matrix[i][j]){
                        //更新距离
                        matrix[i][j] = len;
                        //更新前驱顶点
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
}
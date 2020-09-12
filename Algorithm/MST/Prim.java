package com.MST;

import java.util.Arrays;

/**
 * @
 * @date 2020/9/12 - 20:44
 */
public class Prim {
    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        //创建MGraph对象
        MGraph graph = new MGraph(verxs);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        //输出
        minTree.show(graph);
        //测试普利姆算法
        minTree.Prim(graph, 0);
    }
}

//创建最小生成树->村庄的图
class MinTree{
    //编写prim算法，得到最小生成树
    /**
     *
     * @param mGraph 图
     * @param v 表示从图的第几个顶点开始生成'A'->0 'B'->1...
     */
    public void Prim(MGraph mGraph, int v){
        //visited[] 标记结点(顶点)是否被访问过
        int[] visited = new int[mGraph.verxs];
        //把当前这个结点标记为已访问
        visited[v] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;//将 minWeight 初始成一个大数，后面在遍历过程中，会被替换
        for (int k = 1; k < mGraph.verxs; k++) {//因为有 graph.verxs顶点，普利姆算法结束后，有 graph.verxs-1边
            //这个是确定每一次生成的子图 ，和哪个结点的距离最近
            for (int i = 0; i < mGraph.verxs; i++) {// i结点表示被访问过的结点
                for (int j = 0; j < mGraph.verxs; j++) {//j结点表示还没有访问过的结点
                    if (visited[i] == 1 && visited[j] == 0 && mGraph.weight[i][j] < minWeight) {
                        //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                        minWeight = mGraph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小
            System.out.println("边<" + mGraph.data[h1] + "," + mGraph.data[h2] + "> 权值:" + minWeight);
            //将当前这个结点标记为已经访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值 10000
            minWeight = 10000;
        }
    }

    /**
     * 创建图的邻接矩阵
     * @param mGraph 传入的图
     * @param verxs 图对应的顶点个数
     * @param data 图中铬顶点的值
     * @param weight 图中各个边的权重
     */
    public void createGraph(MGraph mGraph, int verxs, char[] data, int[][] weight){
        for (int i = 0; i < verxs; i++){
            mGraph.data[i] = data[i];
            for (int j = 0; j < verxs; j++){
                mGraph.weight[i][j] = weight[i][j];
            }
        }
    }

    // 显示图的邻接矩阵
    public void show(MGraph mGraph){
        for (int[] line : mGraph.weight){
            System.out.println(Arrays.toString(line));
        }
    }
}

class MGraph{
    int verxs;//表示图的节点个数
    char[] data;//存放结点数据
    int[][] weight;//存放边，就是我们的邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}

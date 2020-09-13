package com.ShortestPathProblem;

import java.util.Arrays;

/**
 * @
 * @date 2020/9/13 - 16:42
 */
public class Dijkstra {
    public static void main(String[] args) {
        char[] Node = { 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //邻接矩阵
        int[][] matrix = new int[Node.length][Node.length];
        final int N = 65535;// 表示不可以连接
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};

        Graph graph = new Graph(Node, matrix);
        graph.show();
        graph.dsj(6);
        graph.showGrapht();
    }
}

class Graph{
    private char[] Node; // 顶点数组
    private int[][] weight; // 邻接矩阵
    private VisitedNode vv; //已经访问的顶点的集合

    // 构造器
    public Graph(char[] node, int[][] weight) {
        Node = node;
        this.weight = weight;
    }

    //显示结果
    public void show(){
        for (int[] link : weight){
            System.out.println(Arrays.toString(link));
        }
    }

    // 显示图
    public void showGrapht(){
        vv.show();
    }


    /**
     *迪杰斯特拉算法实现
     * @param index 表示出发顶点对应的下标
     */
    public void dsj(int index){
        vv = new VisitedNode(Node.length, index);
        update(index);//更新index顶点到周围顶点的距离和前驱顶点
        for (int j = 1; j < Node.length; j++){
            int i = vv.updateArr();// 选择并返回新的访问顶点
            update(i);// 更新index顶点到周围顶点的距离和前驱顶点
        }
    }

    //更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点,
    private void update(int index){
        int len = 0;
        //根据遍历我们的邻接矩阵的  matrix[index]行
        for (int i = 0; i < weight[index].length; i++){
            // len 含义是 : 出发顶点到index顶点的距离 + 从index顶点到j顶点的距离的和
            len = vv.getDis(index) + weight[index][i];
            // 如果j顶点没有被访问过，并且 len 小于出发顶点到j顶点的距离，就需要更新
            if (!vv.in(i) && len < vv.getDis(i)){
                vv.updateDis(i, len);//更新j顶点的前驱为index顶点
                vv.updatePre(i, index);//更新出发顶点到j顶点的距离
            }
        }
    }
}

// 已访问顶点集合
class VisitedNode{
    // 记录各个顶点是否访问过 1表示访问过,0未访问,会动态更新
    public int[] already_arr;
    // 每个下标对应的值为前一个顶点下标, 会动态更新
    public int[] pre_visited;
    // 记录出发顶点到其他所有顶点的距离,比如G为出发顶点，就会记录G到其它顶点的距离，会动态更新，求的最短距离就会存放到dis
    public int[] dis;

    /**
     * 构造器
     * @param length 顶点的个数
     * @param index 出发顶点的下标
     */
    public VisitedNode(int length, int index){
        already_arr = new int[length];
        pre_visited = new int[length];
        dis = new int[length];

        Arrays.fill(dis, 65535);//初始化 dis数组
        this.already_arr[index] = 1;//设置出发顶点被访问过
        dis[index] = 0;//设置出发顶点的访问距离为0
    }

    /**
     * 功能: 判断index顶点是否被访问过
     * @param index
     * @return 如果访问过，就返回true, 否则访问false
     */
    public boolean in(int index){
        return already_arr[index] == 1;
    }

    /**
     * 功能: 更新出发顶点到index顶点的距离
     * @param index
     * @param len
     */
    public void updateDis(int index, int len){
        dis[index] = len;
    }

    /**
     * 功能: 更新pre这个顶点的前驱顶点为index顶点
     * @param pre 当前节点的下标
     * @param index 前驱节点的下标
     */
    public void updatePre(int pre, int index){
        pre_visited[pre] = index;
    }

    /**
     * 功能:返回出发顶点到index顶点的距离
     * @param index
     */
    public int getDis(int index) {
        return dis[index];
    }

    /**
     * 继续选择并返回新的访问顶点， 比如这里的G 完后，就是 A点作为新的访问顶点(注意不是出发顶点)
     * @return
     */
    public int updateArr(){
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++){
            if (already_arr[i] == 0 && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        //更新 index 顶点被访问过
        already_arr[index] = 1;
        return index;
    }

    //显示最后的结果
    //即将三个数组的情况输出
    public void show() {

        System.out.println("==========================");
        //输出already_arr
        for(int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出pre_visited
        for(int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出dis
        for(int i : dis) {
            System.out.print(i + " ");
        }
        System.out.println();
        //为了好看最后的最短距离，我们处理
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertex[count] + "("+i+") ");
            } else {
                System.out.println("N ");
            }
            count++;
        }
        System.out.println();

    }

}
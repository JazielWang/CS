package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 深度优化和广度优化的不同体现在对下一个临近节点的处理：
 * DFS在获得 getFirstNeighbor 后，会对这一个节点进行 DFS(isVisited, w) ，也就是会这个节点进行回溯操作，继续进行下一级查找
 * BFS在获得 getFirstNeighbor 后，会对这一个节点进行输出，之后再寻找下一个邻接节点，重复之前步骤
 * @date 2020/9/9 - 14:29
 */
public class Graph {
    private ArrayList<String> vertexList;// 用于存储顶点集合
    private int[][] edges;//存储对应的临介矩阵
    private int numOfEdges;//表示边的数目
    //定义给数组boolean[], 记录某个结点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5; //节点数目
        String[] Vertex = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String s : Vertex) {
            graph.insertVertex(s);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1); // A-B
        graph.insertEdge(0, 2, 1); //
        graph.insertEdge(1, 2, 1); //
        graph.insertEdge(1, 3, 1); //
        graph.insertEdge(1, 4, 1); //

        graph.showGraph();

        graph.DFS();
        System.out.println();
        graph.BFS();
    }

    //创建构造器
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }

    // 根据 index 获得临近顶点
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    // 根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    //i 第一次就是 0
    private void DFS(boolean[] isVisited, int i) {
        //首先我们访问该结点,输出
        System.out.print(getValueByIndex(i) + " -> ");
        //将结点设置为已经访问
        int w = getFirstNeighbor(i);
        //查找结点i的第一个邻接结点w
        isVisited[i] = true;
        while (w != -1) {//存在临近顶点
            if (!isVisited[w]) {//临近顶点没有遍历过
                DFS(isVisited, w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    //对深度优化算法进行重载，遍历我们所有的结点，并进行 dfs
    public void DFS() {
        isVisited = new boolean[vertexList.size()];
        //遍历所有的结点，进行dfs[回溯]
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                DFS(isVisited, i);
            }
        }
    }

    //对一个节点进行广度遍历算法
    private void BFS(boolean[] isVisited, int i) {
        int u;// 表示队列的头结点对应下标
        int w;// 邻接结点w
        //队列，记录结点访问的顺序
        LinkedList<Integer> queue = new LinkedList<>();
        //访问结点，输出结点信息
        System.out.print(getValueByIndex(i) + " -> ");
        //标记为已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.add(i);
        while (!queue.isEmpty()) {
            //取出队列的头结点下标
            u = queue.removeFirst();
            //得到第一个邻接结点的下标 w
            w = getFirstNeighbor(u);
            while (w != -1) {//找到
                //是否访问过
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + " -> ");
                    //标记已经访问
                    isVisited[w] = true;
                    queue.add(w);    //入队
                }
                //以u为前驱点，找w后面的下一个邻结点
                w = getNextNeighbor(u, w);//体现出我们的广度优先
            }
        }
    }

    //遍历所有的结点，都进行广度优先搜索
    public void BFS() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumofVertex(); i++) {
            if (!isVisited[i]) {
                BFS(isVisited, i);
            }
        }
    }

    //图中常用的方法
    //返回结点的个数
    public int getNumofVertex() {
        return vertexList.size();
    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeigh(int v1, int v2) {
        return edges[v1][v2];
    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     表示点的下标即使第几个顶点  "A"-"B" "A"->0 "B"->1
     * @param v2     第二个顶点对应的下标
     * @param weight v1,v2之间是否有连线
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}

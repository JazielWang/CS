package com.MST;

/**
 * @
 * @date 2020/9/13 - 11:53
 */
public class Kruskalcase {
    private int edgeNum; //边的个数
    private char[] node; //顶点数组
    private static int[][] matrix; // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int[][] matrix = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};
        //大家可以在去测试其它的邻接矩阵，结果都可以得到最小生成树.
        Kruskalcase kruskalcase = new Kruskalcase(vertexs, matrix);
        kruskalcase.show();
        kruskalcase.Krushal();
    }

    // 构建 Kruskal 算法
    public void Krushal() {
        int index = 0;//表示最后结果数组的索引
        int[] end = new int[edgeNum];//用于保存"已有最小生成树" 中的每个顶点在最小生成树中的终点
        //创建结果数组, 保存最后的最小生成树
        Edata[] mst = new Edata[edgeNum];
        //获取图中 所有的边的集合 ， 一共有12边
        Edata[] edges = getEdges();
        //按照边的权值大小进行排序(从小到大)
        sortEdges(edges);

        //遍历edges 数组，将边添加到最小生成树中时，判断是准备加入的边否形成了回路，如果没有，就加入 mst，否则不能加入
        for (int i = 0; i < edgeNum; i++) {
            //获取到第i条边的第一个顶点(起点)
            int p1 = getPosition(edges[i].start);
            //获取到第i条边的第2个顶点
            int p2 = getPosition(edges[i].end);
            //获取p1这个顶点在已有最小生成树中的终点
            int m = getEnd(end, p1);
            //获取p2这个顶点在已有最小生成树中的终点
            int n = getEnd(end, p2);
            //是否构成回路
            if (m != n){//没有构成回路
                end[m] = n;// 设置m 在"已有最小生成树"中的终点 <E,F> [0,0,0,0,5,0,0,0,0,0,0,0]
                mst[index++]=edges[i];//有一条边加入到mst数组
            }
        }
        //<E,F> <C,D> <D,E> <B,F> <E,G> <A,B>。
        //统计并打印 "最小生成树", 输出  rets
        System.out.println("最小生成树为");
        for(int i = 0; i < index; i++) {
            System.out.println(mst[i]);
        }
    }

    /**
     * 获得顶点的位置
     *
     * @param ch 传入顶点的值，比如：“A" ”B“
     * @return 返回顶点对应的坐标
     */
    private int getPosition(char ch) {
        int index = -1;
        for (int i = 0; i < node.length; i++) {
            if (node[i] == ch) {
                index = i;
            }
        }
        return index;
    }

    /**
     * 功能: 获取图中边，放到EData[] 数组中，后面我们需要遍历该数组
     * 是通过matrix 邻接矩阵来获取
     * EData[] 形式 [['A','B', 12], ['B','F',7], .....]
     *
     * @return
     */
    private Edata[] getEdges() {
        int index = 0;
        Edata[] edges = new Edata[edgeNum];
        for (int i = 0; i < node.length; i++) {
            for (int j = i + 1; j < node.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new Edata(node[i], node[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 功能：对边进行排序处理, 冒泡排序
     *
     * @param edges 边的集合
     */
    private void sortEdges(Edata[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {//交换
                    Edata tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 功能: 获取下标为i的顶点的终点(), 用于后面判断两个顶点的终点是否相同
     *
     * @param ends ： 数组就是记录了各个顶点对应的终点是哪个,ends 数组是在遍历过程中，逐步形成
     * @param i    : 表示传入的顶点对应的下标
     * @return 返回的就是 下标为i的这个顶点对应的终点的下标, 一会回头还有来理解
     */
    private int getEnd(int[] ends, int i) { // i = 4 [0,0,0,0,5,0,0,0,0,0,0,0]
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    //构造器，创建 kruskal
    public Kruskalcase(char[] vertexs, int[][] marix) {
        this.node = vertexs;
        this.matrix = marix;
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (marix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void show() {
        System.out.println("邻接矩阵是：\n");
        for (int[] line : matrix) {
            for (int i : line) {
                System.out.printf("%12d", i);
            }
            System.out.println();
        }
    }
}

// 定义一个边的类
class Edata {
    char start;
    char end;
    int weight;

    public Edata(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edata{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}

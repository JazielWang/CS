package com.Recursion;

public class Maze {
    public static void main(String[] args) {
        int[][] maze = new int[8][7];
        for (int i = 0; i < 8; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        maze[3][1] = 1;
        maze[3][2] = 1;
        for (int[] ii : maze) {
            for (int iii : ii) {
                System.out.print(iii);
            }
            System.out.println();
        }
        getWay(maze,1, 1);
        System.out.println();
        for (int[] ii : maze) {
            for (int iii : ii) {
                System.out.print(iii);
            }
            System.out.println();
        }

    }

    //使用递归回溯来给小球找路
    //说明
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发 (1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
    //4. 约定： 当map[i][j] 为 0 表示该点没有走过 当为 1 表示墙  ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
    //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯
    /**
     *
     * @param maze 表示地图
     * @param i 从哪个位置开始找
     * @param j 从哪个位置开始找
     * @return 如果找到通路，就返回 true ，否则返回 false
     */
    public static boolean getWay(int[][] maze, int i, int j) {
        if (maze[6][5] == 2) {// 通路已经找到ok
            return true;
        } else {
            if (maze[i][j] == 0) {//如果当前这个点还没有走过
                //按照策略 下->右->上->左  走
                maze[i][j] = 2;// 假定该点是可以走通.
                if (getWay(maze, i + 1, j)) {//向下走
                    return true;
                } else if (getWay(maze, i, j + 1)) {//向右走
                    return true;
                } else if (getWay(maze, i - 1, j)) {//向上
                    return true;
                } else if (getWay(maze, i, j - 1)) {// 向左走
                    return true;
                }else {
                    //说明该点是走不通，是死路
                    maze[i][j] = 3;
                    return false;
                }
            }else {// 如果map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }
}

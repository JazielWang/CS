package com.KnightandHourse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Jaziel
 */
public class Horse {
    // 棋盘的行和列
    private static int X;
    private static int Y;
    private static boolean[] visited;
    private static boolean finished;

    public static void main(String[] args) {
        System.out.println("骑士周游算法，开始运行~~");
        //测试骑士周游算法是否正确
        X = 8;
        Y = 8;
        //马儿初始位置的行，从1开始编号
        int row = 1;
        //马儿初始位置的列，从1开始编号
        int column = 1;
        //创建棋盘
        int[][] chessboard = new int[X][Y];
        //初始值都是false
        visited = new boolean[X * Y];
        //测试一下耗时
        long start = System.currentTimeMillis();
        traverslChessboard(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时: " + (end - start) + " 毫秒");

        //输出棋盘的最后情况
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 实现骑士周游问题的算法
     *
     * @param chessboard 棋盘
     * @param row        马儿当前位置的行，从 0 开始
     * @param column     马儿当前位置的列，从 0 开始
     * @param step       是第几步，初始位置是 1
     */
    public static void traverslChessboard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        //标记该位置已经访问
        visited[row * X + column] = true;
        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(column, row));
        //遍历 ps
        sort(ps);
        while (!ps.isEmpty()) {
            //取出下一个可以走的位置
            Point p = ps.remove(0);
            //判断该点是否已经访问过
            //说明还没有访问过
            if (!visited[p.y * X + p.x]) {
                traverslChessboard(chessboard, p.y, p.x, step + 1);
            }
        }
        //判断马儿是否完成了任务，使用   step 和应该走的步数比较 ，
        //如果没有达到数量，则表示没有完成任务，将整个棋盘置0
        //说明: step < X * Y  成立的情况有两种
        //1. 棋盘到目前位置,仍然没有走完
        //2. 棋盘处于一个回溯过程
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    /**
     * 功能： 根据当前位置(Point对象)，计算马儿还能走哪些位置(Point)，并放入到一个集合中(ArrayList), 最多有8个位置
     *
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        //创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<Point>();
        //创建一个Point
        Point p1 = new Point();
        //表示马儿可以走5这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走6这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走7这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走0这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走1这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走2这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走3这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走4这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    //根据当前这个一步的所有的下一步的选择位置，进行非递减排序, 减少回溯的次数
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }
}

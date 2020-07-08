/*
骑士周游算法 按照国际象棋马的走法规则，给定一个n*m的棋盘，计算出马如何把棋盘上的每一个点不重复地走一遍。
主要思想：
	1. 创建矩阵作为棋盘。
	2. 计算出当前出发节点的下一步可选集合。
	3. 使用贪心算法的思想选出下一步可走最多者。
	4. 使用递归回溯算法的思想，遍历整个棋盘走法。
*/
package cn.anydevelop.algorithm.other;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KnightTourProblem {
    private int x;
    private int y;
    private boolean[] visited;
    private boolean isFinished;

    public KnightTourProblem(int x, int y) {
        this.x = x;
        this.y = y;
        this.visited = new boolean[x * y];
    }

    /**
     * 使用递归回溯的方式遍历整个棋盘走法
     * @param chessboard
     * @param row
     * @param column
     * @param step
     */
    public void traverseChessboard(int[][] chessboard, int row, int column, int step){
        chessboard[row][column] = step;
        this.visited[this.x * row + column] = true;
        List<Point> next = this.getNext(new Point(column, row));
        this.nextSort(next);
        while (!next.isEmpty()){
            Point point = next.remove(0);
            if(!this.visited[point.y * this.x + point.x]){
                this.traverseChessboard(chessboard,point.y,point.x,step+1);
            }
        }
        if(step < this.x * this.y && !this.isFinished){
            chessboard[row][column] = 0;
            visited[this.x * row + column] = false;
        }else{
            this.isFinished = true;
        }
    }

    /**
     * 获取当前点可以跳跃的下一步点集合
     * @param current
     * @return
     */
    private List<Point> getNext(Point current){
        List<Point> next = new ArrayList<>();
        Point point = new Point();
        if((point.x = current.x-2) >= 0 && (point.y = current.y-1) >= 0){
            next.add(new Point(point));
        }
        if((point.x = current.x-1) >= 0 && (point.y = current.y-2) >= 0){
            next.add(new Point(point));
        }
        if((point.x = current.x+2) < this.x && (point.y = current.y-1) >= 0){
            next.add(new Point(point));
        }
        if((point.x = current.x+1) < this.x && (point.y = current.y-2) >= 0){
            next.add(new Point(point));
        }
        if((point.x = current.x-2) >= 0 && (point.y = current.y+1) < this.y){
            next.add(new Point(point));
        }
        if((point.x = current.x-1) >= 0 && (point.y = current.y+2) < this.y){
            next.add(new Point(point));
        }
        if((point.x = current.x+1) < this.x && (point.y = current.y+2) < this.y){
            next.add(new Point(point));
        }
        if((point.x = current.x+2) < this.x && (point.y = current.y+1) < this.y){
            next.add(new Point(point));
        }
        return next;
    }

    /**
     * 对下一步可以跳跃的点进行排序
     * @param points
     */
    private void nextSort(List<Point> points){
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return getNext(o1).size() - getNext(o2).size();
            }
        });
    }
}

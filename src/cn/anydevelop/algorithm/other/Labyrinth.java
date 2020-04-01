/*
迷宫：使用矩阵来模拟迷宫地图，0为路，1为墙，2为已走过。设置起始点和终点。
主要思想：
	1. 使用递归的方法来探索迷宫出路。
	2. 判断终点是否为2或者全部遍历为结束条件。
	3. 当前的策略为下、右、左、上的顺序。
*/
package cn.anydevelop.algorithm.other;

public class Labyrinth {
    // 打印迷宫
    public void printLabyrinth(int[][] labyrinth){
        for (int i = 0; i < labyrinth.length; i++){
            for (int j = 0; j < labyrinth[i].length; j++){
                System.out.print(labyrinth[i][j]+" ");
            }
            System.out.println();
        }
    }

    // 探测迷宫出路
    public boolean detectRoad(int[][] labyrinth,int currentRow,int currentColumn,int endRow,int endColumn){
        if(labyrinth[endRow][endColumn] == 2){
            return true;
        }
        // 当前的策略为下、右、左、上的顺序
        if(labyrinth[currentRow][currentColumn] == 0){
            labyrinth[currentRow][currentColumn] = 2;
            if(this.detectRoad(labyrinth,currentRow+1,currentColumn,endRow,endColumn)){
                return true;
            }else if(this.detectRoad(labyrinth,currentRow,currentColumn+1,endRow,endColumn)){
                return true;
            }else if(this.detectRoad(labyrinth,currentRow,currentColumn-1,endRow,endColumn)){
                return true;
            }else if(this.detectRoad(labyrinth,currentRow-1,currentColumn,endRow,endColumn)){
                return true;
            }else{
                labyrinth[currentRow][currentColumn] = 3;
            }
        }
        return false;
    }
}
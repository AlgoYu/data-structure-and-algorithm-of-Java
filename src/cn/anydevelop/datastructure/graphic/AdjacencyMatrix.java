/*
邻接矩阵：玲姐矩阵是图结构的一种表示方式。
主要思想：
	1. 在创建的时候初始化矩阵大小。
	2. 矩阵纵向横向表示的节点顺序与增加的顺序一样。
	3. 使用0表示无连接，使用1表示连接。
*/
package cn.anydevelop.datastructure.graphic;

import java.util.ArrayList;
import java.util.Arrays;

public class AdjacencyMatrix {
    private int edgeSize;
    private ArrayList<String> nodes;
    private int[][] matrix;

    // 构造方法
    public AdjacencyMatrix(int size) {
        this.matrix = new int[size][size];
        this.nodes = new ArrayList<>();
        this.edgeSize = 0;
    }

    // 返回节点个数
    public int getNodeSize(){
        return this.nodes.size();
    }

    // 返回边数
    public int getEdgeSize(){
        return this.edgeSize;
    }

    // 插入节点
    public void addNode(String node){
        this.nodes.add(node);
    }

    // 获取节点
    public String getNode(int index){
        return this.nodes.get(index);
    }

    // 获取值
    public int getValue(int row,int column){
        return this.matrix[row][column];
    }

    // 增加边
    public void addEdge(int row, int column, int value){
        this.matrix[row][column] = value;
        this.matrix[column][row] = value;
        this.edgeSize++;
    }

    // 打印图
    public void printGraphic(){
        for (int[] array:this.matrix){
            System.out.println(Arrays.toString(array));
        }
    }
}

/*
邻接矩阵：玲姐矩阵是图结构的一种表示方式。
主要思想：
	1. 在创建的时候初始化矩阵大小。
	2. 矩阵纵向横向表示的节点顺序与增加的顺序一样。
	3. 使用0表示无连接，使用1表示连接。
*/
package cn.machine.geek.datastructure.graphic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class AdjacencyMatrix {
    private int edgeSize;
    private ArrayList<String> nodes;
    private int[][] matrix;
    private boolean[] visit;

    /**
     * 初始化邻接矩阵
     *
     * @param size
     */
    public AdjacencyMatrix(int size) {
        this.matrix = new int[size][size];
        this.nodes = new ArrayList<>();
        this.edgeSize = 0;
        this.visit = new boolean[size];
    }

    /**
     * 获取节点数量
     *
     * @return
     */
    public int getNodeSize() {
        return this.nodes.size();
    }

    /**
     * 获取边的数量
     *
     * @return
     */
    public int getEdgeSize() {
        return this.edgeSize;
    }

    /**
     * 增加节点
     *
     * @param node
     */
    public void addNode(String node) {
        this.nodes.add(node);
    }

    /**
     * 获取节点
     *
     * @param index
     * @return
     */
    public String getNode(int index) {
        return this.nodes.get(index);
    }

    /**
     * 获取值
     *
     * @param row
     * @param column
     * @return
     */
    public int getValue(int row, int column) {
        return this.matrix[row][column];
    }

    /**
     * 增加边
     *
     * @param row
     * @param column
     * @param value
     */
    public void addEdge(int row, int column, int value) {
        this.matrix[row][column] = value;
        this.matrix[column][row] = value;
        this.edgeSize++;
    }

    /**
     * 打印图
     */
    public void printGraphic() {
        for (int[] array : this.matrix) {
            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * 深度优先遍历
     *
     * @param row
     */
    public void depthFirstTraversal(int row) {
        System.out.print(this.nodes.get(row) + "=>");
        this.visit[row] = true;
        for (int column = 0; column < this.matrix[row].length; column++) {
            if (this.matrix[row][column] != 0 && !this.visit[column]) {
                this.depthFirstTraversal(column);
            }
        }
    }

    /**
     * 深度优先全遍历
     */
    public void dFS() {
        for (int i = 0; i < this.nodes.size(); i++) {
            if (!this.visit[i]) {
                this.depthFirstTraversal(i);
            }
        }
    }

    /**
     * 清除访问
     */
    public void cleanVisit() {
        for (int i = 0; i < this.visit.length; i++) {
            this.visit[i] = false;
        }
    }

    /**
     * 广度优先遍历
     */
    public void breadthFirstTraversal(int row) {
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(this.nodes.get(row) + "=>");
        this.visit[row] = true;
        queue.add(row);
        while (!queue.isEmpty()) {
            row = queue.pop();
            for (int column = 0; column < this.matrix[row].length; column++) {
                if (this.matrix[row][column] != 0 && !this.visit[column]) {
                    System.out.print(this.nodes.get(column) + "=>");
                    this.visit[column] = true;
                    queue.add(column);
                }
            }
        }
    }

    /**
     * 广度优先全遍历
     */
    public void bFS() {
        for (int i = 0; i < this.nodes.size(); i++) {
            if (!this.visit[i]) {
                this.breadthFirstTraversal(i);
            }
        }
    }
}
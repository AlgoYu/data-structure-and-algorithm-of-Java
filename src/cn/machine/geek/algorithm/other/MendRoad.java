/*
修路问题：给定一组无相连通图，要求以最少的权值连接所有的节点。
主要思想：
	1. 使用Prim算法，选择一个节点出发。
	2. 把当前节点添加到已连通节点中。
	3. 遍历已连通节点的所有邻接节点，把还未被连通且权值最小的一个加入连通节点。
	4. 循环以上步骤直至所有节点连通。
*/
package cn.machine.geek.algorithm.other;

import java.util.Arrays;

public class MendRoad {
    public class RGraph{
        private int size;
        private int[][] matrix;
        private char[] nodes;

        public RGraph(int size) {
            this.size = size;
            this.matrix = new int[size][size];
            this.nodes = new char[size];
        }

        /**
         * 打印图
         */
        public void printGraph(){
            for (int i = 0; i < this.matrix.length; i++){
                System.out.println(Arrays.toString(this.matrix[i]));
            }
        }
    }

    /**
     * 创建图
     * @param size
     * @param nodes
     * @param matrix
     */
    public RGraph createGraph(int size,char[] nodes,int[][] matrix){
        RGraph rGraph = new RGraph(size);
        rGraph.size = size;
        for (int i = 0; i < size; i++){
            rGraph.nodes[i] = nodes[i];
            for (int j = 0; j < size; j++){
                rGraph.matrix[i][j] = matrix[i][j];
            }
        }
        return rGraph;
    }

    /**
     * prim
     * @param graph
     * @param node
     */
    public void prim(RGraph graph, int node){
        int[] visited = new int[graph.size];
        visited[node] = 1;
        int minValue = 10000;
        int n1 = 0;
        int n2 = 0;
        for(int i = 1; i < graph.size; i++){
            for (int j = 0; j < graph.size; j++){
                for (int k = 0; k < graph.size; k++){
                    if(visited[j] == 1 && visited[k] == 0 && graph.matrix[j][k] < minValue){
                        minValue = graph.matrix[j][k];
                        n1 = j;
                        n2 = k;
                    }
                }
            }
            System.out.println(graph.nodes[n1]+" to "+graph.nodes[n2]);
            visited[n2] = 1;
            minValue = 10000;
        }
    }
}
/*
公交站问题：给定一组无相连通图，要求以最少的权值连接所有的节点。
主要思想：
	1. 使用Kruskal算法。
	2. 扫描出所有的连接。
	3. 把连接按权值从小到大排序。
	4. 遍历连接，把与已选择的连接不构成回路的连接加入连通。
*/
package cn.anydevelop.algorithm.other;

import java.util.Arrays;

public class BusStation {
    public class BGraph{
        private int connect;
        private char[] nodes;
        private int[][] matrix;
        public final int NOT_CONNECT = Integer.MAX_VALUE;

        public BGraph(int size) {
            this.connect = 0;
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

        /**
         * 获取节点下标
         * @param node
         * @return
         */
        public int getNodeIndex(char node){
            for(int i = 0; i < this.nodes.length; i++){
                if(this.nodes[i] == node){
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * 连接信息
     */
    public class CData{
        private char start;
        private char end;
        private int weight;

        public CData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    /**
     * kruskal
     * @param bGraph
     */
    public void kruskal(BGraph bGraph){
        int index = 0;
        int[] ends = new int[bGraph.connect];
        CData[] result = new CData[bGraph.connect];
        CData[] connects = this.getCDatas(bGraph);
        this.sortCData(connects);
        for (int i = 0; i < bGraph.connect; i++){
            int n1 = bGraph.getNodeIndex(connects[i].start);
            int n2 = bGraph.getNodeIndex(connects[i].end);

            int m = this.getEnd(ends,n1);
            int n = this.getEnd(ends,n2);
            if(m!=n){
                ends[m] = n;
                result[index] = connects[i];
                index++;
            }
        }
        for (int i = 0; i < index; i++){
            System.out.println("<"+result[i].start+","+result[i].end+">,weight="+result[i].weight);
        }
    }

    /**
     * 获取边的信息
     * @return
     */
    public CData[] getCDatas(BGraph bGraph){
        CData[] cDatas = new CData[bGraph.connect];
        int index = 0;
        for (int i = 0; i < bGraph.matrix.length; i++){
            for (int j = i+1; j < bGraph.matrix[i].length; j++){
                if(bGraph.matrix[i][j] > 0 && bGraph.matrix[i][j]!=Integer.MAX_VALUE){
                    CData cData = new CData(bGraph.nodes[i],bGraph.nodes[j],bGraph.matrix[i][j]);
                    cDatas[index] = cData;
                    index++;
                }
            }
        }
        return cDatas;
    }

    /**
     * 创建图结构
     * @param nodes
     * @param matrix
     */
    public BGraph createGraph(char[] nodes,int[][] matrix){
        BGraph bGraph = new BGraph(nodes.length);
        for (int i = 0; i < nodes.length; i++){
            bGraph.nodes[i] = nodes[i];
            for (int j = 0; j < nodes.length; j++){
                bGraph.matrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < nodes.length; i++){
            for (int j = i+1; j < nodes.length; j++){
                if(matrix[i][j]>0 && matrix[i][j]!=bGraph.NOT_CONNECT){
                    bGraph.connect++;
                }
            }
        }
        return bGraph;
    }

    /**
     * 获取下标为i的节点的终点
     * @param ends
     * @param i
     * @return
     */
    private int getEnd(int[] ends,int i){
        while (ends[i] != 0){
            i = ends[i];
        }
        return i;
    }

    /**
     * 连接信息排序
     * @param array
     */
    private void sortCData(CData[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length-i-1; j++){
                if(array[j].weight > array[j+1].weight){
                    CData temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
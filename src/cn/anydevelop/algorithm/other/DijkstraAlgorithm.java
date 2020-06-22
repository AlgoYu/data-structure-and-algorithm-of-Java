/*
Dijkstra算法：给定一组无相连通图，求出从出发节点到全部节点的最短路径。
主要思想：
	1. 创建一个结构体来保存出发节点所有可连接节点的连接距离，所有节点的访问情况，以及计算过程中的前置节点。
	2. 扫描一个距离最短未被访问节点，设置它已被访问，计算该节点所有的连接距离并加上从出发节点到该节点的距离，如果小于已有的连接距离，则更新保存的路径距离。
	3. 反复以上步骤，直至所有节点被访问。
*/
package cn.anydevelop.algorithm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DijkstraAlgorithm {
    public class DijkstraGraph{
        private char[] nodes;
        private int[][] matrix;

        public DijkstraGraph(char[] nodes, int[][] matrix) {
            this.nodes = nodes;
            this.matrix = matrix;
        }

        public void printGraph(){
            for (int i = 0; i < this.nodes.length; i++){
                System.out.println(Arrays.toString(this.matrix[i]));
            }
        }

        public char[] getNodes() {
            return nodes;
        }

        public void setNodes(char[] nodes) {
            this.nodes = nodes;
        }

        public int[][] getMatrix() {
            return matrix;
        }

        public void setMatrix(int[][] matrix) {
            this.matrix = matrix;
        }
    }
    public class VisitedNode{
        private int[] visit;
        private int[] pre;
        private int[] dis;

        public VisitedNode(int length,int index) {
            this.visit = new int[length];
            this.pre = new int[length];
            this.dis = new int[length];
            Arrays.fill(this.dis,65535);
            this.visit[index] = 1;
            this.dis[index] = 0;
        }

        public boolean isVisited(int index){
            return this.visit[index] == 1;
        }

        public void updateDis(int index,int length){
            this.dis[index] = length;
        }

        public void updatePre(int current,int pre){
            this.pre[current] = pre;
        }

        public int getDistance(int index){
            return this.dis[index];
        }

        public int[] getVisit() {
            return visit;
        }

        public void setVisit(int[] visit) {
            this.visit = visit;
        }

        public int[] getPre() {
            return pre;
        }

        public void setPre(int[] pre) {
            this.pre = pre;
        }

        public int[] getDis() {
            return dis;
        }

        public void setDis(int[] dis) {
            this.dis = dis;
        }
    }

    /**
     * Dijkstra算法
     * @param graph
     * @param index
     * @return
     */
    public List<String> dijkstra(DijkstraGraph graph, int index){
        List<String> minPath = new ArrayList<>();
        VisitedNode visitedNode = new VisitedNode(graph.getNodes().length,index);
        this.update(graph,visitedNode,index);
        for (int i = 1; i < graph.getNodes().length; i++){
            int next = this.updateArray(visitedNode);
            this.update(graph,visitedNode,next);
        }
        int min = 65535;
        int end = index;
        for(int i = 0; i < visitedNode.getDis().length; i++){
            if(i != index && visitedNode.isVisited(i) && visitedNode.getDistance(i) < min){
                min = visitedNode.getDistance(i);
                end = i;
            }
        }
        while (end!=index){
            minPath.add("<"+graph.getNodes()[end]+","+visitedNode.getDistance(end)+">");
            end = visitedNode.getPre()[end];
        }
        Collections.reverse(minPath);
        return minPath;
    }

    /**
     * 扫描目标节点中还未访问的连接节点的路径距离并加上从出发节点到当前节点路径距离，更新前置节点和路径。
     * @param graph
     * @param visitedNode
     * @param index
     */
    public void update(DijkstraGraph graph,VisitedNode visitedNode,int index){
        int length;
        for (int i = 0; i < graph.getMatrix()[index].length; i++){
            length = visitedNode.getDistance(index) + graph.getMatrix()[index][i];
            if(!visitedNode.isVisited(i) && length < visitedNode.getDistance(i)){
                visitedNode.updatePre(i,index);
                visitedNode.updateDis(i,length);
            }
        }
    }

    /**
     * 扫描下一个可连通未被访问且距离最短的节点
     * @param visitedNode
     * @return
     */
    public int updateArray(VisitedNode visitedNode){
        int min = 65535, index = 0;
        for (int i = 0; i < visitedNode.getVisit().length; i++){
            if(!visitedNode.isVisited(i) && visitedNode.getDistance(i) < min){
                min = visitedNode.getDistance(i);
                index = i;
            }
        }
        visitedNode.getVisit()[index] = 1;
        return index;
    }
}
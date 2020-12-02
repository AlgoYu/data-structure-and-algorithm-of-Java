/*
Floyd算法：给定一组强连通图，使用Floyd算法求出各个节点到其余节点的最短路径。
主要思想：
	1. 创建一个结构体，保存节点名称，节点距离，节点前驱节点。
	2. 创建3个指针，分别为：中间节点指针、出发节点指针、目标节点指针。
	3. 三层循环遍历把每个节点当做一次中间指针、算出节点为中间指针时，累加出发节点到中间节点的距离，中间节点到目标节点的距离。
	4. 如果这个距离比已存在的距离小，则更新。
*/
package cn.machine.geek.algorithm.other;

import java.util.Arrays;

public class FloydAlgorithm {
    private char[] nodes;
    private int[][] dis;
    private int[][] pre;

    public FloydAlgorithm(char[] nodes, int[][] dis) {
        this.nodes = nodes;
        this.dis = dis;
        this.pre = new int[nodes.length][nodes.length];
        for (int i = 0; i < this.pre.length; i++){
            Arrays.fill(this.pre[i],i);
        }
    }

    /**
     * 打印图
     */
    public void printGraph(){
        for (int i = 0; i < this.dis.length; i++){
            System.out.println(Arrays.toString(this.dis[i]));
        }
        System.out.println();
        for (int i = 0; i < this.pre.length; i++){
            System.out.println(Arrays.toString(this.pre[i]));
        }
    }

    /**
     * 使用三个指针遍历数组，考虑每一个节点作为中间节点时候，更新各个节点的最短距离。
     */
    public void floyd(){
        int len = 0;
        for (int k = 0; k < this.dis.length; k++){
            for (int j = 0; j < this.dis.length; j++){
                for (int i = 0; i < this.dis.length; i++){
                    len = this.dis[j][k] + this.dis[k][i];
                    if(len < this.dis[j][i]){
                        this.dis[j][i] = len;
                        this.dis[i][j] = len;
                        this.pre[j][i] = k;
                        this.pre[i][j] = k;
                    }
                }
            }
        }
    }
}

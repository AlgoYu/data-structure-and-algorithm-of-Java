/*
线性查找：递增比较每一个元素，把正确的元素下标返回。
主要思想：
	1. 递增比较每一个元素。
	2. 找到返回下标。
	3. 没找到返回负数。
*/
package cn.anydevelop.algorithm.search;

public class SeqSearch {
    // 线性查找
    public int seqSearch(int[] data,int value){
        for (int i = 0; i<data.length; i++){
            if(data[i] == value){
                return i;
            }
        }
        return -1;
    }
}

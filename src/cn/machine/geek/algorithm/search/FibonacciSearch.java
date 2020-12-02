/*
斐波那契查找：斐波那契查找是一种搜索算法，利用数学中的黄金分割法以及斐波那契序列来搜索查找值的下标。
主要思想：
	1. 先获取一个斐波那契数列。
	2. 使用数据长度从斐波那契数列中获取分割值下标。
	3. 填充数据以避免分割值越界。
	4. 计算出黄金分割点判断数值再次分割。
*/
package cn.machine.geek.algorithm.search;

import java.util.Arrays;

public class FibonacciSearch {
    // 得到斐波那契数列
    public int[] getFibonacciSequence(int size){
        int[] fibonacciSequence = new int[size];
        fibonacciSequence[0] = 1;
        fibonacciSequence[1] = 1;
        for (int i = 2; i < size; i++){
            fibonacciSequence[i] = fibonacciSequence[i-1] + fibonacciSequence[i-2];
        }
        return fibonacciSequence;
    }
    // 斐波那契查找
    public int fibonacciSearch(int[] array,int value){
        int low = 0;
        int high = array.length-1;
        // 黄金分割点
        int k = 0;
        // 获取斐波那契数列
        int[] fibonacciSequence = getFibonacciSequence(array.length);
        // 获取黄金分割点
        while (high > fibonacciSequence[k]-1){
            k++;
        }
        // 避免值越界
        int[] temp = Arrays.copyOf(array,fibonacciSequence[k]);
        // 以最后一个数值填充新的空间
        for (int i = array.length; i < temp.length; i++){
            temp[i] = temp[i-1];
        }
        // 使用黄金分割点查找数值
        int middle = 0;
        while (high >= low){
            middle = low + fibonacciSequence[k-1] - 1;
            if (value > temp[middle]){
                low = middle + 1;
                k -= 2;
            }else if(value < temp[middle]){
                high = middle - 1;
                k--;
            }else{
                if(high >= middle){
                    return middle;
                }else{
                    return high;
                }
            }
        }
        return -1;
    }
}

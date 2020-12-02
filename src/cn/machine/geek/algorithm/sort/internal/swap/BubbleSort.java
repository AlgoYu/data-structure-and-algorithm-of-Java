/*
冒泡排序：冒泡排序属于交换类排序的一种，每次按排序规则交换相邻的元素位置，最终使其有序。
主要思想：
	1. 使用指针指向第一个元素，逐步递增。
	2. 指针每次比较当前值和下一个位置的值，按排序规则判断是否交换位置。
	3. 每一趟把一个最终元素推到最后。
	4. 每一趟减少遍历的个数。
*/
package cn.machine.geek.algorithm.sort.internal.swap;

public class BubbleSort {
    // 冒泡排序
    public int[] bubbleSort(int[] array){
        int temp;
        for (int i = 0; i < array.length-1; i++){
            for (int j = 0; j < array.length -1 -i; j++){
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    // 冒泡排序优化
    public int[] bubbleSortOptimize(int[] array){
        int temp;
        // 增加一个布尔值
        boolean existSwap = false;
        for (int i = 0; i < array.length-1; i++){
            for (int j = 0; j < array.length -1 -i; j++){
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    existSwap = true;
                }
            }
            // 如果一趟排序没有进行一次交换则退出循环
            if(!existSwap){
                break;
            }
            existSwap = false;
        }
        return array;
    }
}

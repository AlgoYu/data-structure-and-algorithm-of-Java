/*
希尔排序：希尔排序属于插入类排序的一种，先把元素分组，然后分组比较按排序规则排序，最终使其有序。
主要思想：
	1. 先把需要排序的元素分组。
	2. 按排序规则把分组内的元素进行比较，按排序规则处理顺序。
	3. 每一次都会排序好所有分组。
	4. 每一趟都会细分分组。
*/
package cn.machine.geek.algorithm.sort.internal.insertion;

public class ShellSort {
    // 希尔交换排序
    public int[] shellSwapSort(int[] array){
        int temp;
        for (int half = array.length/2; half > 0; half /= 2){
            for (int i = half; i < array.length; i++){
                for (int j = i -half; j >= 0; j -= half){
                    if(array[j] > array[j+half]){
                        temp = array[j];
                        array[j] = array[j+half];
                        array[j+half] = temp;
                    }
                }
            }
        }
        return array;
    }
    // 希尔移位排序
    public int[] shellMoveSort(int[] array){
        int temp,index;
        for (int half = array.length/2; half > 0; half /= 2){
            for (int i = half; i < array.length; i++){
                index = i - half;
                temp = array[i];
                while (index >= 0 && temp < array[index]){
                    array[index+half] = array[index];
                    index-=half;
                }
                array[index+half] = temp;
            }
        }
        return array;
    }
}
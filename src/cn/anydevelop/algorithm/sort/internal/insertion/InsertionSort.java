/*
插入排序：插入排序属于插入类排序的一种，逐步比较当前元素和前面的元素，按排序规则找到合适的位置插入，最终使其有序。
主要思想：
	1. 使用临时变量保存第二个元素和下标，逐步递增。
	2. 临时变量与前面的元素逐步递减比较，不符合排序规则即把元素往后移，按排序规则找到一个合适的位置。
	3. 把最终元素插入位置。
	4. 每一趟都会插入一个最终元素。
*/
package cn.anydevelop.algorithm.sort.internal.insertion;

public class InsertionSort {
    // 插入排序
    public int[] insertionSort(int[] array){
        int index,temp;
        for (int i = 1; i < array.length; i++){
            index = i-1;
            temp = array[i];
            while (index >= 0 && temp < array[index]){
                array[index+1] = array[index];
                index--;
            }
            array[index+1] = temp;
        }
        return array;
    }
}

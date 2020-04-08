/*
归并排序：归并排序属于合并类排序的一种，采用分治的思想，把数据拆分为个体，然后按排序规则进行逐个合并，最终使其有序。
主要思想：
	1. 使用递归的方式不断把元素拆分。
	2. 合并左右两边的数据。
	3. 创建一个相同长度的临时变量保存合并的数据。
	4. 把临时变量保存的数据拷贝回原始变量。
*/
package cn.anydevelop.algorithm.sort.internal.merge;

public class MergeSort {
    // 归并排序
    public void mergeSort(int[] array,int left,int right,int[] temp){
        if(left < right){
            int middle = (left+right)/2;
            // 向左递归
            mergeSort(array,left,middle,temp);
            // 向右递归
            mergeSort(array,middle+1,right,temp);
            // 合并
            merge(array,left,middle,right,temp);
        }
    }
    // 合并方法
    public void merge(int[] array,int left,int middle,int right,int[] temp){
        // 初始化左右序列的指针下标
        int l = left;
        int r = middle+1;
        int index = 0;
        // 按排序规则合并
        while (l <= middle && r <= right){
            if(array[l]>array[r]){
                temp[index] = array[r];
                r++;
            }else{
                temp[index] = array[l];
                l++;
            }
            index++;
        }
        // 如果左边还有剩余则填充
        while (l <= middle){
            temp[index] = array[l];
            l++;
            index++;
        }
        // 如果右边还有剩余则填充
        while (r <= right){
            temp[index] = array[r];
            r++;
            index++;
        }
        // 把所有数据拷贝回去
        index = 0;
        while (left <= right){
            array[left] = temp[index];
            left++;
            index++;
        }
    }
}
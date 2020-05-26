/*
二分查找：二分查找是一种搜索算法，前提是数据已经有序，每次比较中间的数来判断往左查找还是往右查找，找到则返回元素下标。
主要思想：
	1. 计算出中间数值的下标。
	2. 如果中间值等于要查找的元素则返回。
	3. 如果中间值不等于，则判断大小来选择往左查找还是右查找。
	4. 重复以上步骤直到找到，找不到则返回负数下标。
*/
package cn.anydevelop.algorithm.search;

public class BinarySearch {
    // 二分查找
    public int binarySearch(int[] array,int value,int left,int right){
        if(left <= right){
            int middle = (left + right)/2;
            if(array[middle] > value){
                return this.binarySearch(array,value,left,middle-1);
            }else if(array[middle] < value){
                return this.binarySearch(array,value,middle+1,right);
            }else{
                return middle;
            }
        }
        return -1;
    }
    // 二分查找非递归实现
    public int binarySearch(int[] array,int target){
        int left = 0;
        int right = array.length-1;
        int middle;
        while (left <= right){
            middle = (left+right)/2;
            if(array[middle]==target){
                return middle;
            }else if(array[middle]>target){
                right = middle-1;
            }else{
                left = middle+1;
            }
        }
        return -1;
    }
}
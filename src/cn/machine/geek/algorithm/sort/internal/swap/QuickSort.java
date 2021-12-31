/*
快速排序：快速排序属于交换类排序的一种，它的思想是选择一个基数，把数据分为两份，一边比基数大，一边比基数小，再分别进行排序，最终使其有序。
主要思想：
	1. 选择一个基数。
	2. 创建两个指针，一个指向左边，一个指向右边。
	3. 两个指针往中间一直逼近，每次按排序规则与基数比较，选择一个数，交换元素。
	4. 对两边进行重复步骤。
*/
package cn.machine.geek.algorithm.sort.internal.swap;

public class QuickSort {
    // 快速排序
    public void quickSort(int[] array, int left, int right) {
        int l = left;
        int r = right;
        // 选择中间值作为基数
        int base = array[(left + right) / 2];
        int temp;
        while (l < r) {
            // 从左往右寻找大于等于基数的值
            while (l <= right && array[l] < base) {
                l++;
            }
            // 从右往左寻找小于等于基数的值
            while (r >= left && array[r] > base) {
                r--;
            }
            // 如果左指针大于等于右指针则退出
            if (l >= r) {
                break;
            }
            // 交换数据
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            // 避免交换的数据与基数相同而造成死循环
            if (array[l] == base) {
                l++;
            }
            if (array[r] == base) {
                r--;
            }
        }
        // 避免交换位置相等重复递归造成的栈溢出
        if (l == r) {
            l++;
            r--;
        }
        // 向左递归
        if (left < r) {
            this.quickSort(array, left, r);
        }
        // 向右递归
        if (right > l) {
            this.quickSort(array, l, right);
        }
    }
}
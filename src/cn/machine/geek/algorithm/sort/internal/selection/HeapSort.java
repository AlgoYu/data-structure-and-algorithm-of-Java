/*
堆排序：堆排序属于选择类排序的一种，使用堆这个数据结构的特性，反复选择子节点与父节点比较，交换，最终使其有序。
主要思想：
	1. 先把数组依据排序规则转换为一个最大（最小）堆。
	2. 把根节点换替换到后面的位置。
	3. 重复以上的步骤。
*/
package cn.machine.geek.algorithm.sort.internal.selection;

public class HeapSort {
    // 转换为最大堆
    public void convertToMaxHeap(int[] array, int index, int length) {
        int temp = array[index];
        for (int i = 2 * index + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length && array[i] < array[i + 1]) {
                i++;
            }
            if (array[i] > temp) {
                array[index] = array[i];
                index = i;
            } else {
                break;
            }
        }
        array[index] = temp;
    }

    // 转换为最小堆
    public void convertToMinHeap(int[] array, int index, int length) {
        int temp = array[index];
        for (int i = 2 * index + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length && array[i] > array[i + 1]) {
                i++;
            }
            if (array[i] < temp) {
                array[index] = array[i];
                index = i;
            } else {
                break;
            }
        }
        array[index] = temp;
    }

    // 堆排序
    public int[] heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            this.convertToMaxHeap(array, i, array.length);
        }
        int temp;
        for (int i = array.length - 1; i > 0; i--) {
            temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            this.convertToMaxHeap(array, 0, i);
        }
        return array;
    }
}
/*
基数排序：基数排序属于基数类排序的一种，以空间换时间的思想，创建多个数组作为桶，把需要排序的数据按低位到高位取出放入相应的桶中再按桶从小到大取出放回，最终使其有序。
主要思想：
	1. 创建多个数组作为捅，创建桶计数器。
	2. 取出每个数据按低位到高位递增，并放入相应的桶中。
	3. 按排序规则从桶中取出元素，放回原始变量。
	4. 反复以上步骤完成排序。
*/
package cn.machine.geek.algorithm.sort.internal.radix;

public class RadixSort {
    // 基数排序
    public int[] radixSort(int[] array){
        // 获取最大数位数
        int max = array[0];
        for (int i = 1; i < array.length; i++){
            if (max < array[i]){
                max = array[i];
            }
        }
        max = (max+"").length();
        // 初始化桶和其他计数
        int[][] barrel = new int[10][array.length];
        int[] count = new int[10];
        int divisor = 1;
        int index;
        int time = 0;
        while (time <= max){
            // 按位取出比较存入相应的捅
            for (int i = 0; i < array.length; i++){
                index = array[i] / divisor % 10;
                barrel[index][count[index]] = array[i];
                count[index]++;
            }
            divisor *= 10;
            // 取出桶数据放回原始变量中
            index = 0;
            for (int i = 0; i < count.length; i++){
                for (int j = 0; j < count[i]; j++){
                    array[index] = barrel[i][j];
                    index++;
                }
                // 计数清零
                count[i] = 0;
            }
            time++;
        }
        return array;
    }
}

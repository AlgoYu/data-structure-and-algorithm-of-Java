package cn.anydevelop.algorithm.interview;

public class AlphanumericSort {
    /**
     * 把数据按数字，字符排序，数字优先。
     * @param array 需要排序的数据
     */
    public static void alphanumericSort(String[] array){
        quickSort(array,0,array.length-1);
        insertSort(array);
    }

    /**
     * 使用插入排序把相同序号的字符进行排序
     * @param array 需要排序的数据
     */
    private static void insertSort(String[] array){
        String temp;
        int index;
        for (int i = 1; i < array.length; i++){
            index = i-1;
            temp = array[i];
            while (index >=0 && Integer.parseInt(array[index].substring(1))==Integer.parseInt(temp.substring(1)) && array[index].charAt(0)>temp.charAt(0)){
                array[index+1] = array[index];
                index--;
            }
            array[index+1] = temp;
        }
    }

    /**
     * 快速排序（只针对数字）
     * @param array 需要排序的数据
     * @param left 数组最左边的指针
     * @param right 数组最右边的指针
     */
    private static void quickSort(String[] array, int left, int right){
        int l = left;
        int r = right;
        int middle = (left+right)/2;
        int radix = Integer.parseInt(array[middle].substring(1));
        String temp;
        while (l < r){
            while (l <= right && Integer.parseInt(array[l].substring(1)) < radix){
                l++;
            }
            while (r >= left && Integer.parseInt(array[r].substring(1)) > radix){
                r--;
            }
            if(l >= r){
                break;
            }
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            if(Integer.parseInt(array[l].substring(1)) == radix){
                l++;
            }
            if(Integer.parseInt(array[r].substring(1)) == radix){
                r--;
            }
        }
        if(l == r){
            l++;
            r--;
        }
        if(left < r){
            quickSort(array,left,r);
        }
        if(right > l){
            quickSort(array,l,right);
        }
    }
}

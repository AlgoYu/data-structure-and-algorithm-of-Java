/*
递归：递归是一种算法思想，函数直接或间接调用函数本身，则该函数称为递归函数。
主要思想：
	1. 函数直接或间接调用函数本身。
	2. 函数每次调用都必须向退出递归的条件趋近。
*/
package cn.machine.geek.algorithm.other;

public class Recursive {
    // 阶乘，计算一个非负整数内所有数的乘积。
    public static long factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    // 顺序打印一个非负整数内的所有数。
    public static void printAllNumOf(int num) {
        if (num > 1) {
            printAllNumOf(num - 1);
        }
        System.out.println(num);
    }
}
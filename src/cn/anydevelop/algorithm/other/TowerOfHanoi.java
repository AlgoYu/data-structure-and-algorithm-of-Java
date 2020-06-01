/*
汉诺塔算法：汉诺塔是3根石柱，圆盘按大小顺序摆放在石柱上，每次只能移动一个圆盘，每次移动必须按大小顺序摆放。
主要思想：
	1. 使用分治算法的思想，将一个难以直接解决的大问题，分割成一些规模较小的相同且独立的子问题，以便各个击破，分而治之。
	2. 完成汉诺塔只有三步：A=>B,A=C,B=C。
	3. 使用递归完成推算。
*/
package cn.anydevelop.algorithm.other;

public class TowerOfHanoi {
    public static void towerOfHanoi(int num, char a, char b, char c){
        if(num==1){
            System.out.println(num+" "+a+" to "+c);
        }else{
            TowerOfHanoi.towerOfHanoi(num-1,a,c,b);
            System.out.println(num+" "+a+" to "+c);
            TowerOfHanoi.towerOfHanoi(num-1,b,a,c);
        }
    }
}

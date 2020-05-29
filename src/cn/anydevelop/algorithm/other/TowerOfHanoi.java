/*
汉诺塔算法：汉诺塔是3根石柱，圆盘按大小顺序摆放在石柱上，每次只能移动一个圆盘，每次移动必须按大小顺序摆放。
主要思想：
	1. 使用分治算法的思想，把问题拆解成一个规模足够小的子问题。
	2. 三步：A=>B,A=C,B=C。
	3. 使用递归完成推算。
*/
package cn.anydevelop.algorithm.other;

public class TowerOfHanoi {
    public void towerOfHanoi(int num,char a,char b,char c){
        if(num==1){
            System.out.println(num+" "+a+" to "+c);
        }else{
            this.towerOfHanoi(num-1,a,c,b);
            System.out.println(num+" "+a+" to "+c);
            this.towerOfHanoi(num-1,b,a,c);
        }
    }
}

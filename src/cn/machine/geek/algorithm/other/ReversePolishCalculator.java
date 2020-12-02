/*
后缀（逆波兰）表达式计算器：输入后缀表达式，计算出结果。
主要思想：
	1. 创建一个数字栈。
	2. 扫描输入的字符串，把数字推入数字栈。
	3. 如果是操作符即数字栈中取出两个值进行计算并把结果推入数字栈。
	4. 最后的数字栈中的结果便是表达式结果。
*/
package cn.machine.geek.algorithm.other;

import cn.machine.geek.datastructure.linear.ArrayStack;

public class ReversePolishCalculator {
    private ArrayStack nums;

    public ReversePolishCalculator() {
        nums = new ArrayStack(20);
    }

    // 计算并返回结果
    public int calculateReversePolishExpression(String expression){
        // 以空格分割
        String[] values = expression.split(" ");
        // 遍历数组判断是操作符还是数值
        for(int i = 0; i < values.length; i++){
            // 数值入栈
            if(values[i].matches("\\d+")){
                this.nums.push(Integer.parseInt(values[i]));
            }else{
                // 如果是操作符即从数值栈中取出两个值进行计算并推回数值栈
                int num1 = this.nums.pop();
                int num2 = this.nums.pop();
                this.nums.push(this.calculate(num1,num2,values[i]));
            }
        }
        // 返回结果
        return nums.pop();
    }

    // 计算数值
    public int calculate(int num1,int num2,String operate){
        // 加法和乘法的顺序不影响计算结果，但是减法和除法的顺序会影响计算结果。
        if(operate.equals("+")){
            return num1+num2;
        }else if(operate.equals("-")){
            return num2-num1;
        }else if(operate.equals("*")){
            return num1*num2;
        }else if(operate.equals("/")){
            return num2/num1;
        }
        throw new RuntimeException("Operation mismatch.");
    }
}

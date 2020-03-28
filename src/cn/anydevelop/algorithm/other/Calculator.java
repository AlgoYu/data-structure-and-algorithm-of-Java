/*
计算器：输入一串无括号的表达式，计算出结果。
主要思想：
	1. 创建一个计算符栈和数字栈。
	2. 扫描输入的字符串，把数字推入数字栈，把计算符推入计算符栈。
	3. 推入计算符的时候判断当前计算符与栈中计算符的优先级来处理
	4. 如果栈中的优先级等于或者大于当前的优先级，先从数字栈中取出两个值进行计算并把结果推入数字栈，否则直接把计算符推入计算符栈。
	5. 最后的数字栈中的结果便是表达式结果。
*/
package cn.anydevelop.algorithm.other;

import cn.anydevelop.datastructure.linear.ArrayStack;

public class Calculator {
    private ArrayStack nums;
    private ArrayStack operators;

    public Calculator() {
        nums = new ArrayStack(20);
        operators = new ArrayStack(20);
    }

    // 计算并返回结果
    public int calculateExpression(String expression){
        // 扫描字符串存入相应的栈中
        char[] chars = expression.toCharArray();
        char temp;
        for (int i = 0; i < chars.length; i++){
            temp = chars[i];
            // 判断是数值还是操作符
            if(this.isOperator(temp)){
                // 如果栈中操作符等于或者大于当前操作符即从数值栈中取出两个值进行计算并推回数值栈
                if(!this.operators.isEmpty() && this.getPriority(temp)<=this.getPriority(this.operators.peek())){
                    int num1 = this.nums.pop();
                    int num2 = this.nums.pop();
                    int operator = this.operators.pop();
                    this.nums.push((this.calculate(num1, num2, operator)));
                }
                this.operators.push(temp);
            }else{
                this.nums.push(temp-48);
            }
        }
        // 反复取出操作符栈和数值栈的数据并计算
        while (!this.operators.isEmpty()){
            int num1 = this.nums.pop();
            int num2 = this.nums.pop();
            int operator = this.operators.pop();
            this.nums.push((this.calculate(num1, num2, operator)));
        }
        return this.nums.pop();
    }

    // 判断是否为操作符
    public boolean isOperator(int value){
        return value == '+' || value == '-' || value == '*' || value == '/';
    }

    // 获取优先级
    public int getPriority(int operator){
        switch (operator){
            case '*':
            case '/':
                return 1;
            case '+':
            case '-':
                return 0;
            default:
                return -1;
        }
    }

    // 计算数值
    public int calculate(int num1,int num2,int operate){
        // 加法和乘法的顺序不影响计算结果，但是减法和除法的顺序会影响计算结果。
        switch (operate){
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
            default:
                return 0;
        }
    }
}

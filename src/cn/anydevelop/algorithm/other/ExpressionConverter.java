/*
表达式转换器：输入带括号中缀表达式，转换为后缀表达式。
主要思想：
	1. 创建两个栈。
	2. 把字符推入操作符栈，把数字推入数值栈。
	3. 左括号直接入操作符栈，右括号取出操作符栈左括号前所有操作符压入数值栈，若是操作符比较操作符栈中的优先级，优先级大于直接压入操作符栈，优先级小于操作符栈中的优先级则先取出操作符栈的操作符推入数值栈再把当前操作符推入操作符栈。
	4. 把所有操作符栈取出并压入数值栈。
	5. 头拼取出所有数值栈。
*/
package cn.anydevelop.algorithm.other;

import cn.anydevelop.datastructure.linear.ArrayStack;

public class ExpressionConverter {
    private ArrayStack st1;
    private ArrayStack st2;

    public ExpressionConverter() {
        st1 = new ArrayStack(30);
        st2 = new ArrayStack(30);
    }

    // 转换表达式
    public String conversionExpression(String expression){
        String suffixExpression = "";
        String[] values = expression.split(" ");
        // 遍历数组
        for (int i = 0; i < values.length; i++){
            // 判断是否为操作符
            if (this.isOperator(values[i])){
                // 左括号直接推入st1
                if(values[i].equals("(")){
                    this.st1.push(values[i].charAt(0));
                    // 右括号则一直取出st1的直到左括号为止的所有字符推入st2
                }else if(values[i].equals(")")){
                    while (!this.st1.isEmpty()&&this.st1.peek()!='('){
                        this.st2.push(this.st1.pop());
                    }
                    this.st1.pop();
                    // 操作符小于st1中的优先级则先取出st1的操作符推入st2再把当前操作符推入st1
                }else if(!this.st1.isEmpty() && this.getPriority(values[i]) <= this.getPriority((char)this.st1.peek()+"")){
                    this.st2.push(this.st1.pop());
                    this.st1.push(values[i].charAt(0));
                }else{
                    this.st1.push(values[i].charAt(0));
                }
            }else{
                this.st2.push(Integer.parseInt(values[i]));
            }
        }
        while (!this.st1.isEmpty()){
            this.st2.push(this.st1.pop());
        }
        while (!this.st2.isEmpty()){
            int value = this.st2.pop();
            if(this.isOperator((char)value+"")){
                suffixExpression=(char)value+" "+suffixExpression;
            }else{
                suffixExpression=value+" "+suffixExpression;
            }
        }
        return suffixExpression;
    }

    // 判断是否为操作符
    public boolean isOperator(String value){
        return value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/") || value.equals("(") || value.equals(")");
    }

    // 获取操作符优先级
    public int getPriority(String operator){
        if(operator.equals("*")||operator.equals("/")){
            return 1;
        }else if(operator.equals("+")||operator.equals("-")){
            return 0;
        }
        return -1;
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

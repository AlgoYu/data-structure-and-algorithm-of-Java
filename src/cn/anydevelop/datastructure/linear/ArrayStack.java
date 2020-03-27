/*
栈：栈是一种先入后出的数据结构。
主要思想：
	1. 创建一个数组当做栈空间。
	2. 创建一个指针指向栈的顶部。
	3. 使用指针完成栈的入栈出栈操作。
*/
package cn.anydevelop.datastructure.linear;

import java.util.Scanner;

public class ArrayStack {
    private int[] stack;
    private int size;
    private int top;

    // 在构造函数中初始化栈
    public ArrayStack(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    // 判断栈是否已满
    public boolean isFull(){
        return this.top >= this.size-1;
    }

    // 判断栈是否为空
    public boolean isEmpty(){
        return this.top == -1;
    }

    // 入栈
    public void push(int data){
        if(this.isFull()){
            System.out.println("Stack is full.");
            return;
        }
        this.top++;
        this.stack[this.top] = data;
    }

    // 出栈
    public int pop(){
        if(this.isEmpty()){
            throw new RuntimeException("Stack is empty.");
        }
        int data = this.stack[this.top];
        this.top--;
        return data;
    }

    // 打印栈
    public void printStack(){
        if(this.isEmpty()){
            System.out.println("Stack is empty.");
            return;
        }
        for (int i = this.top; i >= 0; i--){
            System.out.print(this.stack[i]+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayStack arrayStack = new ArrayStack(5);
        boolean loop = true;
        while (loop){
            System.out.println("输入1为打印栈");
            System.out.println("输入2为数据入栈");
            System.out.println("输入3为数据出栈");
            System.out.println("输入4为退出");
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    arrayStack.printStack();
                    break;
                case 2:
                    arrayStack.push(scanner.nextInt());
                    break;
                case 3:
                    System.out.println(arrayStack.pop());
                    break;
                case 4:
                    loop = false;
            }
        }
    }
}
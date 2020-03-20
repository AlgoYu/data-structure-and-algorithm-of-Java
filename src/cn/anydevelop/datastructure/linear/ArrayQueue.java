/*
队列：队列是一个先进先出的数据结构，大部分情况下用来模拟排队的情况。
主要思想：
	1. 创建一个数组作为队列。
	2. 使用front作为前指针，使用tail最为尾指针。
	3. 前、尾指针保存的是队列的下标。
	4. 通过前、尾指针判断队列是否为空、满、增加数据、删除数据。
*/
package cn.anydevelop.datastructure.linear;

import java.util.Scanner;

public class ArrayQueue {
    // 队列
    private int[] queue;
    // 队列大小
    private int size;
    // 前指针
    private int front;
    // 尾指针
    private int tail;

    // 构造函数初始化队列
    public ArrayQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = this.tail = -1;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return this.front == this.tail;
    }

    // 判断队列是否已满
    public boolean isFull(){
        return this.tail+1 == this.size;
    }

    // 加入数据到队列
    public void addQueue(int data){
        if(this.isFull()){
            throw new RuntimeException("Can't add queue because queue is full");
        }
        this.queue[++this.tail] = data;
    }

    // 离开队列
    public int outQueue(){
        if(this.isEmpty()){
            throw new RuntimeException("Can't add queue because queue is full");
        }
        return this.queue[++this.front];
    }

    //打印队列
    public void printQueue(){
        for (int value : this.queue){
            System.out.print(value+" ");
        }
        System.out.println();
    }

    public void printCurrentQueueHead(){
        if(this.isEmpty()){
            System.out.println("当前无数据");
        }else{
            System.out.println(this.queue[this.front+1]);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayQueue arrayQueue = new ArrayQueue(5);
        boolean loop = true;
        while (loop){
            System.out.println("输入1为打印队列");
            System.out.println("输入2为加入数据");
            System.out.println("输入3为取出数据");
            System.out.println("输入4为显示当前队列头部");
            System.out.println("输入5为退出");
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    arrayQueue.printQueue();
                    break;
                case 2:
                    arrayQueue.addQueue(scanner.nextInt());
                    break;
                case 3:
                    System.out.println(arrayQueue.outQueue());
                    break;
                case 4:
                    arrayQueue.printCurrentQueueHead();
                    break;
                case 5:
                    loop = false;
            }
        }
    }
}
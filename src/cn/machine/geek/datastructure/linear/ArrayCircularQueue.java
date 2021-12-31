/*
环形队列：环形队列是一个先进先出的数据结构，修复了队列空间重用的问题。
主要思想：
	1. 创建一个数组作为队列。
	2. 使用front作为前指针，使用tail最为尾指针。
	3. 前、尾指针保存的是队列的下标。
	4. 通过前、尾指针判断队列是否为空、满、增加数据、删除数据。
	5. 通过取余算法重置前、尾指针指向的下标。
*/
package cn.machine.geek.datastructure.linear;

public class ArrayCircularQueue {
    // 队列
    private int[] queue;
    // 队列大小
    private int size;
    // 前指针
    private int front;
    // 尾指针
    private int tail;

    // 构造函数初始化队列
    public ArrayCircularQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = this.tail = 0;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return this.front == this.tail;
    }

    // 判断队列是否已满
    public boolean isFull() {
        return (this.tail + 1) % this.size == this.front;
    }

    // 数据加入队列尾部
    public void addQueue(int data) {
        if (this.isFull()) {
            System.out.println("Can't add queue because queue is full");
            return;
        }
        this.queue[this.tail] = data;
        this.tail = (this.tail + 1) % this.size;
    }

    // 队列头部数据出队列
    public int outQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Can't add queue because queue is full");
        }
        int data = this.queue[this.front];
        this.front = (this.front + 1) % this.size;
        return data;
    }

    // 得到当前队列长度
    public int getCurrentQueueLength() {
        return (this.tail + this.size - this.front) % this.size;
    }

    // 打印队列
    public void printQueue() {
        if (this.isEmpty()) {
            System.out.println("Current have not data");
            return;
        }
        for (int i = this.front; i < this.front + getCurrentQueueLength(); i++) {
            System.out.print(this.queue[i % this.size] + " ");
        }
        System.out.println();
    }

    // 打印当前队列头部
    public void printCurrentQueueHead() {
        if (this.isEmpty()) {
            System.out.println("Current have not data");
        } else {
            System.out.println(this.queue[this.front]);
        }
    }
}

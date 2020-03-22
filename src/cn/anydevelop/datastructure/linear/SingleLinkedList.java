/*
链表：链表是类似数组的一种数据结构，但链表在内存空间中非连续存储的数据结构，它通过指针来寻找下一个节点。
主要思想：
	1. 创建一个数据结构，有数据域和指针域。
	2. 数据域用来存储数据，指针域用来指向下一个数据。
	3. 使用指针域指向下一个数据节点，通过指针完成链表的增、删、改、查。
*/
package cn.anydevelop.datastructure.linear;

import java.util.Random;
import java.util.Scanner;

// 链表结点
class SingleLinkedListNode{
    private int id;
    private int data;
    private SingleLinkedListNode next;

    public SingleLinkedListNode(int id, int data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SingleLinkedListNode getNext() {
        return next;
    }

    public void setNext(SingleLinkedListNode next) {
        this.next = next;
    }
}

public class SingleLinkedList {
    private int length;
    private SingleLinkedListNode next;

    // 在构造函数中初始化链表
    public SingleLinkedList() {
        // 初始化长度为0
        this.length = 0;
        // 初始化一个空节点
        this.next = new SingleLinkedListNode(0,0);
    }

    // 增加节点
    public void addNode(SingleLinkedListNode node){
        // 判断是否已经存在
        if(this.getNode(node.getId())!=null){
            System.out.println("The node already exists");
            return;
        }
        // 创建指针并指定到第一个空节点
        SingleLinkedListNode temp = this.next;
        // 找到链表最后一个节点
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        // 增加节点
        temp.setNext(node);
        this.length++;
    }

    // 增加有序节点
    public void addOrderNode(SingleLinkedListNode node){
        // 判断是否已经存在
        if(this.getNode(node.getId())!=null){
            System.out.println("The node already exists");
            return;
        }
        // 创建指针并指定到第一个空节点
        SingleLinkedListNode temp = this.next;
        // 在链表中找到比当前需要插入的节点ID小的节点
        while (temp.getNext() != null && temp.getNext().getId() < node.getId()){
            temp = temp.getNext();
        }
        // 插入节点
        node.setNext(temp.getNext());
        temp.setNext(node);
        this.length++;
    }

    // 删除节点
    public void deleteNode(int id){
        // 创建指针
        SingleLinkedListNode temp = this.next;
        // 反复指向下一个非空且值不正确的节点
        while (temp.getNext()!=null && temp.getNext().getId()!=id){
            temp = temp.getNext();
        }
        // 判断下一个节点是否为空
        if(temp.getNext()!=null){
            temp.setNext(temp.getNext().getNext());
            this.length--;
        }
    }

    // 修改节点
    public void modifyNode(SingleLinkedListNode node){
        // 创建指针
        SingleLinkedListNode temp = this.next;
        // 反复指向下一个非空且值不正确的节点
        while (temp.getNext()!=null && temp.getNext().getId()!=node.getId()){
            temp = temp.getNext();
        }
        // 判断下一个节点是否为空
        if(temp.getNext()!=null){
            // 这里可以替换整个节点也可以只赋值
            node.setNext(temp.getNext().getNext());
            temp.setNext(node);
        }
    }

    // 得到节点
    public SingleLinkedListNode getNode(int id){
        // 创建指针
        SingleLinkedListNode temp = this.next;
        // 反复指向下一个非空且值不正确的节点
        while (temp.getNext()!=null && temp.getNext().getId()!=id){
            temp = temp.getNext();
        }
        return temp.getNext();
    }

    // 得到链表长度
    public int getLength() {
        return length;
    }

    // 打印链表
    public void printLinkedList(){
        // 判断链表是否为空
        if(this.length <= 0){
            System.out.println("LinkedList is empty!");
            return;
        }
        // 创建指针并指定到第一个空节点
        SingleLinkedListNode temp = this.next;
        // 指针反复指向下一个非空节点并打印
        while (temp.getNext() != null){
            temp = temp.getNext();
            System.out.print("["+temp.getId()+"]="+temp.getData()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        boolean loop = true;
        while (loop){
            System.out.println("输入1为打印链表");
            System.out.println("输入2为加入链表节点");
            System.out.println("输入3为加入链表有序节点");
            System.out.println("输入4为删除链表节点");
            System.out.println("输入5为修改链表节点");
            System.out.println("输入6为查找节点");
            System.out.println("输入7为打印链表长度");
            System.out.println("输入8为退出");
            int input = scanner.nextInt();
            Random random = new Random();
            switch (input){
                case 1:
                    singleLinkedList.printLinkedList();
                    break;
                case 2:
                    singleLinkedList.addNode(new SingleLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 3:
                    singleLinkedList.addOrderNode(new SingleLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 4:
                    singleLinkedList.deleteNode(scanner.nextInt());
                    break;
                case 5:
                    singleLinkedList.modifyNode(new SingleLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 6:
                    int id = scanner.nextInt();
                    SingleLinkedListNode node = singleLinkedList.getNode(id);
                    System.out.println(node==null?"没有找到这个节点":"id="+node.getId()+" data="+node.getData());
                    break;
                case 7:
                    System.out.println(singleLinkedList.getLength());
                    break;
                case 8:
                    loop = false;
            }
        }
    }
}
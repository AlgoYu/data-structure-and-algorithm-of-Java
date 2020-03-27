/*
循环链表：循环链表是链表的最后一个数据节点的指针指向第一个节点的闭环数据结构
主要思想：
	1. 创建一个数据结构，有数据域和指针域。
	2. 数据域用来存储数据，指针域用来指向下一个数据。
	3. 使用指针域的前后指针完成链表的增、删、改、查。
	4. 最后一个数据节点的指针指向第一个数据节点。
*/
package cn.anydevelop.datastructure.linear;

import java.util.Random;
import java.util.Scanner;

class CircularLinkedListNode{
    private int id;
    private int data;
    private CircularLinkedListNode next;

    public CircularLinkedListNode(int id, int data) {
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

    public CircularLinkedListNode getNext() {
        return next;
    }

    public void setNext(CircularLinkedListNode next) {
        this.next = next;
    }
}

public class CircularLinkedList {
    private int length;
    private CircularLinkedListNode next;

    // 初始化链表
    public CircularLinkedList() {
        this.length = 0;
        this.next = new CircularLinkedListNode(0,0);
        this.next.setNext(this.next);
    }

    // 得到长度
    public int getLength() {
        return length;
    }

    // 增加加点
    public void addNode(CircularLinkedListNode node){
        if(this.getNode(node.getId())!=null){
            System.out.println("The node already exists");
            return;
        }
        CircularLinkedListNode temp = this.next;
        while (temp.getNext()!=this.next){
            temp = temp.getNext();
        }
        node.setNext(this.next);
        temp.setNext(node);
        this.length++;
    }

    // 增加顺序节点
    public void addOrderNode(CircularLinkedListNode node){
        if(this.getNode(node.getId())!=null){
            System.out.println("The node already exists");
            return;
        }
        CircularLinkedListNode temp = this.next;
        while (temp.getNext()!=this.next && temp.getNext().getId() < node.getId()){
            temp = temp.getNext();
        }
        node.setNext(temp.getNext());
        temp.setNext(node);
        this.length++;
    }

    // 删除节点
    public void deleteNode(int id){
        CircularLinkedListNode temp = this.next;
        while (temp.getNext()!=this.next && temp.getNext().getId() != id){
            temp = temp.getNext();
        }
        if(temp.getNext() != this.next){
            temp.setNext(temp.getNext().getNext());
            this.length--;
        }
    }

    // 修改节点
    public void modifyNode(CircularLinkedListNode node){
        CircularLinkedListNode temp = this.next;
        while (temp.getNext()!=this.next && temp.getNext().getId() != node.getId()){
            temp = temp.getNext();
        }
        if(temp.getNext() != this.next){
            // 这里可以只赋值也可以替换整个节点
            node.setNext(temp.getNext().getNext());
            temp.setNext(node);
        }
    }

    // 查找节点
    public CircularLinkedListNode getNode(int id){
        CircularLinkedListNode temp = this.next;
        while (temp.getNext()!=this.next && temp.getNext().getId() != id){
            temp = temp.getNext();
        }
        if(temp.getNext() != this.next){
            return temp.getNext();
        }
        return null;
    }

    // 打印链表
    public void printLinkedList(){
        if(this.length == 0){
            System.out.println("LinkedList is empty!");
            return;
        }
        CircularLinkedListNode temp = this.next;
        while (temp.getNext()!=this.next){
            temp = temp.getNext();
            System.out.print("["+temp.getId()+"]="+temp.getData()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList twoWayLinkedList = new CircularLinkedList();
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
                    twoWayLinkedList.printLinkedList();
                    break;
                case 2:
                    twoWayLinkedList.addNode(new CircularLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 3:
                    twoWayLinkedList.addOrderNode(new CircularLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 4:
                    twoWayLinkedList.deleteNode(scanner.nextInt());
                    break;
                case 5:
                    twoWayLinkedList.modifyNode(new CircularLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 6:
                    int id = scanner.nextInt();
                    CircularLinkedListNode node = twoWayLinkedList.getNode(id);
                    System.out.println(node==null?"没有找到这个节点":"id="+node.getId()+" data="+node.getData());
                    break;
                case 7:
                    System.out.println(twoWayLinkedList.getLength());
                    break;
                case 8:
                    loop = false;
            }
        }
    }
}
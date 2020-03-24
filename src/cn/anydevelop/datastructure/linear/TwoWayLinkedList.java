/*
双向链表：双向链表在单链表的基础上为每个结点增加了指向前一个结点的指针。
主要思想：
	1. 创建一个数据结构，有数据域和指针域。
	2. 数据域用来存储数据，指针域有两个，分别用来指向前一个数据和下一个数据。
	3. 使用指针域的前后指针完成链表的增、删、改、查。
*/
package cn.anydevelop.datastructure.linear;

import java.util.Random;
import java.util.Scanner;

// 链表结点
class TwoWayLinkedListNode{
    private int id;
    private int data;
    private TwoWayLinkedListNode pre;
    private TwoWayLinkedListNode next;

    public TwoWayLinkedListNode(int id, int data) {
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

    public TwoWayLinkedListNode getPre() {
        return pre;
    }

    public void setPre(TwoWayLinkedListNode pre) {
        this.pre = pre;
    }

    public TwoWayLinkedListNode getNext() {
        return next;
    }

    public void setNext(TwoWayLinkedListNode next) {
        this.next = next;
    }
}

public class TwoWayLinkedList {
    private int length;
    private TwoWayLinkedListNode next;

    // 在构造中初始化指针
    public TwoWayLinkedList() {
        this.length = 0;
        this.next = new TwoWayLinkedListNode(0,0);
    }

    // 获取链表长度
    public int getLength() {
        return length;
    }

    // 增加节点
    public void addNode(TwoWayLinkedListNode node){
        if(this.getNode(node.getId())!=null){
            System.out.println("The node already exists");
            return;
        }
        TwoWayLinkedListNode temp = this.next;
        while (temp.getNext()!=null){
            temp = temp.getNext();
        }
        node.setPre(temp);
        temp.setNext(node);
        this.length++;
    }

    // 增加有序节点
    public void addOrderNode(TwoWayLinkedListNode node){
        if(this.getNode(node.getId())!=null){
            System.out.println("The node already exists");
            return;
        }
        TwoWayLinkedListNode temp = this.next;
        while (temp.getNext()!=null && temp.getNext().getId() < node.getId()){
            temp = temp.getNext();
        }
        if(temp.getNext()!=null){
            temp.getNext().setPre(node);
        }
        node.setNext(temp.getNext());
        node.setPre(temp);
        temp.setNext(node);
        this.length++;
    }

    // 删除节点
    public void deleteNode(int id){
        TwoWayLinkedListNode node = this.getNode(id);
        if(node!=null){
            if(node.getNext()!=null){
                node.getNext().setPre(node.getPre());
            }
            node.getPre().setNext(node.getNext());
            this.length--;
        }
    }

    // 修改节点
    public void modifyNode(TwoWayLinkedListNode node){
        TwoWayLinkedListNode valueNode = this.getNode(node.getId());
        if(valueNode!=null){
            // 这里可以简单的复制也可以直接替换
            node.setPre(valueNode.getPre());
            node.setNext(valueNode.getNext());
            node.getPre().setNext(node);
            if(node.getNext()!=null){
                node.getNext().setPre(node);
            }
        }
    }

    // 查找节点
    public TwoWayLinkedListNode getNode(int id){
        TwoWayLinkedListNode temp = this.next;
        while (temp.getNext()!=null && temp.getNext().getId() != id){
            temp = temp.getNext();
        }
        return temp.getNext();
    }

    // 遍历打印节点
    public void printLinkedList(){
        // 判断链表是否为空
        if(this.length <= 0){
            System.out.println("LinkedList is empty!");
            return;
        }
        TwoWayLinkedListNode temp = this.next;
        while (temp.getNext()!=null){
            temp = temp.getNext();
            System.out.print("["+temp.getId()+"]="+temp.getData()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        TwoWayLinkedList twoWayLinkedList = new TwoWayLinkedList();
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
                    twoWayLinkedList.addNode(new TwoWayLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 3:
                    twoWayLinkedList.addOrderNode(new TwoWayLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 4:
                    twoWayLinkedList.deleteNode(scanner.nextInt());
                    break;
                case 5:
                    twoWayLinkedList.modifyNode(new TwoWayLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 6:
                    int id = scanner.nextInt();
                    TwoWayLinkedListNode node = twoWayLinkedList.getNode(id);
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

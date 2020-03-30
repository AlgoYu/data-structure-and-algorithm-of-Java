package cn.anydevelop;

import cn.anydevelop.algorithm.other.Calculator;
import cn.anydevelop.algorithm.other.ExpressionConverter;
import cn.anydevelop.algorithm.other.Josephus;
import cn.anydevelop.algorithm.other.ReversePolishCalculator;
import cn.anydevelop.datastructure.linear.*;

import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // 稀疏矩阵测试
        //sparseMatrixTest();
        // 队列测试
        //arrayQueueTest();
        // 环形队列测试
        //arrayCircularQueueTest();
        // 单链表测试
        //singleLinkedListTest();
        // 双向链表测试
        //twoWayLinkedListTest();
        // 循环链表测试
        //circularLinkedListTest();
        // 约瑟夫环测试
        //josephusTest();
        // 栈测试
        //arrayStackTest();
        // 中缀表达式计算器测试
        //calculatorTest();
        // 后缀（逆波兰）表达式计算器测试
        //reversePolishCalculatorTest();
        // 中缀表达式转后缀表达式
        expressionConverterTest();
    }

    // 稀疏矩阵测试
    public static void sparseMatrixTest(){
        int[][] sourceMatrix = new int[10][10];
        sourceMatrix[3][4] = 3;
        sourceMatrix[2][5] = 5;
        sourceMatrix[8][9] = 10;
        System.out.println("打印原始矩阵");
        SparseMatrix.printMatrix(sourceMatrix);
        int[][] sparseMatrix = SparseMatrix.convertToSparseMatrix(sourceMatrix);
        System.out.println("打印稀疏矩阵");
        SparseMatrix.printMatrix(sparseMatrix);
        System.out.println("打印从稀疏矩阵中恢复的原始矩阵");
        SparseMatrix.printMatrix(SparseMatrix.restoreMatrixFromSparseMatrix(sparseMatrix));
    }

    // 队列测试
    public static void arrayQueueTest(){
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

    // 环形队列测试
    public static void arrayCircularQueueTest(){
        Scanner scanner = new Scanner(System.in);
        ArrayCircularQueue arrayCircularQueue = new ArrayCircularQueue(5);
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
                    arrayCircularQueue.printQueue();
                    break;
                case 2:
                    arrayCircularQueue.addQueue(scanner.nextInt());
                    break;
                case 3:
                    System.out.println(arrayCircularQueue.outQueue());
                    break;
                case 4:
                    arrayCircularQueue.printCurrentQueueHead();
                    break;
                case 5:
                    loop = false;
            }
        }
    }

    // 单链表测试
    public static void singleLinkedListTest(){
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
                    singleLinkedList.addNode(singleLinkedList.new SingleLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 3:
                    singleLinkedList.addOrderNode(singleLinkedList.new SingleLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 4:
                    singleLinkedList.deleteNode(scanner.nextInt());
                    break;
                case 5:
                    singleLinkedList.modifyNode(singleLinkedList.new SingleLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 6:
                    int id = scanner.nextInt();
                    SingleLinkedList.SingleLinkedListNode node = singleLinkedList.getNode(id);
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

    // 双向链表测试
    public static void twoWayLinkedListTest(){
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
                    twoWayLinkedList.addNode(twoWayLinkedList.new TwoWayLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 3:
                    twoWayLinkedList.addOrderNode(twoWayLinkedList.new TwoWayLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 4:
                    twoWayLinkedList.deleteNode(scanner.nextInt());
                    break;
                case 5:
                    twoWayLinkedList.modifyNode(twoWayLinkedList.new TwoWayLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 6:
                    int id = scanner.nextInt();
                    TwoWayLinkedList.TwoWayLinkedListNode node = twoWayLinkedList.getNode(id);
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

    // 循环链表测试
    public static void circularLinkedListTest(){
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
                    twoWayLinkedList.addNode(twoWayLinkedList.new CircularLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 3:
                    twoWayLinkedList.addOrderNode(twoWayLinkedList.new CircularLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 4:
                    twoWayLinkedList.deleteNode(scanner.nextInt());
                    break;
                case 5:
                    twoWayLinkedList.modifyNode(twoWayLinkedList.new CircularLinkedListNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 6:
                    int id = scanner.nextInt();
                    CircularLinkedList.CircularLinkedListNode node = twoWayLinkedList.getNode(id);
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

    // 约瑟夫环测试
    public static void josephusTest(){
        Scanner scanner = new Scanner(System.in);
        Josephus josephusCircular = new Josephus();
        boolean loop = true;
        while (loop){
            System.out.println("输入1为打印链表");
            System.out.println("输入2为加入链表节点");
            System.out.println("输入3为打印约瑟夫圆形");
            System.out.println("输入4为退出");
            int input = scanner.nextInt();
            Random random = new Random();
            switch (input){
                case 1:
                    josephusCircular.printLinkedList();
                    break;
                case 2:
                    josephusCircular.addNode(josephusCircular.new People(scanner.nextInt(),random.nextInt()));
                    break;
                case 3:
                    josephusCircular.printJosephusCircular(scanner.nextInt(),scanner.nextInt());
                case 4:
                    loop = false;
            }
        }
    }

    // 栈测试
    public static void arrayStackTest(){
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

    // 中缀表达式计算器测试
    public static void calculatorTest(){
        System.out.println(new Calculator().calculateExpression("3+5-2*4/4"));
    }

    // 后缀（逆波兰）表达式计算器测试
    public static void reversePolishCalculatorTest(){
        System.out.println(new ReversePolishCalculator().calculateReversePolishExpression("72 2 - 2 / 5 / 2 *"));
    }

    // 中缀表达式转后缀表达式
    public static void expressionConverterTest(){
        // 1 + ( ( 2 + 3 ) * 4 ) - 5
        System.out.println(new ExpressionConverter().conversionExpression("3 + 3 * ( 4 + 1 ) / 10"));
    }
}
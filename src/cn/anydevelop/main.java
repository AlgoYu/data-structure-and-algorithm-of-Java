package cn.anydevelop;

import cn.anydevelop.algorithm.other.*;
import cn.anydevelop.algorithm.search.BinarySearch;
import cn.anydevelop.algorithm.search.FibonacciSearch;
import cn.anydevelop.algorithm.search.InterpolationSearch;
import cn.anydevelop.algorithm.search.SeqSearch;
import cn.anydevelop.algorithm.sort.internal.insertion.InsertionSort;
import cn.anydevelop.algorithm.sort.internal.insertion.ShellSort;
import cn.anydevelop.algorithm.sort.internal.merge.MergeSort;
import cn.anydevelop.algorithm.sort.internal.radix.RadixSort;
import cn.anydevelop.algorithm.sort.internal.selection.HeapSort;
import cn.anydevelop.algorithm.sort.internal.selection.SelectionSort;
import cn.anydevelop.algorithm.sort.internal.swap.BubbleSort;
import cn.anydevelop.algorithm.sort.internal.swap.QuickSort;
import cn.anydevelop.datastructure.linear.*;
import cn.anydevelop.datastructure.tree.ArrayBinaryTree;
import cn.anydevelop.datastructure.tree.BinaryTree;
import cn.anydevelop.datastructure.tree.HuffmanTree;
import cn.anydevelop.datastructure.tree.ThreadedBinaryTree;

import java.util.Arrays;
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
        //expressionConverterTest();
        // 阶乘和打印测试
        //recursiveTest();
        // 迷宫测试
        //labyrinthTest();
        // 八皇后测试
        //eightQueensTest();
        // 冒泡排序测试
        //bubbleSortTest();
        // 选择排序测试
        //selectionSortTest();
        // 插入排序测试
        //insertionSortTest();
        // 希尔排序测试
        //shellSortTest();
        // 快速排序测试
        //quickSortTest();
        // 归并排序测试
        //mergeSortTest();
        // 基数排序测试
        //radixSortTest();
        // 堆排序测试
        //heapSortTest();
        // 顺序查找测试
        //seqSearchTest();
        // 二分查找测试
        //binarySearchTest();
        // 插值查找测试
        //interpolationSearchTest();
        // 斐波那契查找测试
        //fibonacciSearchTest();
        // 散列表测试
        //hashTableTest();
        // 二叉树前中后序遍历测试
        //binaryTreeTraversalTest();
        // 二叉树前中后序搜索测试
        //binaryTreeSearchTest();
        // 二叉树删除测试
        //binaryTreeDeleteTest();
        // 顺序二叉树遍历测试
        //arrayBinaryTreeTraversalTest();
        // 线索化二叉树测试
        //threadedBinaryTreeTest();
        // 线索化二叉树遍历测试
        //threadedBinaryTreeTraversalTest();
        // 哈弗曼树测试
        huffmanTreeTest();
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

    // 阶乘和打印测试
    public static void recursiveTest(){
        System.out.println(Recursive.factorial(15));
        Recursive.printAllNumOf(15);
    }

    // 迷宫测试
    public static void labyrinthTest(){
        int[][] map = new int[8][9];
        Labyrinth labyrinth = new Labyrinth();
        for (int i = 0; i < map[0].length; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < map.length;i++){
            map[i][0] = 1;
            map[i][8] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;
        map[3][4] = 1;
        /*map[3][5] = 1;
        map[3][6] = 1;
        map[3][7] = 1;*/
        System.out.println("走迷宫前：");
        labyrinth.printLabyrinth(map);
        System.out.println("走迷宫后：");
        if(labyrinth.detectRoad(map,1,1,6,7)){
            labyrinth.printLabyrinth(map);
        }else{
            labyrinth.printLabyrinth(map);
            System.out.println("迷宫是死路!");
        }
    }

    // 八皇后测试
    public static void eightQueensTest(){
        new EightQueen(8,8).putQueen(0);
    }

    // 冒泡排序测试
    public static void bubbleSortTest(){
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*500);
        }
        BubbleSort bubbleSort = new BubbleSort();
        /*System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("冒泡排序后：");
        System.out.println(Arrays.toString(bubbleSort.bubbleSort(array)));*/
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("优化冒泡排序后：");
        System.out.println(Arrays.toString(bubbleSort.bubbleSortOptimize(array)));
    }

    // 选择排序测试
    public static void selectionSortTest(){
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*500);
        }
        SelectionSort selectionSort = new SelectionSort();
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("选择排序后：");
        System.out.println(Arrays.toString(selectionSort.selectionSort(array)));
    }

    // 插入排序测试
    public static void insertionSortTest(){
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*500);
        }
        InsertionSort insertionSort = new InsertionSort();
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("插入排序后：");
        System.out.println(Arrays.toString(insertionSort.insertionSort(array)));
    }

    // 希尔排序测试
    public static void shellSortTest(){
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*500);
        }
        ShellSort shellSort = new ShellSort();
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
       /* System.out.println("希尔交换排序后：");
        System.out.println(Arrays.toString(shellSort.shellSwapSort(array)));*/
        System.out.println("希尔移位排序后：");
        System.out.println(Arrays.toString(shellSort.shellMoveSort(array)));
    }

    // 快速排序测试
    public static void quickSortTest(){
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*500);
        }
        QuickSort quickSort = new QuickSort();
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("快速排序后：");
        quickSort.quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    // 归并排序测试
    public static void mergeSortTest(){
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*500);
        }
        MergeSort mergeSort = new MergeSort();
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("归并排序后：");
        mergeSort.mergeSort(array,0,array.length-1,new int[array.length]);
        System.out.println(Arrays.toString(array));
    }

    // 基数排序测试
    public static void radixSortTest(){
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*500);
        }
        RadixSort radixSort = new RadixSort();
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("基数排序后：");
        System.out.println(Arrays.toString(radixSort.radixSort(array)));
    }

    // 堆排序测试
    public static void heapSortTest(){
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*500);
        }
        HeapSort heapSort = new HeapSort();
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("堆排序后：");
        System.out.println(Arrays.toString(heapSort.heapSort(array)));
    }

    // 线性查找测试
    public static void seqSearchTest(){
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*10);
        }
        SeqSearch seqSearch = new SeqSearch();
        System.out.println("数组：");
        System.out.println(Arrays.toString(array));
        System.out.println("线性搜索5下标");
        System.out.println(seqSearch.seqSearch(array,5));
    }

    // 二分查找测试
    public static void binarySearchTest(){
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*10);
        }
        BinarySearch binarySearch = new BinarySearch();
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array,0,array.length-1);
        System.out.println("数组：");
        System.out.println(Arrays.toString(array));
        System.out.println("二分搜索5下标");
        System.out.println(binarySearch.binarySearch(array,5,0,array.length-1));
    }

    // 插值查找测试
    public static void interpolationSearchTest(){
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*10);
        }
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array,0,array.length-1);
        System.out.println("数组：");
        System.out.println(Arrays.toString(array));
        System.out.println("插值搜索5下标");
        System.out.println(interpolationSearch.interpolationSearch(array,5,0,array.length-1));
    }

    // 斐波那契查找测试
    public static void fibonacciSearchTest(){
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*10);
        }
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array,0,array.length-1);
        System.out.println("数组：");
        System.out.println(Arrays.toString(array));
        System.out.println("斐波那契搜索5下标");
        System.out.println(fibonacciSearch.fibonacciSearch(array,5));
    }

    // 散列表测试
    public static void hashTableTest(){
        Scanner scanner = new Scanner(System.in);
        HashTable hashTable = new HashTable(20);
        boolean loop = true;
        while (loop){
            System.out.println("输入1为打印散列表");
            System.out.println("输入2为加入散列节点");
            System.out.println("输入3为加入散列有序节点");
            System.out.println("输入4为删除散列节点");
            System.out.println("输入5为修改散列节点");
            System.out.println("输入6为查找散列节点");
            System.out.println("输入7为退出");
            int input = scanner.nextInt();
            Random random = new Random();
            switch (input){
                case 1:
                    hashTable.printHashTable();
                    break;
                case 2:
                    hashTable.addNode(hashTable.new HashTableNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 3:
                    hashTable.addOrderNode(hashTable.new HashTableNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 4:
                    hashTable.deleteNode(scanner.nextInt());
                    break;
                case 5:
                    hashTable.modifyNode(hashTable.new HashTableNode(scanner.nextInt(),random.nextInt()));
                    break;
                case 6:
                    int id = scanner.nextInt();
                    HashTable.HashTableNode hashTableNode = hashTable.getNode(id);
                    System.out.println(hashTableNode==null?"没有找到这个节点":"id="+hashTableNode.getId()+" data="+hashTableNode.getData());
                    break;
                case 7:
                    loop = false;
                    break;
            }
        }
    }

    // 二叉树前中后序遍历测试
    public static void binaryTreeTraversalTest(){
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.BinaryTreeNode root = binaryTree.new BinaryTreeNode(1,123);
        BinaryTree.BinaryTreeNode node1 = binaryTree.new BinaryTreeNode(2,123);
        BinaryTree.BinaryTreeNode node2 = binaryTree.new BinaryTreeNode(3,123);
        BinaryTree.BinaryTreeNode node3 = binaryTree.new BinaryTreeNode(4,123);
        BinaryTree.BinaryTreeNode node4 = binaryTree.new BinaryTreeNode(5,123);
        BinaryTree.BinaryTreeNode node5 = binaryTree.new BinaryTreeNode(6,123);
        root.setLeft(node1);
        node1.setLeft(node2);
        node1.setRight(node4);
        node2.setLeft(node3);
        root.setRight(node5);
        binaryTree.setRoot(root);
        System.out.println("前序遍历");
        binaryTree.preorderTraversal();
        System.out.println("中序遍历");
        binaryTree.inorderTraversal();
        System.out.println("后序遍历");
        binaryTree.postOrderTraversal();
    }

    // 二叉树前中后序搜索测试
    public static void binaryTreeSearchTest(){
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.BinaryTreeNode root = binaryTree.new BinaryTreeNode(1,123);
        BinaryTree.BinaryTreeNode node1 = binaryTree.new BinaryTreeNode(2,123);
        BinaryTree.BinaryTreeNode node2 = binaryTree.new BinaryTreeNode(3,123);
        BinaryTree.BinaryTreeNode node3 = binaryTree.new BinaryTreeNode(4,123);
        BinaryTree.BinaryTreeNode node4 = binaryTree.new BinaryTreeNode(5,123);
        BinaryTree.BinaryTreeNode node5 = binaryTree.new BinaryTreeNode(6,123);
        root.setLeft(node1);
        node1.setLeft(node2);
        node1.setRight(node4);
        node2.setLeft(node3);
        root.setRight(node5);
        binaryTree.setRoot(root);
        System.out.println("前序搜索");
        System.out.println(binaryTree.preorderSearch(5).getId());
        System.out.println("中序搜索");
        System.out.println(binaryTree.inorderSearch(5).getId());
        System.out.println("后序搜索");
        System.out.println(binaryTree.postOrderSearch(5).getId());
    }

    // 二叉树前中后序搜索测试
    public static void binaryTreeDeleteTest(){
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.BinaryTreeNode root = binaryTree.new BinaryTreeNode(1,123);
        BinaryTree.BinaryTreeNode node1 = binaryTree.new BinaryTreeNode(2,123);
        BinaryTree.BinaryTreeNode node2 = binaryTree.new BinaryTreeNode(3,123);
        BinaryTree.BinaryTreeNode node3 = binaryTree.new BinaryTreeNode(4,123);
        BinaryTree.BinaryTreeNode node4 = binaryTree.new BinaryTreeNode(5,123);
        BinaryTree.BinaryTreeNode node5 = binaryTree.new BinaryTreeNode(6,123);
        root.setLeft(node1);
        node1.setLeft(node2);
        node1.setRight(node4);
        node2.setLeft(node3);
        root.setRight(node5);
        binaryTree.setRoot(root);
        System.out.println("前序遍历:");
        binaryTree.preorderTraversal();
        System.out.println("删除节点5");
        binaryTree.deleteNode(5);
        System.out.println("前序遍历:");
        binaryTree.preorderTraversal();
    }

    // 顺序二叉树前中后序遍历测试
    public static void arrayBinaryTreeTraversalTest(){
        int[] tree = new int[]{1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(tree);
        System.out.println("前序遍历:");
        arrayBinaryTree.preorderTraversal(0);
        System.out.println();
        System.out.println("中序遍历:");
        arrayBinaryTree.inorderTraversal(0);
        System.out.println();
        System.out.println("后序遍历:");
        arrayBinaryTree.postOrderTraversal(0);
    }

    // 线索化二叉树测试
    public static void threadedBinaryTreeTest(){
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        ThreadedBinaryTree.ThreadedBinaryTreeNode root = threadedBinaryTree.new ThreadedBinaryTreeNode(1,123);
        ThreadedBinaryTree.ThreadedBinaryTreeNode node1 = threadedBinaryTree.new ThreadedBinaryTreeNode(2,123);
        ThreadedBinaryTree.ThreadedBinaryTreeNode node2 = threadedBinaryTree.new ThreadedBinaryTreeNode(3,123);
        ThreadedBinaryTree.ThreadedBinaryTreeNode node3 = threadedBinaryTree.new ThreadedBinaryTreeNode(4,123);
        ThreadedBinaryTree.ThreadedBinaryTreeNode node4 = threadedBinaryTree.new ThreadedBinaryTreeNode(5,123);
        ThreadedBinaryTree.ThreadedBinaryTreeNode node5 = threadedBinaryTree.new ThreadedBinaryTreeNode(6,123);
        root.setLeft(node1);
        node1.setLeft(node2);
        node1.setRight(node4);
        node2.setLeft(node3);
        root.setRight(node5);
        threadedBinaryTree.setRoot(root);
        /*System.out.println("前序遍历:");
        threadedBinaryTree.preorderTraversal();
        System.out.println();
        System.out.println("前序线索化：");
        threadedBinaryTree.preorderThreaded(root);
        System.out.println(node3.getLeft().getId());
        System.out.println(node4.getLeft().getId());
        System.out.println(node5.getLeft().getId());
        System.out.println(node4.getRight().getId());*/
        /*System.out.println("中序遍历:");
        threadedBinaryTree.inorderTraversal();
        System.out.println();
        System.out.println("中序线索化：");
        threadedBinaryTree.inorderThreaded(root);
        System.out.println(node3.getRight().getId());
        System.out.println(node1.getRight().getId());
        System.out.println(node4.getLeft().getId());
        System.out.println(node4.getRight().getId());
        System.out.println(node5.getLeft().getId());*/
        System.out.println("后序遍历:");
        threadedBinaryTree.postOrderTraversal();
        System.out.println();
        System.out.println("前序线索化：");
        threadedBinaryTree.postOrderThreaded(root);
        System.out.println(node3.getRight().getId());
        System.out.println(node2.getRight().getId());
        System.out.println(node4.getLeft().getId());
        System.out.println(node4.getRight().getId());
    }

    // 线索化二叉树遍历测试
    public static void threadedBinaryTreeTraversalTest(){
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        ThreadedBinaryTree.ThreadedBinaryTreeNode root = threadedBinaryTree.new ThreadedBinaryTreeNode(1,123);
        ThreadedBinaryTree.ThreadedBinaryTreeNode node1 = threadedBinaryTree.new ThreadedBinaryTreeNode(2,123);
        ThreadedBinaryTree.ThreadedBinaryTreeNode node2 = threadedBinaryTree.new ThreadedBinaryTreeNode(3,123);
        ThreadedBinaryTree.ThreadedBinaryTreeNode node3 = threadedBinaryTree.new ThreadedBinaryTreeNode(4,123);
        ThreadedBinaryTree.ThreadedBinaryTreeNode node4 = threadedBinaryTree.new ThreadedBinaryTreeNode(5,123);
        ThreadedBinaryTree.ThreadedBinaryTreeNode node5 = threadedBinaryTree.new ThreadedBinaryTreeNode(6,123);
        root.setLeft(node1);
        node1.setLeft(node2);
        node1.setRight(node4);
        node2.setLeft(node3);
        root.setRight(node5);
        threadedBinaryTree.setRoot(root);
        System.out.println("中序线索化遍历:");
        threadedBinaryTree.inorderThreaded(root);
        threadedBinaryTree.inorderThreadedTraversal();
    }

    // 哈弗曼树测试
    public static void huffmanTreeTest(){
        HuffmanTree huffmanTree = new HuffmanTree();
        int[] array = {13,7,8,3,29,6,1};
        huffmanTree.getHuffmanTree(array);
        huffmanTree.preorderTraversal();
    }
}
/*
顺序二叉树：顺序二叉树是一种树形结构，通常只考虑完全二叉树，每个节点最多只有两个子节点，不过不用指针，使用数组来完成。
主要思想：
	1. 创建一个数组存储二叉树。
	2. 满足第n个元素的左子节点为2*n+1，右子节点为2*n+2，父节点为(n-1)/2。
	3. 前序：父节点=>左子节点=>右子节点。
	4. 中序：左子节点=>父节点=>右子节点。
	5. 后序：左子节点=>右子节点=>父节点。
	6. 完成前、中、后序遍历。
*/
package cn.anydevelop.datastructure.tree;

public class ArrayBinaryTree {
    private int[] binaryTree;

    public ArrayBinaryTree(int[] binaryTree) {
        this.binaryTree = binaryTree;
    }

    // 前序遍历
    public void preorderTraversal(int index){
        if(this.binaryTree == null || this.binaryTree.length ==0){
            System.out.println("This tree is empty!");
            return;
        }
        System.out.print(this.binaryTree[index]+"=>");
        // 向左遍历
        if(this.binaryTree.length > 2*index+1){
            this.preorderTraversal(2*index+1);
        }
        // 向右遍历
        if(this.binaryTree.length > 2*index+2){
            this.preorderTraversal(2*index+2);
        }
    }

    // 中序遍历
    public void inorderTraversal(int index){
        if(this.binaryTree == null || this.binaryTree.length ==0){
            System.out.println("This tree is empty!");
            return;
        }
        // 向左遍历
        if(this.binaryTree.length > 2*index+1){
            this.inorderTraversal(2*index+1);
        }
        System.out.print(this.binaryTree[index]+"=>");
        // 向右遍历
        if(this.binaryTree.length > 2*index+2){
            this.inorderTraversal(2*index+2);
        }
    }

    // 后序遍历
    public void postOrderTraversal(int index){
        if(this.binaryTree == null || this.binaryTree.length ==0){
            System.out.println("This tree is empty!");
            return;
        }
        // 向左遍历
        if(this.binaryTree.length > 2*index+1){
            this.postOrderTraversal(2*index+1);
        }
        // 向右遍历
        if(this.binaryTree.length > 2*index+2){
            this.postOrderTraversal(2*index+2);
        }
        System.out.print(this.binaryTree[index]+"=>");
    }
}

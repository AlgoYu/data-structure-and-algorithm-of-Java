/*
哈夫曼树：哈夫曼树是一种树形结构，该树的带权路径长度达到最小，也称为最优二叉树。
主要思想：
	1. 把数组从小到大排序。
	2. 使用左右节点指针完成前、中、后序遍历、搜索,删除。
	3. 前序：父节点=>左子节点=>右子节点。
	4. 中序：左子节点=>父节点=>右子节点。
	5. 后序：左子节点=>右子节点=>父节点。
*/
package cn.anydevelop.datastructure.tree;

import cn.anydevelop.algorithm.sort.internal.swap.QuickSort;

import java.util.ArrayList;
import java.util.List;

public class HuffmanTree {
    private HuffmanTreeNode root;

    // 前序遍历
    public void preorderTraversal(){
        if(this.root==null){
            System.out.println("This tree is empty!");
        }else{
            this.root.preorderTraversal();
        }
    }

    public HuffmanTreeNode getRoot() {
        return root;
    }

    public void setRoot(HuffmanTreeNode root) {
        this.root = root;
    }

    // 哈弗曼树节点
    public class HuffmanTreeNode{
        private int id;
        private int data;
        private HuffmanTreeNode left;
        private HuffmanTreeNode right;

        public HuffmanTreeNode(int id, int data) {
            this.id = id;
            this.data = data;
        }

        // 前序遍历
        public void preorderTraversal(){
            System.out.print(this.data+"=>");
            if (this.left!=null){
                this.left.preorderTraversal();
            }
            if(this.right!=null){
                this.right.preorderTraversal();
            }
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

        public HuffmanTreeNode getLeft() {
            return left;
        }

        public void setLeft(HuffmanTreeNode left) {
            this.left = left;
        }

        public HuffmanTreeNode getRight() {
            return right;
        }

        public void setRight(HuffmanTreeNode right) {
            this.right = right;
        }
    }

    // 获取哈弗曼树
    public HuffmanTreeNode getHuffmanTree(int[] array){
        List<HuffmanTreeNode> huffmanTreeNodes = new ArrayList<>();
        for (int data : array){
            huffmanTreeNodes.add(new HuffmanTreeNode(data,data));
        }
        while (huffmanTreeNodes.size()>1){
            this.nodeSort(huffmanTreeNodes);
            HuffmanTreeNode left = huffmanTreeNodes.get(0);
            HuffmanTreeNode right = huffmanTreeNodes.get(1);
            HuffmanTreeNode parent = new HuffmanTreeNode(left.getId()+right.getId(),left.getData()+right.getData());
            parent.setLeft(left);
            parent.setRight(right);
            huffmanTreeNodes.remove(left);
            huffmanTreeNodes.remove(right);
            huffmanTreeNodes.add(parent);
        }
        this.root = huffmanTreeNodes.get(0);
        return this.root;
    }

    // 排序
    public void nodeSort(List<HuffmanTreeNode> huffmanTreeNodes){
        HuffmanTreeNode temp;
        for (int i = 1; i < huffmanTreeNodes.size(); i++){
            int index = i-1;
            temp = huffmanTreeNodes.get(i);
            while (index >= 0 && huffmanTreeNodes.get(index).getId() > temp.getId()){
                huffmanTreeNodes.set(index+1,huffmanTreeNodes.get(index));
                index--;
            }
            huffmanTreeNodes.set(index+1,temp);
        }
    }
}

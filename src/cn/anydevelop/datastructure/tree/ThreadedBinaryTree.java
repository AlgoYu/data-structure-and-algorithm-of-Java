/*
线索化二叉树：线索化二叉树是一种树形结构，特点是按某一种遍历顺序把空值的左右指针指向当前节点的前置节点和后置节点。
主要思想：
	1. 创建左右两个指针节点指针。
	2. 如果左节点为空指向当前节点的前置节点，如果有节点为空指向当前节点的后置节点。
	3. 前序：父节点=>左子节点=>右子节点。
	4. 中序：左子节点=>父节点=>右子节点。
	5. 后序：左子节点=>右子节点=>父节点。
*/
package cn.anydevelop.datastructure.tree;

public class ThreadedBinaryTree {
    private ThreadedBinaryTree.ThreadedBinaryTreeNode root;
    private ThreadedBinaryTree.ThreadedBinaryTreeNode pre;

    public ThreadedBinaryTree.ThreadedBinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(ThreadedBinaryTree.ThreadedBinaryTreeNode root) {
        this.root = root;
    }

    // 前序线索化
    public void preorderThreaded(ThreadedBinaryTree.ThreadedBinaryTreeNode node){
        if(node==null){
            return;
        }
        if(node.getLeft()==null){
            node.setLeft(this.pre);
            node.setLeftThreaded(true);
        }
        if(this.pre!=null && this.pre.getRight() == null){
            this.pre.setRight(node);
            this.pre.setRightThreaded(true);
        }
        this.pre = node;
        if(!node.getLeftThreaded()){
            this.preorderThreaded(node.getLeft());
        }
        if(!node.getRightThreaded()){
            this.preorderThreaded(node.getRight());
        }
    }

    // 中序线索化
    public void inorderThreaded(ThreadedBinaryTree.ThreadedBinaryTreeNode node){
        if(node==null){
            return;
        }
        if(!node.getLeftThreaded()){
            this.inorderThreaded(node.getLeft());
        }
        if(node.getLeft()==null){
            node.setLeft(this.pre);
            node.setLeftThreaded(true);
        }
        if(this.pre!=null && this.pre.getRight() == null){
            this.pre.setRight(node);
            this.pre.setRightThreaded(true);
        }
        this.pre = node;
        if(!node.getRightThreaded()){
            this.inorderThreaded(node.getRight());
        }
    }
    // 后序线索化
    public void postorderThreaded(ThreadedBinaryTree.ThreadedBinaryTreeNode node){
        if(node==null){
            return;
        }
        if(!node.getLeftThreaded()){
            this.postorderThreaded(node.getLeft());
        }
        if(!node.getRightThreaded()){
            this.postorderThreaded(node.getRight());
        }
        if(node.getLeft()==null){
            node.setLeft(this.pre);
            node.setLeftThreaded(true);
        }
        if(this.pre!=null && this.pre.getRight() == null){
            this.pre.setRight(node);
            this.pre.setRightThreaded(true);
        }
        this.pre = node;
    }

    // 删除节点
    public void deleteNode(int id){
        if(this.root==null){
            System.out.println("This tree is empty!");
        }else if(this.root.getId()==id){
            this.root=null;
        }else{
            this.root.deleteNode(id);
        }
    }

    // 前序遍历
    public void preorderTraversal(){
        if(this.root==null){
            System.out.println("This tree is empty!");
        }else{
            this.root.preorderTraversal();
        }
    }

    // 中序遍历
    public void inorderTraversal(){
        if(this.root==null){
            System.out.println("This tree is empty!");
        }else{
            this.root.inorderTraversal();
        }
    }

    // 后序遍历
    public void postorderTraversal(){
        if(this.root==null){
            System.out.println("This tree is empty!");
        }else{
            this.root.postorderTraversal();
        }
    }

    // 前序搜索
    public ThreadedBinaryTree.ThreadedBinaryTreeNode preorderSearch(int id){
        if(this.root==null){
            throw new RuntimeException("This tree is empty!");
        }
        return this.root.preorderSearch(id);
    }

    // 中序搜索
    public ThreadedBinaryTree.ThreadedBinaryTreeNode inorderSearch(int id){
        if(this.root==null){
            throw new RuntimeException("This tree is empty!");
        }
        return this.root.inorderSearch(id);
    }

    // 后序搜索
    public ThreadedBinaryTree.ThreadedBinaryTreeNode postorderSearch(int id){
        if(this.root==null){
            throw new RuntimeException("This tree is empty!");
        }
        return this.root.postorderSearch(id);
    }

    // 二叉树节点
    public class ThreadedBinaryTreeNode {
        private int id;
        private int data;
        private ThreadedBinaryTree.ThreadedBinaryTreeNode left;
        private ThreadedBinaryTree.ThreadedBinaryTreeNode right;
        private boolean isLeftThreaded;
        private boolean isRightThreaded;

        public ThreadedBinaryTreeNode(int id, int data) {
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

        public ThreadedBinaryTree.ThreadedBinaryTreeNode getLeft() {
            return left;
        }

        public void setLeft(ThreadedBinaryTree.ThreadedBinaryTreeNode left) {
            this.left = left;
        }

        public ThreadedBinaryTree.ThreadedBinaryTreeNode getRight() {
            return right;
        }

        public void setRight(ThreadedBinaryTree.ThreadedBinaryTreeNode right) {
            this.right = right;
        }

        public boolean getLeftThreaded() {
            return isLeftThreaded;
        }

        public void setLeftThreaded(boolean leftThreaded) {
            this.isLeftThreaded = leftThreaded;
        }

        public boolean getRightThreaded() {
            return isRightThreaded;
        }

        public void setRightThreaded(boolean rightThreaded) {
            this.isRightThreaded = rightThreaded;
        }

        // 删除节点
        public void deleteNode(int id){
            if(this.left!=null && this.left.getId() == id){
                this.left = null;
                return;
            }
            if(this.right!=null && this.right.getId() == id){
                this.right = null;
                return;
            }
            if(this.left!=null){
                this.left.deleteNode(id);
            }
            if(this.right!=null){
                this.right.deleteNode(id);
            }
        }

        // 前序遍历
        public void preorderTraversal(){
            System.out.print(this.id+"=>");
            if (this.left!=null){
                this.left.preorderTraversal();
            }
            if(this.right!=null){
                this.right.preorderTraversal();
            }
        }

        // 中序遍历
        public void inorderTraversal(){
            if(this.left!=null){
                this.left.inorderTraversal();
            }
            System.out.print(this.id+"=>");
            if(this.right!=null){
                this.right.inorderTraversal();
            }
        }

        // 后序遍历
        public void postorderTraversal(){
            if(this.left!=null){
                this.left.postorderTraversal();
            }
            if(this.right!=null){
                this.right.postorderTraversal();
            }
            System.out.print(this.id+"=>");
        }

        // 前序搜索
        public ThreadedBinaryTree.ThreadedBinaryTreeNode preorderSearch(int id){
            if (this.id == id){
                return this;
            }
            ThreadedBinaryTree.ThreadedBinaryTreeNode node = null;
            if (this.left!=null){
                node = this.left.preorderSearch(id);
            }
            if(node!=null){
                return node;
            }
            if(this.right!=null){
                node = this.right.preorderSearch(id);
            }
            return node;
        }

        // 中序搜索
        public ThreadedBinaryTree.ThreadedBinaryTreeNode inorderSearch(int id){
            ThreadedBinaryTree.ThreadedBinaryTreeNode node = null;
            if(this.left!=null){
                node = this.left.inorderSearch(id);
            }
            if(node!=null){
                return node;
            }
            if(this.id == id){
                return this;
            }
            if(this.right!=null){
                node = this.right.inorderSearch(id);
            }
            return node;
        }

        // 后序搜索
        public ThreadedBinaryTree.ThreadedBinaryTreeNode postorderSearch(int id){
            ThreadedBinaryTree.ThreadedBinaryTreeNode node = null;
            if(this.left!=null){
                node = this.left.postorderSearch(id);
            }
            if(node!=null){
                return node;
            }
            if(this.right!=null){
                node = this.right.postorderSearch(id);
            }
            if(node!=null){
                return node;
            }
            if(this.id == id){
                return this;
            }
            return node;
        }
    }
}

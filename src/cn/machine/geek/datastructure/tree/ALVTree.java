/*
ALV树：ALV树是一种树形结构，在二叉排序树上进行优化，通过节点左右旋转使其左右子树保持高度平衡（差值小于等于1）。
主要思想：
	1. 创建左右子两个指针节点，左子节点比父节点小，右子节点比父节点大。
	2. 通过使用中序遍历从小到大输入有序节点。
	3. 判断当前节点比插入节点大或小判断往左递归查找还是往右递归查找完成二叉排序树的查找、增加、修改功能。
	4. 判断当前被删除节点是否为叶子节点、单子树节点、双子树节点以不同的方式完成删除功能。
	5. 通过左右旋转保持ALV树左右子树高度差值不大于1。
*/
package cn.machine.geek.datastructure.tree;

public class ALVTree {
    private ALVTreeNode root;
    public class ALVTreeNode{
        private int value;
        private ALVTreeNode left;
        private ALVTreeNode right;

        public ALVTreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ALVTreeNode getLeft() {
            return left;
        }

        public void setLeft(ALVTreeNode left) {
            this.left = left;
        }

        public ALVTreeNode getRight() {
            return right;
        }

        public void setRight(ALVTreeNode right) {
            this.right = right;
        }

        /**
         * 左旋转
         */
        public void leftRotate(){
            ALVTreeNode temp = new ALVTreeNode(this.value);
            temp.setLeft(this.getLeft());
            temp.setRight(this.getRight().getLeft());
            this.value = this.getRight().getValue();
            this.setLeft(temp);
            this.setRight(this.getRight().getRight());
        }

        /**
         * 右旋转
         */
        public void  rightRotate(){
            ALVTreeNode temp = new ALVTreeNode(this.value);
            temp.setRight(this.getRight());
            temp.setLeft(this.getLeft().getRight());
            this.value = this.getLeft().getValue();
            this.setRight(temp);
            this.setLeft(this.getLeft().getLeft());
        }

        /**
         * 获取左子树高度
         * @return
         */
        public int getLeftHeight(){
            return this.left==null?0:this.left.getHeight();
        }

        /**
         * 获取右子树高度
         * @return
         */
        public int getRightHeight(){
            return this.right==null?0:this.right.getHeight();
        }

        /**
         * 获取树的高度
         * @return
         */
        public int getHeight(){
            return Math.max(this.left==null?0:this.left.getHeight(),this.right==null?0:this.right.getHeight())+1;
        }

        /**
         * 添加节点
         * @param node 节点
         */
        public void addNode(ALVTreeNode node){
            if(this.value > node.value){
                if(this.left==null){
                    this.left = node;
                }else{
                    this.left.addNode(node);
                }
            }else{
                if(this.right == null){
                    this.right = node;
                }else{
                    this.right.addNode(node);
                }
            }
        }

        /**
         * 中序遍历
         */
        public void inorderTraversal(){
            if(this.left!=null){
                this.left.inorderTraversal();
            }
            System.out.print(this.value+"=>");
            if(this.right!=null){
                this.right.inorderTraversal();
            }
        }

        /**
         * 搜索节点
         * @param value
         * @return
         */
        public ALVTreeNode searchNode(int value){
            if(this.value == value){
                return this;
            }else if(this.value > value && this.left!=null){
                return this.left.searchNode(value);
            }else if(this.value < value && this.right!=null){
                return this.right.searchNode(value);
            }else{
                return null;
            }
        }

        /**
         * 搜索父节点
         * @param value
         * @return
         */
        public ALVTreeNode searchParent(int value){
            if(this.left!=null && this.left.value == value || this.right!=null && this.right.value == value){
                return this;
            }else if(this.left!=null && this.value > value){
                return this.left.searchParent(value);
            }else if(this.right!=null && this.value < value){
                return this.right.searchParent(value);
            }else{
                return null;
            }
        }
    }

    /**
     * 获取树的高度
     * @return
     */
    public int getHeight(){
        if(this.root!=null){
            return this.root.getHeight();
        }
        return 0;
    }

    /**
     * 获取左子树高度
     * @return
     */
    public int getLeftHeight(){
        if(this.root!=null){
            return this.root.getLeftHeight();
        }
        return 0;
    }

    /**
     * 获取右子树高度
     * @return
     */
    public int getRightHeight(){
        if(this.root!=null){
            return this.root.getRightHeight();
        }
        return 0;
    }

    /**
     * 增加节点
     * @param node
     */
    public void addNode(ALVTreeNode node){
        if(this.root!=null){
            this.root.addNode(node);
        }else{
            this.root = node;
        }
        if(this.root.getLeftHeight()-this.root.getRightHeight()>1){
            if(this.root.getLeft().getRightHeight()>this.root.getLeft().getLeftHeight()){
                this.root.getLeft().leftRotate();
            }
            this.root.rightRotate();
        }
        if(this.root.getRightHeight()-this.root.getLeftHeight()>1){
            if(this.root.getRight().getLeftHeight()>this.root.getRight().getRightHeight()){
                this.root.getRight().rightRotate();
            }
            this.root.leftRotate();
        }
    }

    /**
     * 中序遍历
     */
    public void inorderTraversal(){
        if(this.root!=null){
            this.root.inorderTraversal();
        }
    }

    /**
     * 搜索节点
     * @param value
     */
    public ALVTreeNode searchNode(int value){
        if(this.root!=null){
            return this.root.searchNode(value);
        }
        return null;
    }

    /**
     * 搜索父节点
     * @param value
     * @return
     */
    public ALVTreeNode searchParentNode(int value){
        if(this.root!=null){
            return this.root.searchParent(value);
        }
        return null;
    }

    /**
     * 删除节点
     * @param value
     */
    public void deleteNode(int value){
        ALVTreeNode targetNode = this.searchNode(value);
        if(targetNode!=null){
            if(targetNode == this.root && targetNode.getLeft()==null && targetNode.getRight()==null){
                this.root = null;
            }else{
                ALVTreeNode parentNode = this.searchParentNode(value);
                if(targetNode.getLeft() == null && targetNode.getRight() == null){
                    if(parentNode.getLeft()!=null && parentNode.getLeft() == targetNode){
                        parentNode.setLeft(null);
                    }else if(parentNode.getRight()!=null && parentNode.getRight()==targetNode){
                        parentNode.setRight(null);
                    }
                }else if(targetNode.getLeft()!=null && targetNode.getRight()!=null){
                    ALVTreeNode temp = targetNode.getRight();
                    while (temp.getLeft()!=null){
                        temp = temp.getLeft();
                    }
                    this.deleteNode(temp.value);
                    targetNode.setValue(temp.getValue());
                }else{
                    if(parentNode==null){
                        if(targetNode.getLeft()!=null){
                            this.root = targetNode.getLeft();
                        }else{
                            this.root = targetNode.getRight();
                        }
                    }else if(targetNode.getLeft()!=null){
                        if(parentNode.getLeft()==targetNode){
                            parentNode.setLeft(targetNode.getLeft());
                        }else{
                            parentNode.setRight(targetNode.getLeft());
                        }
                    }else{
                        if(parentNode.getLeft()==targetNode){
                            parentNode.setLeft(targetNode.getRight());
                        }else{
                            parentNode.setRight(targetNode.getRight());
                        }
                    }
                }
            }
        }
    }
}

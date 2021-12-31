/*
二叉排序树：二叉排序树是一种树形结构，使用中序遍历进行排序，搜索和添加都有较好的性能。
主要思想：
	1. 创建左右子两个指针节点，左子节点比父节点小，右子节点比父节点大。
	2. 通过使用中序遍历从小到大输入有序节点。
	3. 判断当前节点比插入节点大或小判断往左递归查找还是往右递归查找完成二叉排序树的查找、增加、修改功能。
	4. 判断当前被删除节点是否为叶子节点、单子树节点、双子树节点以不同的方式完成删除功能。
*/
package cn.machine.geek.datastructure.tree;

public class BinarySortTree {
    private BinarySortTreeNode root;

    public class BinarySortTreeNode {
        private int value;
        private BinarySortTreeNode left;
        private BinarySortTreeNode right;

        public BinarySortTreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public BinarySortTreeNode getLeft() {
            return left;
        }

        public void setLeft(BinarySortTreeNode left) {
            this.left = left;
        }

        public BinarySortTreeNode getRight() {
            return right;
        }

        public void setRight(BinarySortTreeNode right) {
            this.right = right;
        }

        /**
         * 添加节点
         *
         * @param node 节点
         */
        public void addNode(BinarySortTreeNode node) {
            if (this.value > node.value) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.addNode(node);
                }
            } else {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.addNode(node);
                }
            }
        }

        /**
         * 中序遍历
         */
        public void inorderTraversal() {
            if (this.left != null) {
                this.left.inorderTraversal();
            }
            System.out.print(this.value + "=>");
            if (this.right != null) {
                this.right.inorderTraversal();
            }
        }

        /**
         * 搜索节点
         *
         * @param value
         * @return
         */
        public BinarySortTreeNode searchNode(int value) {
            if (this.value == value) {
                return this;
            } else if (this.value > value && this.left != null) {
                return this.left.searchNode(value);
            } else if (this.value < value && this.right != null) {
                return this.right.searchNode(value);
            } else {
                return null;
            }
        }

        /**
         * 搜索父节点
         *
         * @param value
         * @return
         */
        public BinarySortTreeNode searchParent(int value) {
            if (this.left != null && this.left.value == value || this.right != null && this.right.value == value) {
                return this;
            } else if (this.left != null && this.value > value) {
                return this.left.searchParent(value);
            } else if (this.right != null && this.value < value) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    /**
     * 增加节点
     *
     * @param node
     */
    public void addNode(BinarySortTreeNode node) {
        if (this.root != null) {
            this.root.addNode(node);
        } else {
            this.root = node;
        }
    }

    /**
     * 中序遍历
     */
    public void inorderTraversal() {
        if (this.root != null) {
            this.root.inorderTraversal();
        }
    }

    /**
     * 搜索节点
     *
     * @param value
     */
    public BinarySortTreeNode searchNode(int value) {
        if (this.root != null) {
            return this.root.searchNode(value);
        }
        return null;
    }

    /**
     * 搜索父节点
     *
     * @param value
     * @return
     */
    public BinarySortTreeNode searchParentNode(int value) {
        if (this.root != null) {
            return this.root.searchParent(value);
        }
        return null;
    }

    /**
     * 删除节点
     *
     * @param value
     */
    public void deleteNode(int value) {
        BinarySortTreeNode targetNode = this.searchNode(value);
        if (targetNode != null) {
            if (targetNode == this.root && targetNode.getLeft() == null && targetNode.getRight() == null) {
                this.root = null;
            } else {
                BinarySortTreeNode parentNode = this.searchParentNode(value);
                if (targetNode.getLeft() == null && targetNode.getRight() == null) {
                    if (parentNode.getLeft() != null && parentNode.getLeft() == targetNode) {
                        parentNode.setLeft(null);
                    } else if (parentNode.getRight() != null && parentNode.getRight() == targetNode) {
                        parentNode.setRight(null);
                    }
                } else if (targetNode.getLeft() != null && targetNode.getRight() != null) {
                    BinarySortTreeNode temp = targetNode.getRight();
                    while (temp.getLeft() != null) {
                        temp = temp.getLeft();
                    }
                    this.deleteNode(temp.value);
                    targetNode.setValue(temp.getValue());
                } else {
                    if (parentNode == null) {
                        if (targetNode.getLeft() != null) {
                            this.root = targetNode.getLeft();
                        } else {
                            this.root = targetNode.getRight();
                        }
                    } else if (targetNode.getLeft() != null) {
                        if (parentNode.getLeft() == targetNode) {
                            parentNode.setLeft(targetNode.getLeft());
                        } else {
                            parentNode.setRight(targetNode.getLeft());
                        }
                    } else {
                        if (parentNode.getLeft() == targetNode) {
                            parentNode.setLeft(targetNode.getRight());
                        } else {
                            parentNode.setRight(targetNode.getRight());
                        }
                    }
                }
            }
        }
    }
}
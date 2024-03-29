/*
二叉树：二叉树是一种树形结构，每个节点最多只有两个子节点。
主要思想：
	1. 创建左右两个指针节点指针。
	2. 使用左右节点指针完成前、中、后序遍历、搜索,删除。
	3. 前序：父节点=>左子节点=>右子节点。
	4. 中序：左子节点=>父节点=>右子节点。
	5. 后序：左子节点=>右子节点=>父节点。
*/
package cn.machine.geek.datastructure.tree;


public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    // 删除节点
    public void deleteNode(int id) {
        if (this.root == null) {
            System.out.println("This tree is empty!");
        } else if (this.root.getId() == id) {
            this.root = null;
        } else {
            this.root.deleteNode(id);
        }
    }

    // 前序遍历
    public void preorderTraversal() {
        if (this.root == null) {
            System.out.println("This tree is empty!");
        } else {
            this.root.preorderTraversal();
        }
    }

    // 中序遍历
    public void inorderTraversal() {
        if (this.root == null) {
            System.out.println("This tree is empty!");
        } else {
            this.root.inorderTraversal();
        }
    }

    // 后序遍历
    public void postOrderTraversal() {
        if (this.root == null) {
            System.out.println("This tree is empty!");
        } else {
            this.root.postOrderTraversal();
        }
    }

    // 前序搜索
    public BinaryTreeNode preorderSearch(int id) {
        if (this.root == null) {
            throw new RuntimeException("This tree is empty!");
        }
        return this.root.preorderSearch(id);
    }

    // 中序搜索
    public BinaryTreeNode inorderSearch(int id) {
        if (this.root == null) {
            throw new RuntimeException("This tree is empty!");
        }
        return this.root.inorderSearch(id);
    }

    // 后序搜索
    public BinaryTreeNode postOrderSearch(int id) {
        if (this.root == null) {
            throw new RuntimeException("This tree is empty!");
        }
        return this.root.postOrderSearch(id);
    }

    // 二叉树节点
    public class BinaryTreeNode {
        private int id;
        private int data;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(int id, int data) {
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

        public BinaryTreeNode getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode left) {
            this.left = left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode right) {
            this.right = right;
        }

        // 删除节点
        public void deleteNode(int id) {
            if (this.left != null && this.left.getId() == id) {
                this.left = null;
                return;
            }
            if (this.right != null && this.right.getId() == id) {
                this.right = null;
                return;
            }
            if (this.left != null) {
                this.left.deleteNode(id);
            }
            if (this.right != null) {
                this.right.deleteNode(id);
            }
        }

        // 前序遍历
        public void preorderTraversal() {
            System.out.print(this.id + "=>");
            if (this.left != null) {
                this.left.preorderTraversal();
            }
            if (this.right != null) {
                this.right.preorderTraversal();
            }
        }

        // 中序遍历
        public void inorderTraversal() {
            if (this.left != null) {
                this.left.inorderTraversal();
            }
            System.out.print(this.id + "=>");
            if (this.right != null) {
                this.right.inorderTraversal();
            }
        }

        // 后序遍历
        public void postOrderTraversal() {
            if (this.left != null) {
                this.left.postOrderTraversal();
            }
            if (this.right != null) {
                this.right.postOrderTraversal();
            }
            System.out.print(this.id + "=>");
        }

        // 前序搜索
        public BinaryTreeNode preorderSearch(int id) {
            if (this.id == id) {
                return this;
            }
            BinaryTreeNode node = null;
            if (this.left != null) {
                node = this.left.preorderSearch(id);
            }
            if (node != null) {
                return node;
            }
            if (this.right != null) {
                node = this.right.preorderSearch(id);
            }
            return node;
        }

        // 中序搜索
        public BinaryTreeNode inorderSearch(int id) {
            BinaryTreeNode node = null;
            if (this.left != null) {
                node = this.left.inorderSearch(id);
            }
            if (node != null) {
                return node;
            }
            if (this.id == id) {
                return this;
            }
            if (this.right != null) {
                node = this.right.inorderSearch(id);
            }
            return node;
        }

        // 后序搜索
        public BinaryTreeNode postOrderSearch(int id) {
            BinaryTreeNode node = null;
            if (this.left != null) {
                node = this.left.postOrderSearch(id);
            }
            if (node != null) {
                return node;
            }
            if (this.right != null) {
                node = this.right.postOrderSearch(id);
            }
            if (node != null) {
                return node;
            }
            if (this.id == id) {
                return this;
            }
            return node;
        }
    }
}
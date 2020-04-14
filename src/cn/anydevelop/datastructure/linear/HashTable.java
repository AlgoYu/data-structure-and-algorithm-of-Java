/*
散列表：散列表是一种线性结构，是根据关键码值(Key value)而直接进行访问的数据结构，把数据转换为存储位置的映射函数叫做散列函数，存放记录的数组叫做散列表。
主要思想：
	1. 创建一个数组作为散列表。
	2. 使用取模的方法作为散列函数。
	3. 使用散列散列函数转换存储地址。
	4. 数组中存储链表结构完整增删改查操作。
*/
package cn.anydevelop.datastructure.linear;

public class HashTable {
    private int size;
    private HashTableNode[] hashTable;

    // 初始化散列表
    public HashTable(int size) {
        this.size = size;
        this.hashTable = new HashTableNode[size];
    }

    // 散列函数
    public int hashFunction(int key){
        return key % size;
    }

    // 散列表节点
    public class HashTableNode{
        private int id;
        private int data;
        private HashTableNode next;

        public HashTableNode(int id, int data) {
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

        public HashTableNode getNext() {
            return next;
        }

        public void setNext(HashTableNode next) {
            this.next = next;
        }
    }

    // 增加节点
    public void addNode(HashTableNode hashTableNode){
        if(this.getNode(hashTableNode.getId())!=null){
            System.out.print("The node already exist!");
            return;
        }
        int index = this.hashFunction(hashTableNode.getId());
        if(this.hashTable[index] == null){
            this.hashTable[index] = hashTableNode;
        }else{
            HashTableNode temp = this.hashTable[index];
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(hashTableNode);
        }
    }

    // 增加有序节点
    public void addOrderNode(HashTableNode hashTableNode){
        if(this.getNode(hashTableNode.getId())!=null){
            System.out.print("The node already exist!");
            return;
        }
        int index = this.hashFunction(hashTableNode.getId());
        if(this.hashTable[index] == null){
            this.hashTable[index] = hashTableNode;
        }else{
            HashTableNode temp = this.hashTable[index];
            if(temp.getId() > hashTableNode.getId()){
                hashTableNode.setNext(temp);
                this.hashTable[index] = hashTableNode;
            }else{
                while (temp.getNext() != null && temp.getId() < hashTableNode.getId()){
                    temp = temp.getNext();
                }
                hashTableNode.setNext(temp.getNext());
                temp.setNext(hashTableNode);
            }
        }
    }

    // 删除节点
    public void deleteNode(int id){
        int index = this.hashFunction(id);
        if(this.hashTable[index] == null){
            throw new RuntimeException("LinkedList is empty!");
        }else{
            HashTableNode temp = this.hashTable[index];
            if(temp.getId() == id){
                this.hashTable[index] = temp.getNext();
            }else{
                while (temp.next != null && temp.getId() != id){
                    temp = temp.getNext();
                }
                if(temp.getNext() != null){
                    temp.setNext(temp.getNext().getNext());
                }
            }
        }
    }

    // 修改节点
    public void modifyNode(HashTableNode hashTableNode){
        HashTableNode node = this.getNode(hashTableNode.getId());
        if(node!=null){
            node.setData(hashTableNode.getData());
        }
    }

    // 查询节点
    public HashTableNode getNode(int id){
        int index = this.hashFunction(id);
        HashTableNode temp = this.hashTable[index];
        while (temp!=null && temp.getId()!=id){
            temp = temp.getNext();
        }
        return temp;
    }

    // 打印散列表
    public void printHashTable(){
        for (int i = 0; i < size; i++){
            HashTableNode temp = this.hashTable[i];
            System.out.print("The "+i+" linked list:");
            while (temp!=null){
                System.out.print("id="+temp.getId()+"data="+temp.getData()+"=>");
                temp = temp.getNext();
            }
            System.out.println();
        }
    }
}
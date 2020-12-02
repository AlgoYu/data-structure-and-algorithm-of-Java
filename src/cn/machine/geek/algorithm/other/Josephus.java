/*
约瑟夫问题：N个人围成一圈，从第一个开始报数，第M个将被杀掉，最后剩下一个，其余人都将被杀掉。
主要思想：
	1. 创建一个循环链表模拟人围成的圆。
	2. 数据域用来存储数据，指针域用来指向下一个数据。
	3. 最后一个数据节点的指针指向第一个数据节点。
	4. 约瑟夫问题使用一个辅助指针先指向环形指针的尾部，再跟随当前指针一起前进。
	5. 每次当前指针指向的数据节点需要出链表的时候，当前指针指向下一个，辅助指针指向当前指针。
*/
package cn.machine.geek.algorithm.other;


public class Josephus {
    private int length;
    private People next;

    public class People {
        private int id;
        private int data;
        private People next;

        public People(int id, int data) {
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

        public People getNext() {
            return next;
        }

        public void setNext(People next) {
            this.next = next;
        }
    }

    // 增加加点
    public void addNode(People node){
        if(this.next==null){
            this.next = node;
            this.next.setNext(this.next);
            this.length++;
            return;
        }
        People temp = this.next;
        while (temp.getNext()!=this.next){
            temp = temp.getNext();
        }
        node.setNext(temp.getNext());
        temp.setNext(node);
        this.length++;
    }

    // 打印链表
    public void printLinkedList(){
        if(this.length <= 0){
            System.out.println("LinkedList is empty!");
            return;
        }
        People temp = this.next;
        int count = this.length;
        while (count>0){
            System.out.print("["+temp.getId()+"]="+temp.getData()+" ");
            temp = temp.getNext();
            count--;
        }
        System.out.println();
    }

    // 打印约瑟夫圆
    public void printJosephusCircular(int start,int count) {
        if(this.length <= 1){
            return;
        }
        // 辅助指针先指向环形指针尾部
        People helper = this.next;
        while (helper.getNext()!=this.next){
            helper = helper.getNext();
        }
        // 当前指针指向起始节点，辅助指针跟随在后。
        People current = this.next;
        for (int i = 0; i < start-1; i++){
            current = current.getNext();
            helper = helper.getNext();
        }
        // 只要辅助指针不等于当前指针说明数据节点大于2
        while (helper!=current){
            // 当前指针指向需要出链表的节点，辅助指针跟随在后。
            for (int i = 0; i < count-1; i++){
                current = current.getNext();
                helper = helper.getNext();
            }
            // 打印当前节点
            System.out.print("["+current.getId()+"]="+current.getData());
            // 当前指针指向下一个节点
            current = current.getNext();
            // 辅助指针指向当前节点
            helper.setNext(current);
        }
        System.out.println();
        System.out.println("存活:["+current.getId()+"]="+current.getData());
    }
}
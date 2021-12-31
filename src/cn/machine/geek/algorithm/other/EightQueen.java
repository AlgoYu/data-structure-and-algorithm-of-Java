/*
八皇后：在国际象棋上放置八个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上。
主要思想：
	1. 使用递归的方法来一行一行地放置皇后。
	2. 每次判断是否与前面的皇后处于同一行、同一列、同一斜线。
	3. 由于递归的回溯特性可以把所有的组合全部找出。
*/
package cn.machine.geek.algorithm.other;

public class EightQueen {
    private int max;
    private int size;
    private int[] queens;
    private int count;

    // 初始化棋盘大小和皇后数量
    public EightQueen(int max, int size) {
        this.max = max;
        this.size = size;
        this.count = 0;
        this.queens = new int[max];
    }

    // 放入皇后
    public void putQueen(int n) {
        // 如果已经放满皇后则打印
        if (n == max) {
            this.count++;
            this.printQueens();
            return;
        }
        // 尝试放入每一列
        for (int i = 0; i < size; i++) {
            this.queens[n] = i;
            if (this.isValid(n)) {
                putQueen(n + 1);
            }
        }
    }

    // 判断当前皇后位置是否有效
    public boolean isValid(int n) {
        // 遍历皇后
        for (int i = 0; i < n; i++) {
            // 如果当前皇后位置与前面的皇后列相同（处在同一列）或者行列差的绝对值相同（处在一个同一斜线），则无效。
            if (this.queens[i] == this.queens[n] || Math.abs(n - i) == Math.abs(this.queens[n] - this.queens[i])) {
                return false;
            }
        }
        return true;
    }

    // 打印皇后
    public void printQueens() {
        System.out.println("The " + this.count + " kind:");
        for (int i = 0; i < this.queens.length; i++) {
            System.out.print("[" + i + "]=" + this.queens[i] + " ");
        }
        System.out.println();
    }
}
/*
稀疏矩阵：是当一个矩阵中存在着大量重复且无意义的值，可以使用稀疏数组来存储这个矩阵，以减少占用的空间。
主要思想：
	1. 稀疏矩阵第一行[0][0]记录矩阵的行数，[0][1]记录矩阵的列数，[0][2]记录有效数据个数。
	2. 稀疏矩阵第二行开始记录有效数据，例如[1][0]记录有效数据的行数，[1][1]记录有效数据的列数，[1][2]记录有效数据数值。
	3. 重复第第二步。
*/
package cn.anydevelop.datastructure.linear;

public class SparseMatrix {
    /* 把原始矩阵转换为稀疏矩阵 */
    public static int[][] convertToSparseMatrix(int[][] sourceMatrix){
        // validData记录矩阵的有效数据个数
        int validData = 0;
        // 遍历矩阵获取有效数据的个数
        for(int i = 0; i < sourceMatrix.length; i++){
            for (int j = 0; j < sourceMatrix[i].length; j++){
                if(sourceMatrix[i][j]!=0){
                    validData++;
                }
            }
        }
        // 初始化行数为validData+1，列为3的矩阵。
        int[][] sparseMatrix = new int[validData+1][3];
        // 记录行数
        sparseMatrix[0][0] = sourceMatrix.length;
        // 记录列数
        sparseMatrix[0][1] = sourceMatrix[0].length;
        // 记录有效数据个数
        sparseMatrix[0][2] = validData;
        // 往稀疏矩阵存入有效值的行和列及值
        int row = 0;
        for(int i = 0; i < sourceMatrix.length; i++){
            for (int j = 0; j < sourceMatrix[i].length; j++){
                if(sourceMatrix[i][j]!=0){
                    row++;
                    // 记录有效数据行数
                    sparseMatrix[row][0] = i;
                    // 记录有效数据列数
                    sparseMatrix[row][1] = j;
                    // 记录有效数据值
                    sparseMatrix[row][2] = sourceMatrix[i][j];
                }
            }
        }
        return sparseMatrix;
    }

    /* 从稀疏矩阵中恢复到原始矩阵 */
    public static int[][] restoreMatrixFromSparseMatrix(int[][] sparseMatrix){
        // 从稀疏矩阵中获取原始矩阵的行列数
        int[][] sourceMatrix = new int[sparseMatrix[0][0]][sparseMatrix[0][1]];
        // 从稀疏矩阵中获取有效数据行和列并赋值到原始矩阵
        for (int i = 0; i < sparseMatrix[0][2];){
            i++;
            sourceMatrix[sparseMatrix[i][0]][sparseMatrix[i][1]] = sparseMatrix[i][2];
        }
        return sourceMatrix;
    }

    /* 打印矩阵 */
    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
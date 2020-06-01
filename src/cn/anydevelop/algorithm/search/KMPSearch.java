/*
KMP搜索算法：现在有两个字符串：s1和s2，现在要你输出s2在s1当中第一次出现的位置，先扫描出s2的前后缀匹配表，再利用匹配表快速定位s2在s1的位置。
主要思想：
	1. 先扫描出s2的前后缀匹配表，使用数组保存起来。
	2. 扫描逐步匹配两个字符串的字符。
	3. 逐个选择和不选择物品，进行填表。
	4. 求出此类问题的最佳组合。
*/
package cn.anydevelop.algorithm.search;

public class KMPSearch {
    public static int kMPSearch(String source,String match){
        int[] matchTable = KMPSearch.kMPMatchTable(match);
        for (int i = 0,j = 0; i < source.length(); i++){
            while (j>0 && source.charAt(i) != match.charAt(j)){
                j = matchTable[j-1];
            }
            if(source.charAt(i) == match.charAt(j)){
                j++;
            }
            if(j==match.length()){
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] kMPMatchTable(String str){
        int[] matchTable = new int[str.length()];
        for (int i = 1,j = 0; i < str.length(); i++){
            while (j > 0 && str.charAt(i) != str.charAt(j)){
                j = matchTable[j-1];
            }
            if(str.charAt(i) == str.charAt(j)){
                j++;
            }
            matchTable[i] = j;
        }
        return matchTable;
    }
}
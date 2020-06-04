/*
覆盖地区：给定一组需要覆盖的地区和不同的频道信号，没个不同的频道信号覆盖不同的地区，求出最优解或者近似解。
主要思想：
	1. 使用贪心算法，每次比较频道覆盖需要地区个数，选择每次的最优解。
*/
package cn.anydevelop.algorithm.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CoverArea {
    public static List<String> coverArea(List<String> allArea, HashMap<String, HashSet<String>> channel){
        HashSet<String> temp = new HashSet<>();
        List<String> select = new ArrayList<>();
        String maxKey = null;
        int maxSize;
        while (allArea.size() > 0){
            maxSize = 0;
            for (String key : channel.keySet()){
                temp.clear();
                HashSet<String> ch = channel.get(key);
                temp.addAll(ch);
                temp.retainAll(allArea);
                if(temp.size() > maxSize){
                    maxKey = key;
                    maxSize = temp.size();
                }
            }
            if(maxSize>0){
                select.add(maxKey);
                allArea.removeAll(channel.get(maxKey));
            }
        }
        return select;
    }
}

package com.校招笔试.招银网络;

/**
 * Created by lzl on 2018/9/8 12:26
 * 功能：给定一个正整数，输出这样的一类正整数组合，满足条件：组合是以1递增，组合累加的和等于给定的正整数。如果不存在则返回NULL
 * 输入：90
 * 输出：
    [2,3,4,5,6,7,8,9,10,11,12,13]
    [6,7,8,9,10,11,12,13,14]
    [16,17,18,19,20]
    [21,22,23,24]
    [29,30,31]
 */
import java.util.*;
public class Third {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i= 1; i < target; i++){//固定起始位置
            int sum = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = i; j < target; j++) {
                sum += j;
                if(sum > target){
                    break;
                }
                if(sum == target){
                    list.add(temp);
                }
                //放置在该位置放置多添加了元素
                temp.add(j);
            }
        }
        if(list.size() == 0){
            System.out.println("NULL");
            return;
        }


        for(ArrayList<Integer> temp : list){
            StringBuilder res = new StringBuilder();
            res.append("[");
            for (int i = 0; i < temp.size() -1; i++) {
                res.append(temp.get(i) + ",");
            }
            res.append(temp.get(temp.size()-1) + "]");
            System.out.println(res);
        }
    }

}

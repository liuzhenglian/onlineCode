package com.校招笔试.阿里秋招笔试题;

/**
 * Created by lzl on 2018/9/7 21:03
 * 功能：
 */
import java.util.*;

public class First {

    //子数组在原数组中的相对位置不可以改变
    //子数组长度等于或大于3
    //子数组是等差或者等比数列
    //组合数是指原数组可以拆分成的子数组组合数，参与组合的子数组合并之后即为原数组

    //获取元素索引不重复的子数组
    public void getChildrenArray(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < i + 3 ; j++) {

            }
        }

        int minLen = 3;
        int maxLen = arr.length - 3;
        for (int i = 0; i < arr.length - 3; i++) {
            ArrayList<int[]> arrayChildren = new ArrayList<int[]>();
            for (int j = minLen; j <= maxLen ; j++) {
                int[] temp = new int[j];
                for (int k = i; k < i + j; k++) {
                    temp[k] = arr[i + k];
                }
                arrayChildren.add(temp);
            }

        }
        //去除存在重复元素的
        //判断元素是否为等差或者等比数列
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (in.hasNext()){
            array.add(in.nextInt());
        }

        if(array.size()<6){
            System.out.println(0);
        }


    }


}

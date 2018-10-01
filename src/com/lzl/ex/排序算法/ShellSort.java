package com.lzl.ex.排序算法;

/**
 * Created by lzl on 2018/9/3 1:16
 * 功能：实现希尔排序
 */
public class ShellSort {

    //判断第一个元素是否<第二个元素
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    //交换数组中两个元素的位置
    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[j];
        a[i] = a[j];
        a[j] = t;
    }

    //打印数组
    public static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++)
            System.out.println(a[i] + " ");
        System.out.println();

    }

    //测试数组是否已经从小到大排序
    public static boolean isSorted(Comparable[] a){
        for(int i = 0; i < a.length - 1; i++)
            if(!less(a[i], a[i + 1])) return false;
        return true;
    }

    public static void shellSort(Comparable[] arr){
        if(arr == null) return;
        int len = arr.length;
        if(len <= 1) return;
        int h = 1;
        while(h < len/3) h = 3 * h + 1;
        while(h >= 1){
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h ; j-=h) {

                }
            }
        }
    }

    public static void main(String[] args){
        Comparable[] a = {1,2,3,4,5};
        System.out.println(isSorted(a));
    }
}

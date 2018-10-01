package com.lzl.ex.排序算法;

/**
 * Created by lzl on 2018/8/31 23:51
 * 功能：实现冒泡排序
 *
 */
public class BubbleSort implements Comparable{
    @Override
    public int compareTo(Object o) {

        if(o==null){

        }
        return 0;
    }

    public static void bubbleSort(int[] arr){
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }
            }

        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4,1,3};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}

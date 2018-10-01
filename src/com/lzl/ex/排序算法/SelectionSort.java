package com.lzl.ex.排序算法;

/**
 * Created by lzl on 2018/8/30 19:13
 * 功能：实现选择排序
 * 选出数组最小的元素，将它与数组的第一个元素交换位置。再从剩下的元素中选择出最小的元素
 */
public class SelectionSort {

    public static void selectionSort(int arr[]){
        for (int i = 0; i < arr.length ; i++) {
            int minIndex = i;
            //找出数组中值最小的位置
            for (int j = i + 1; j < arr.length ; j++) {
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    //交换数组索引为i和j的值
    private static void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,6,1,8,3,1,2,9};
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("---------------");

        selectionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}

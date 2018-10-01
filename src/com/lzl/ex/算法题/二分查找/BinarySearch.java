package com.lzl.ex.算法题.二分查找;

/**
 * Created by: Administrator 2018-09-05 23:05
 * 功能：实现二分查找算法
 * 二分查找算法在数组有序的情况下才有意义
 */
public class BinarySearch {
    public static int binSearch(int[] arr, int key){
        int mid  = arr.length / 2;
        if(key == arr[mid]){
            return mid;
        }
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            mid = (end - start)/2 + start;
            if(key < arr[mid]){
                end = mid -1;
            }else if(key > arr[mid]){
                start = mid + 1;
            }
            else
                return mid;
        }
        return -1;
    }
}


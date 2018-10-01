//package com.校招笔试.爱奇艺校招;
//
///**
// * Created by lzl on 2018/9/15 19:41
// * 实现幸运数字
// * 输入一个长度为6的字符串，每个字符都是数字。前三个之和和后三个之和相等则为幸运数字
// * 每次可以替换一个字符，请问将一个字符串替换为幸运数字的最小操作数是多少
// */
//import java.util.*;
//
//public class first {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String num = sc.nextLine();
//        char[] numChar = num.toCharArray();
//        int[] arr1 = new int[3];
//        int[] arr2 = new int[3];
//        for (int i = 0; i < 3; i++) {
//            arr1[i] = Integer.parseInt(String.valueOf(numChar[i]));
//            arr2[i] = Integer.parseInt(String.valueOf(numChar[i+3]));
//        }
//
//        if(isEqual(arr1, arr2)) System.out.println(0);
//
//        int cha = cha(arr1, arr2);
//        cha = Math.abs(cha);
//        if(cha<=27 && cha >= 18) System.out.println(3);
//        if(cha<=18 && cha > 9) {
//            if(cunzai(arr1,9) || cunzai(arr2, 9)){
//                System.out.println(2);
//                return;
//            }
//            System.out.println(2);
//        }
//        if(cha<=9) System.out.println(1);
//
//    }
//    //判断值是否相等
//    public static boolean isEqual(int[] arr1, int[] arr2){
//        int x = 0;
//        int y = 0;
//        for (int i = 0; i < arr1.length; i++) {
//            x = x + arr1[i];
//            y = y + arr2[i];
//        }
//
//        if(x == y) return true;
//        else return false;
//    }
//
//    //判断前三个数比后三个书的差
//    public static int cha(int[] arr1, int[] arr2){
//        int x = 0;
//        int y = 0;
//        for (int i = 0; i < arr1.length; i++) {
//            x = x + arr1[i];
//            y = y + arr2[i];
//        }
//        return x - y;
//    }
//
//    //判断是否存在某个元素
//    public static boolean cunzai(int arr[], int a){
//        for (int j = 0; j < arr.length; j++) {
//            if(arr[j] == a){
//                return true;
//            }
//        }
//        return false;
//    }
//}

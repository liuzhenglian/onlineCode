package com.校招笔试;

import java.util.*;

public class java {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        int pointNum = Integer.valueOf(line1.split(" ")[0]);//采样点
        int timeRange = Integer.valueOf(line1.split(" ")[1]);//时间跨度

        int []pointValueInt = new int [pointNum*timeRange];
        for (int i = 0; i<pointValueInt.length;i++){
            int j = i%pointNum;
            pointValueInt[i] = Integer.valueOf(line2.split(" ")[j]);
        }

        int longest = getLength(pointValueInt);
        System.out.println(longest);

    }

    public static int BinarySearchPosition(int arrayOut[],int left,int right,int key){

        int mid;

        if (arrayOut[right]<key) {
            return right+1;
        }else {
            while(left<right){
                mid=(left+right)/2;
                if (arrayOut[mid]<key) {
                    left=mid+1;
                }else {
                    right=mid;
                }
            }
            return left;
        }

    }

    public static int getLength(int[] arrayIn){

        int position;
        int len=1;

        int[] arrayOut=new int[arrayIn.length+1];
        arrayOut[1]=arrayIn[0];
        for (int i = 1; i < arrayIn.length; i++) {
            position=BinarySearchPosition(arrayOut, 1, len, arrayIn[i]);
            arrayOut[position]=arrayIn[i];
            if (len<position) {
                len=position;
            }
        }

        return len;
    }

}

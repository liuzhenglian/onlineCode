package com.校招笔试.滴滴笔试题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lzl on 2018/9/18 21:29
 * 功能：
 */
public class Second {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] arr = line.split(" ");
        int p = Integer.parseInt(arr[0]);
        int q = Integer.parseInt(arr[1]);
        int r = Integer.parseInt(arr[2]);
        String res = "";
        for (int i = 0; i < p; i++) {
            res+="1";
        }
        for (int i = 0; i < q; i++) {
            res+="2";
        }

        for (int i = 0; i < r; i++) {
            res+="3";
        }


        String b = res;
        recursionArrange(b.toCharArray(), 0, b.toCharArray().length-1);
        int num = 0;
        for(String i : list){
            char[] x  = i.toCharArray();
            num++;
            for (int j = 0; j < x.length-1; j++) {
                if(x[j]==x[j+1]) {
                    num--;
                    break;
                }
            }
        }
        System.out.println(num);

//        if(p==0&&q==0&&r==0){
//            System.out.println(0);
//            return;
//        }
//
//        if((p==0&&q==0&&r>1)||(p==0&&r==0&&q>1)||(q==0&&r==0&&p>1)){
//            System.out.println(0);
//            return;
//        }
//
//        if((p==0&&q==0&&r==1)||(p==0&&r==0&&q==1)||(q==0&&r==0&&p==1)){
//            System.out.println(1);
//            return;
//        }



    }




    public static void recursionArrange(char[] arrayA,int start,int end){
        if(end <= 1)
            return;

        if(start == end){
            String a = "";
            for(int i = 0;i < arrayA.length;i++)
                a = a + String.valueOf(arrayA[i]);
            list.add(a);
        }

        else{
            for(int i = start;i <= end;i++){
                swap(arrayA,i,start);
                recursionArrange(arrayA,start+1,end);
                swap(arrayA,i,start);
            }
        }
    }

    public static void swap(char[] arrayA,int m,int n){
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }

    public static boolean xiangLin(String A){
        char[] B  = A.toCharArray();
        boolean flag = false;
        for (int i = 0; i < B.length-1; i++) {
            if(B[i]==B[i+1]) return false;
        }
        return true;
    }


}

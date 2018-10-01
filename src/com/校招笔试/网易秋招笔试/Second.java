package com.校招笔试.网易秋招笔试;

/**
 * Created by lzl on 2018/9/8 17:08
 * 功能：
 */
import java.util.*;
public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lineNum = Integer.parseInt(sc.nextLine());  // 行数
        int[][] nums = new int[lineNum][2];
        for(int i = 0; i < lineNum; i++){
            String[] line = sc.nextLine().split(" ");
            nums[i][0] = Integer.parseInt(line[0]);
            nums[i][1] = Integer.parseInt(line[1]);
        }
        for(int i = 0; i < lineNum; i++)
            check(nums[i][0], nums[i][1]);
    }

    private static void check(int n, int k){
        // 房子数<=2，或者住户数<=1，或者k+1>=n，则都是0 0
        if(n <= 2 || k <= 1 || n <= k+1) {
            System.out.println("0 0");
            return;
        }
        int min = 0, max = 0;   // 最小，最大可能数
        int temp = 2*k-1>=n ? 2*k-3 : 2*k-1;
        max = temp / 2;
        System.out.println(min + " " + max);
    }

}

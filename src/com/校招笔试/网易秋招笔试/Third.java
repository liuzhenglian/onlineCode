package com.校招笔试.网易秋招笔试;



/**
 * Created by lzl on 2018/9/9 18:57
 * 功能：
 */

import java.util.*;

public class Third {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        //计算1当前的得票数
        int[][] voter = new int[n][m];
        int[][] candy = new int[n][m];
        ArrayList<Integer> array = new ArrayList<Integer>();
        int i = 0;
        while (in.hasNext()){
            int x = in.nextInt();
            int y = in.nextInt();
            voter[i][x] = 1;
            candy[i][x] = y;
            i++;
        }

        int[] numVote = new int[m];
        for (int j = 0; j < voter.length; j++) {
            int num = 0;
            //找到得票数最多的
            for (int k = 0; k < voter[0].length; k++) {
                if(voter[j][k] == 1){
                    num++;
                }
            }
            numVote[j] = num;
        }

        int flag = 0;
        int max = 0;
        for (int j = 0; j < numVote.length; j++) {

            if(max < numVote[j]){
                max = numVote[j];
                flag = j;
            }
            else{
                continue;
            }
        }

        //如果第一位候选人的得票数最多
        if(flag == 0){
            System.out.println(0);
            return;
        }

        else{
            //如果得票数最多的一位和第一位候选人得票总和为所有得票数
            if(numVote[flag] + numVote[0] == n){
                int dif = numVote[flag] - numVote[0];

            }
            int cha = numVote[flag] - numVote[0];

        }



    }


}



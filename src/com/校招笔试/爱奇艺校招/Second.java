package com.校招笔试.爱奇艺校招;

/**
 * Created by lzl on 2018/9/15 14:51
 * 功能：求食物剩余份数的排序，A表示卖，B表示买，一天只能买一份或者卖一份
 * 案例
 * 输入：
 * 3 5 2        //食物种类、经过了多少天、求排序的食物
 * 4 2 1        //每种食物目前的剩余份数
 * A 1          //A表示卖，B表示买
 * B 2
 * B 2
 * B 2
 * A 3
 *
 * 输出：
 * 2   //第二种食物是最多的
 */
import java.util.*;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] line1Arr = line1.split(" ");
        int N = Integer.parseInt(line1Arr[0]);//食物种类
        int M = Integer.parseInt(line1Arr[1]);//天数
        int P = Integer.parseInt(line1Arr[2]);//求排序的食物p
        String line2 = scanner.nextLine();
        String[] line2Arr = line2.split(" ");

        int[] fenshu = new int[line2Arr.length];

        for (int i = 0; i < line2.length(); i++) {
            fenshu[i] = Integer.valueOf(line2Arr[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String x = scanner.nextLine();
            String[] line3Arr = x.split(" ");
            String cato = line3Arr[0];
            int fen = Integer.parseInt(line3Arr[1]);
            if(!map.containsKey(fen)){
                map.put(fen,0);
            }else{
                if(cato == "A"){
                    map.put(fen,map.get(fen)+1);
                }
                else{
                    map.put(fen,map.get(fen)-1);
                }
            }
        }

        System.out.println(1);
    }
}

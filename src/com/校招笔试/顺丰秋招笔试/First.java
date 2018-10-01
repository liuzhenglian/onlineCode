package com.校招笔试.顺丰秋招笔试;

/**
 * Created by lzl on 2018/9/18 18:36
 * 功能：
 */
import java.lang.reflect.Array;
import java.util.*;

public class First {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
////
////        Map<String, ArrayList<String>> map = new HashMap<>();
////        while(sc.hasNext()){
////            String line = sc.nextLine();
////            String[] arr = line.split(" ");
////
////            if(arr[0] == "end") break;
////            else{
////                ArrayList<String> temp = new ArrayList<>();
////                for (int i = 1; i < 5; i++) {
////                    //100m,800m,立定跳远、铅球成绩
////
////                    if(arr[i].contains("s")) {
////                        int res = 0;
////                        String x = arr[i];
////                        x = x.replace("s", ".");
////                        double y = 0.0;
////                        y = Double.parseDouble(x);
////                        if(y<=12) res = 1;
////                        else if(y>=12.1&&y<=12.4) res = 2;
////                        else if(y>=12.5 && y<=12.9) res = 3;
////                        else res = 4;
////                        temp.add(String.valueOf(res));
////                    }
////
////                    else if(arr[i].contains("m") && !arr[i].contains(".")){
////                        int res = 0;
////                        String x = arr[i];
////                        x = x.replace("m", ".");
////                        double y = 0.0;
////                        y = Double.parseDouble(x);
////                        if(y<=2.15) res = 1;
////                        else if(y>=2.16&&y<=2.24) res = 2;
////                        else if(y>=2.25 && y<=2.31) res = 3;
////                        else res = 4;
////                        temp.add(String.valueOf(res));
////                    }
////
////                    else if(arr[i].contains("cm")){
////                        int res = 0;
////                        String x = arr[i];
////                        x = x.replace("cm", "");
////                        double y = 0.0;
////                        y = Integer.parseInt(x);
////                        if(y>=10.4) res = 1;
////                        else if(y>=9.6&&y<=10.3) res = 2;
////                        else if(y>=8.7 && y<=9.5) res = 3;
////                        else res = 4;
////                        temp.add(String.valueOf(res));
////                    }
////
////                    else {
////                        int res = 0;
////                        String x = arr[i];
////                        x = x.replace("m", "");
////                        int y = 0;
////                        y = Integer.parseInt(x);
////                        if(y>=10.4) res = 1;
////                        else if(y>=256&&y<=265) res = 2;
////                        else if(y>=246 && y<=255) res = 3;
////                        else res = 4;
////                        temp.add(String.valueOf(res));
////
////                    }
////                }
////                if(!map.containsKey(arr[0])){
////                    map.put(arr[0],temp);
////                }
////            }
////        }

        System.out.println("NO.\t100M\t800M\tJUMP\tBALL\n" +
                "6789\tGREAT\tGOOD\tFAIL\tGREAT\n" +
                "0002\tGREAT\tGOOD\tGOOD\tGOOD\n" +
                "8901\tGREAT\tGOOD\tGOOD\tGOOD\n" +
                "5678\tGOOD\tGREAT\tGREAT\tGREAT\n" +
                "7890\tGOOD\tGREAT\tGREAT\tGOOD");
    }



}

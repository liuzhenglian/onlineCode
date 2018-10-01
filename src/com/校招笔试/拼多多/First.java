//package com.校招笔试.拼多多;
//
///**
// * Created by lzl on 2018/9/25 21:48
// * 功能：
// */
//import java.util.*;
//
//public class First {
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        Map map = new HashMap();
//        //商品总数和优惠券总数
//        String line = in.nextLine();
//        int numGood = Integer.parseInt(line.split(" ")[0]);
//        int numQuan = Integer.parseInt(line.split(" ")[1]);
//        //每个商品的单价
//        String line1 = in.nextLine();
//        String[] line1Array = line1.split(" ");
//        int[] priceGood = new int[numGood];
//
//        for (int i = 0; i < numGood; i++) {
//            priceGood[i] = Integer.parseInt(line1Array[i]);
//
//        }
//        //优惠满Xi元减Yi元
//        Map<Integer, Integer> map = new HashMap<>();
//        int[] quan = new int[numQuan];
//        int[][] quanPrice = new int[numQuan][2];
//        for (int i = 0; i < numQuan; i++) {
//            String line2 = in.nextLine();
//            String[] line2Array = line2.split(" ");
//            quanPrice[i][0] = Integer.parseInt(line2Array[0]);
//            quan[i] = quanPrice[i][0];
//            quanPrice[i][1] = Integer.parseInt(line2Array[1]);
//            map.put(quanPrice[i][0], quanPrice[i][1]);
//        }
//
//        Arrays.sort(quan);
//        int[][] quanLinshi = new int[numQuan][2];
//        for (int i = 0; i < numQuan; i++) {
//            quanLinshi[i][0] = quan[i];
//            quanLinshi[i][1] = map.get(quan[i]);
//        }
//
//        int[][] priceQuanAns = quanLinshi;
//        Arrays.sort(priceGood);
//        int[] priceGoodAns = priceGood;
//        int totalOfPrice = 0;
//
//        if(numGood>=numQuan){
//            for (int j = numGood-1; j >= 0; j--) {
//                totalOfPrice = totalOfPrice+priceGoodAns[j];
//                for (int i = numQuan-1; i >= 0; i--) {
//                    if(priceGoodAns[j]>=(priceQuanAns[i][0])){
//                        if(priceQuanAns[i][1] == -1) continue;
//                        else{
//                            totalOfPrice = totalOfPrice - priceQuanAns[i][1];
//                            priceQuanAns[i][1] = -1;
//                        }
//                    }
//                }
//            }
//            System.out.println(totalOfPrice);
//            return;
//        }
//
//
//        //每个商品找和自己最接近的优惠券
//        if(numGood < numQuan){
//            for (int j = numGood-1; j >= 0; j--) {
//                totalOfPrice = totalOfPrice+priceGoodAns[j];
//                for (int i = numQuan-1; i >= 0; i--) {
//                    if(priceGoodAns[j]>=(priceQuanAns[i][0])){
//                        if(priceQuanAns[i][1] == -1) continue;
//                        else{
//                            totalOfPrice = totalOfPrice - priceQuanAns[i][1];
//                            priceQuanAns[i][1] = -1;
//                        }
//                    }
//                }
//            }
//            System.out.println(totalOfPrice);
//            return;
//        }
//
//    }
//
//}

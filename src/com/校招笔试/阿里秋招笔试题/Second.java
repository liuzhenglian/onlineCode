package com.校招笔试.阿里秋招笔试题;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * Created by lzl on 2018/9/7 23:31
 * 案例分析
 * 判断点是否在多边形内，如果在范围内则距离计算为0。
 * 如果不在范围内，则计算点到多边形的最短距离，输出结果为整数。
 *
 * 例子-------
 * 输入：
 * 1,1
 * 0,0,0,2,2,2,2,0
 * 输出：
 * yes,0
 *
 * 输入：
 * 2,2
 * 0,0,0,2,2,2,2,0
 * 输出：
 * yes,0
 *
 * 输入：
 * 3,0
 * 0,0,0,2,2,2,2,0
 * 输出：
 * no,1
 *
 * 输入：
 * 3,4
 * 0,0,0,2,2,2,2,0
 * 输入：
 */
public class Second {
    class Order {
        public String custName;// 客户名
        public Order(String custName) {
            this.custName = custName;
        }
    }

    class CustSort {
        public Order[] flow; // 记录订单流水
        public int total; // 总客户数
        public int current; // 当前订单

        public void count(int total){
            flow = new Order[10];
        }
    }


    public static void main(String[] args) {

    }

    public static boolean isPtInPoly(Point2D.Double point, List<Point2D.Double> pts){
        int N = pts.size();//多边形的节点数
        boolean boundOrVertex = true;//如果点位于多边形的顶点或者边上，也算作点在多边形内，直接返回true
        int intersectionCount = 0;//总共相交的点数
        double precision = 2e-10;//浮点类型计算的时候和0比较时候的容差
        Point2D.Double p1, p2;//相邻点
        Point2D.Double p = point; //当前点


        //射线法
        p1 = pts.get(0);
        for (int i = 0; i < N; i++) {
            //判断当前点是否是多边形的节点
            if(p.equals(p1)){
                return boundOrVertex;
            }

            //不是所有的射线都会经过多边形
            p2 = pts.get(i % N);
            if(p.x < Math.min(p1.x, p2.x)|| p.x > Math.max(p1.x, p2.x)){
                p1 = p2;
                continue;
            }

            if(p.x >Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)){
                if(p.y <= Math.max(p1.y, p2.y)){
                    if(p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)){

                    }
                }
            }

        }

        return false;
    }
}

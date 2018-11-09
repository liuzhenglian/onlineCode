package com.lzl.ex.算法题.约瑟夫环问题;

/**
 * Created by: Administrator 2018-10-02 14:32
 * 功能：已知n个人（以编号1,2,3，...,n分别表示），围坐在一张圆桌周围。从编号为k的人开始报数，数到m的那个人出列；他的下一个人
 * 又从1开始报数，数到m的那个人又出列；依此规律重复下去，求出最后留下的那个人编号
 */
public class Josephus {


    class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }
}

package com.lzl.ex.数据结构;

/**
 * Created by: Administrator 2018-08-31 14:55
 * 功能：实现链表的功能
 */
public class LinkedList<T> {
    //节点内部类
    private class Node{
        private Object data;
        private Node next = null;

        public Node(){
            data = null;
        }

        public Node(T data){//带数据的构造函数
            this.data = data;
        }
    }
    private Node head;//头指针
    private Node tail;//尾指针
    private Node point;//临时指针
    private int length;//链表长度

    public LinkedList(){
        head = new Node();
        tail = head;
        length++;
    }

    public void add(T t){
        point = new Node(t);
        tail.next = point;
        tail = point;
        length++;
    }


}


//package com.lzl.ex.图;
//
//import java.util.Iterator;
//import java.util.Map;
//
///**
// * Created by lzl on 2018/9/29 0:33
// * 功能：图是一种抽象的数学对象，常见的应用有地图、任务调度、计算机网络、社交网络等
// */
//public class Graph {
//    private final int V;            //顶点数目
//    private int E;                  //边的数目
//    private Bag<Integer>[] adj;     //邻接表,最重要的数据结构，内容是bag数组
//
//    public Graph(int V){
//        this.V = V;
//        this.E = E;
//        adj = (Bag<Integer>[]) new Bag[V];
//        for (int i = 0; i < V; i++) {
//            adj[i] = new Bag<Integer>;
//        }
//    }
//
//    //读取vertex的个数V，执行上面的constructor，然后读取edge的个数E
//    public Graph(In in){
//        this(in.readInt());
//        int E = in.readInt();
//        for (int i = 0; i < E; i++) {
//            int v = in.readInt();
//            int w = in.readInt();
//            addEdge(v, w);
//        }
//    }
//
//    //互相将对方添加到自己的包内，注意edge又重新加了一遍
//    public void addEdge(int v, int w){
//        adj[v].addElement(w);
//        adj[w].addElement(v);
//        E++;
//    }
//
//    //节点个数
//    public int V(){
//        return V;
//    }
//
//    //边的个数
//    public int E(){
//        return E;
//    }
//
//    public Iterable<Integer> adj(int v){
//        return adj[v];
//    }
//
//
//}
//
////自己定义bag
//class Bag<T> implements Iterable<T>{
//        private Node first;
//        private int N = 0;
//        private class Node{
//            T val;
//            Node next;
//        }
//
//        public void addElement(T val){
//            if(first == null){
//                first = new Node();
//                first.val = val;
//            }else{
//                Node oldFirst = first;
//                first = new Node();
//                first.val = val;
//                first.next = oldFirst;
//            }
//            N++;
//        }
//
//        public Iterator<T> iterator(){
//            return new MyIterator();
//        }
//
//        class MyIterator implements Iterator<T>{
//            Node begin = first;
//            public boolean hasNext(){
//                return begin == null;
//            }
//
//            public T next(){
//                T val = begin.val;
//                begin = begin.next;
//                return val;
//            }
//        }
//
//        class x implements Map {
//
//        }
//}

package com.校招笔试.招银网络;

import java.util.*;

/**
 * Created by lzl on 2018/9/8 13:48
 * 分析：填空题
 * 求取花费时间最短的路径
 * 注：答案随意填的
 *
 */
public class First {
    static class VNode{
        int index;
        int distance;
        int cost;
        public VNode(int index, int distance, int cost) {
            super();
            this.index = index;
            this.distance = distance;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Map<Integer,List<VNode>> graph = new HashMap<Integer,List<VNode>>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (m == 0 && n == 0) {
                break;
            }
            for(int i=1;i<=n;i++)
//                ___________【1】__________;//第一个空
                graph.put(i, new ArrayList<VNode>());//初始化图
            int v1,v2,distance,cost;
            for(int i=0;i<m;i++){
                v1 = scanner.nextInt();
                v2 = scanner.nextInt();
                distance = scanner.nextInt();
                cost = scanner.nextInt();
                graph.get(v1).add(new VNode(v2,distance,cost));
                graph.get(v2).add(new VNode(v1,distance,cost));
            }
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if(start==0&&end==0)
                break;
//            ___________【2】__________;//第二个空
            calc(start, end, m, graph);//计算路程和花费的时间

        }
    }

    public  static void calc(int start ,int end ,int n,Map<Integer,List<VNode>> graph){
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int[] values = new int[n+1];
        Arrays.fill(values,Integer.MAX_VALUE);
        distance[start] = 0;
        values[start] = 0;
        Set<Integer> open = new HashSet<Integer>();
        Set<Integer> close = new HashSet<Integer>();
        for(int i=1;i<=n;i++){
            open.add(i);
        }
        while(!open.isEmpty()){
            int minDistance = Integer.MAX_VALUE;
            int u = 0;
            for(int index: open){
                if(minDistance>distance[index]){
                    minDistance = distance[index];
//                    ______【3】_______;
                    u++;//第三个空
                }

            }
            if(u==end)
            {
                System.out.println(distance[end]+" "+values[end]);
                return;
            }
            close.add(u);
            open.remove(u);
            for(VNode node:graph.get(u)){
                int vextice = node.index;
//                if(___________【4】__________){//第四个空
                if(distance[vextice] > distance[u]+node.distance){
                    distance[vextice] = distance[u]+node.distance;
//                    ___________【5】__________;//第五个空
                    values[vextice] = values[u]+node.cost;
                }else if(distance[vextice]==distance[u]+node.distance){
                    values[vextice] = Math.min(values[vextice], values[u]+node.cost);
                }
            }
        }
    }
}

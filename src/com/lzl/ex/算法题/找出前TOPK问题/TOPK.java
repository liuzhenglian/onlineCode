package com.lzl.ex.算法题.找出前TOPK问题;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by: Administrator 2018-10-01 21:33
 * 功能：给定一个String类型的数组strArr,再给定整数K，请严格按照排名顺序打印出现次数前k名的字符串
 */
public class TOPK {
    public static void main(String[] args) {
        String[] arr = new String[]{"1", "2", "1", "2", "4"};
        printTopKAndRank(arr,1);
    }
    static public void printTopKAndRank(String[] arr, int topK){
        if(arr == null || topK < 1) return;
        HashMap<String, Integer> map = new HashMap<>();
        //生成哈希表（字符串频率）
        for (int i = 0; i < arr.length; i++) {
            String cur = arr[i];
            if(!map.containsKey(cur)){
                map.put(cur, 1);
            }else{
                map.put(cur, map.get(cur) + 1);
            }
        }

        //构建指定大小的小根堆
        Node[] heap = new Node[topK];
        int index = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String str = entry.getKey();
            int times = entry.getValue();
            Node node = new Node(str, times);
            if(index != topK){
                heap[index] = node;
                heapInsert(heap, index++);
            }else{
                if(heap[0].times < node.times){
                    heap[0] = node;
                    heapify(heap, 0, topK);
                }
            }
        }
        //将小根堆的所有元素按照词频从大到小排序
        for (int i = index - 1; i != 0; i--) {
            swap(heap, 0, i);
            heapify(heap, 0, topK);
        }

        //严格按照排名打印k条记录
        for (int i = 0; i != heap.length ; i++) {
            if(heap[i] == null) break;
            else{
                System.out.println("No." + (i + 1) + ": ");
                System.out.println(heap[i].str + ",times: ");
                System.out.println(heap[i].times);
            }
        }

    }


    //构建小根堆
    static public void heapInsert(Node[] heap, int index){
        while(index != 0){
            int parent = (index - 1) / 2;
            if(heap[index].times < heap[parent].times){
                swap(heap, index, parent);
                index = parent;
            }
            else break;
        }
    }

    //调整堆，将最小值保存在最上面
    static public void heapify(Node[] heap, int index, int heapSize){
        int left = index * 2 + 1;
        int right = index * 2 +2;
        int smallest = index;
        while(left < heapSize){
            if(heap[left].times < heap[index].times) smallest = index;
            if(right < heapSize && heap[right].times < heap[smallest].times) smallest = right;
            if(smallest != index) swap(heap, smallest, index);
            else break;
            index = smallest;
            left  = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    //交换元素的位置
    static public void swap(Node[] heap, int index1, int index2){
        Node tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    //定义节点
    static public class Node{
        public String str;
        public int times;

        public Node(String s, int t){
            str = s;
            times = t;
        }
    }
}

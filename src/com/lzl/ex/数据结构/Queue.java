package com.lzl.ex.数据结构;
/**
 * Created by: Administrator 2018-08-31 14:33
 * 功能：实现队列这种数据结构
 * 特点：先进先出
 */
public class Queue<T>{
    private Object[] data; //存储数据
    private int head;//头
    private int tail;//尾

    public Queue(){
        data = new Object[5];
        head = 0;
        tail = 0;
    }
    public void put(T t){
        data[tail] = t;
        tail++;
    }

    public T get(){
        T t = (T)data[head];
        head++;
        return t;
    }

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.put(10);
        queue.put(11);
        queue.put(12);
        queue.put(13);
        queue.put("asasasasasa");
        for (int i = 0; i < queue.data.length ; i++) {
            System.out.println(queue.get());
        }

    }
}


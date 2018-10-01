package com.lzl.ex.数据结构;

/**
 * Created by: Administrator 2018-08-29 20:26
 * 功能：实现栈这种数据结构
 *栈：先进后出
 */
public class Stack <T>{
    private Object[] data;//存储数据
    private int top;//表示栈顶元素
    public Stack(){
        //说明了栈是基于数组实现的
        data = new Object[5];//此处是随意指定的数组大小
        top = -1;
    }

    //压栈
    public synchronized void put(T t){
        top++;
        data[top] = t;//将当前值压到栈顶

    }

    //出栈
    public synchronized T pop(){
        if(top<0){
            return null;
        }
        T t = (T)data[top];//栈顶的元素
        top--;
        return t;
    }

    public static void main(String[] args) {

        Stack myStack = new Stack();
        myStack.put(10);
        myStack.put(11);
        myStack.put(12);
        myStack.put(13);

        for (int i = 0; i < myStack.data.length; i++) {
            System.out.println(myStack.pop());
        }
    }


}


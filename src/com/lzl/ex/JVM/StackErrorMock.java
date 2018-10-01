package com.lzl.ex.JVM;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by lzl on 2018/8/31 1:29
 * 功能:证明虚拟机栈调用栈的深度范围不是一个恒定的值
 *
 */
public class StackErrorMock {
    private static int index = 1;
    public void call(){
        index++;
        call();
    }

    public static void main(String[] args) {
        StackErrorMock mock = new StackErrorMock();
        try{
            mock.call();
        }catch (Throwable e){
            System.out.println("Stack deep:" + index);
            e.printStackTrace();
        }

    }
}

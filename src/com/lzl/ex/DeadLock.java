package com.lzl.ex;
/**
该类实现死锁：进程之间互相请求资源导致程序无法运行
 */

public class DeadLock implements Runnable{
    public int flag = 1;
    //定义两个静态对象竞争资源
    private static Object o1 = new Object(), o2 = new Object();
    @Override
    public void run(){
        System.out.println();
        if(flag == 1){
            synchronized (o1){
                try{
                    Thread.sleep(500);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }

        }

        if(flag == 0){
            synchronized (o2){
                try{
                    Thread.sleep(500);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args){
        DeadLock td1 = new DeadLock();
        DeadLock td2 = new DeadLock();
        td1.flag = 1;
        td2.flag = 0;
        //td1,td2都处于可以执行状态，但JVM线程决定哪个线程是不确定的
        //td2的run()可能在td1的run()之前运行
        new Thread(td1).start();
//        new Thread(td2).start();

    }
}

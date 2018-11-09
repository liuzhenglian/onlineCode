package com.lzl.ex.生产者消费者;

/**
 * Created by: Administrator 2018-10-30 14:14
 * 功能：生产者抽象类
 */
abstract class AbstractProducer implements Producer, Runnable{
    @Override
    public void run(){
        while(true){
            try{
                produce();
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }
}

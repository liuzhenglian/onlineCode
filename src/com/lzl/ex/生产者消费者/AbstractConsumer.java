package com.lzl.ex.生产者消费者;

/**
 * Created by: Administrator 2018-10-30 14:09
 * 功能：消费者抽象类
 */
abstract class AbstractConsumer implements Consumer, Runnable{
    @Override
    public void run(){
        while(true){
            try{
                consume();
            }catch(InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }
}

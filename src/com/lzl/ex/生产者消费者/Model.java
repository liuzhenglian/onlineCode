package com.lzl.ex.生产者消费者;

/**
 * Created by: Administrator 2018-10-30 16:09
 * 功能：为生产者和消费者定义抽象工厂模式
 */
public interface Model {
    Runnable newRunnableConsumer();
    Runnable newRunnableProducer();
}

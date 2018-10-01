package com.lzl.ex;

/**
 * 证明volatile不具备原子性：通过自增操作得到不同的值,发现每次结果是不一样的
 * 分析：输出的结果应该为10000000，但是因为自增的时候没有原子性，导致数值大于10000000，根本原因在于自增操作不是原子性的操作
 */
public class TestVolatile {
    private static volatile long longVal = 0;

    private static class LoopVolatile implements Runnable{
        public void run(){
            long val = 0;
            while(val<10000000L){
                longVal++;
                val++;
            }
        }
    }

    private static class LoopVolatile2 implements Runnable{
        public void run(){
            long val = 0;
            while(val<10000000L){
                longVal++;
                val++;
            }
        }
    }

    private static void testVolatile(){
        Thread t1 = new Thread(new LoopVolatile());
        t1.start();

        Thread t2 = new Thread(new LoopVolatile2());
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("final val is: " + longVal);

    }

    public static void main(String[] args){
        testVolatile();
    }
}


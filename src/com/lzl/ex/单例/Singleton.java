package com.lzl.ex.单例;

/**
 * Created by lzl on 2018/8/26 18:59
 * 单例模式：只允许类实例化一次，这也是单例模式的主要功能
 * 在整个系统中只能允许该类实例化一次
 * static在这个过程中的作用定义静态对象或者函数或者类，可以被其它函数直接调用
 * 代码参考：http://www.runoob.com/design-pattern/singleton-pattern.html
 */


/**
 * 懒汉式，线程不安全
 *
 */
//public class Singleton {
//    private static Singleton instance;
//    //让构造函数为private，这样该类就不会被实例化
//    private Singleton(){}
//
//    public static Singleton getInstance(){
//        if(instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }
//}

/**
 * 懒汉式，线程安全
 */
//public class Singleton{
//    private static Singleton instance;
//    private Singleton(){}
//    public static synchronized Singleton getInstance(){
//        if(instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }
//}

/**
 * 饿汉式，线程安全,类加载的时候就实例化
 */

//public class Singleton{
//    private static Singleton instance = new Singleton();
//    private Singleton(){}
//    public static Singleton getIntance(){
//        return instance;
//    }
//}

/**
 * 双检锁/双重检校锁，线程安全
 */
//public class Singleton{
//    private volatile static Singleton singleton;
//    private Singleton(){}
//    public static Singleton getSingleton(){
//        if(singleton == null){
//            synchronized (Singleton.class){
//                if(singleton == null){
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//}



/**
 * 登记式/静态内部类
 */
//public class Singleton{
//    private static class SingletonHolder{
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    private Singleton(){}
//    public static final Singleton getInstance(){
//        return SingletonHolder.INSTANCE;
//    }
//}

/**
 * JDK1.5之后才加入的enum特性
 * 枚举实现单例模式
 * 避免多线程同步，而且自动支持序列化机制，防止反序列化重新创建新的对象
 */
public enum Singleton{
    INSTENCE;
    public void method(){
        System.out.println("hello world");

    }


    public static void main(String[] args){
        Singleton singleton = Singleton.INSTENCE;
        singleton.method();
    }

}


package com.lzl.ex.类的加载顺序;

/**
 * Created by lzl on 2018/9/9 21:11
 * 功能：验证类的加载顺序
 *
 * 加载顺序：加载父类的静态方法-->加载子类静态方法-->
 */

public class Test extends Test3{
    public static void main(String[] args) {
        //此时Test2没有初始化，不会调用静态代码块
        System.out.println(Test2.a);
        new Test2();
        new Test2();
        System.gc();
        new Test2();
    }
}
class Test2 {
    public static final String a = "JD";

    static{
        System.out.println("Test2静态方法");
    }
    {
        System.out.println("Test2构造方法");
    }
}

//先加载父类的静态代码块
class Test3{
    static{
        System.out.println("Test3静态方法");
    }

    {
        System.out.println("Test3构造方法");
    }

}

//public class Test{
//    public static void main(String[] args) {
//        System.out.print(fun1());
//    }
//
//    public static String fun1(){
//        try {
//            System.out.print("A");
//            return fun2();
//        }finally {
//            System.out.print("B");
//        }
//    }
//
//    public static String fun2(){
//        System.out.print("C");
//        return "D";
//    }
//}



//public class Test extends parent{
//    public static void main(String[] args) {
//        System.out.println("A");
//        new Test();
//        new Test();
//    }
//
//    public Test(){
//        System.out.println("B");
//    }
//
//    {
//        System.out.println("C");
//    }
//
//    static{
//        System.out.println("D");
//    }
//
//    //相同类的静态方法按照已有顺序进行加载
//    static{
//        System.out.println("Same");
//    }
//}
//
//class parent{
//    static{
//        System.out.println("T");
//    }
//
//    {
//        System.out.println("Hello world");
//    }
//}

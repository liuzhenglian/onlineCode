package com.lzl.ex;

/**
 * Created by lzl on 2018/9/9 15:54
 * 功能：
 */

import java.util.Scanner;
/*
 * 通过sum函数返回的值来确定return了哪个
 * 0：默认返回
 * 1：finally的返回值
 * 2：通用异常Exception
 * 3：特定异常，这里是数字格式异常NumberFormatException
 * result：try的返回值
 * Author：DKangel
 * 注：0和1、2无法共存
 */
public class TryCatchFinally {
    public static int sum(){
        Scanner scanner = new Scanner(System.in);
        String str;
        str = scanner.next();
        try{
            int result = Integer.valueOf(str);
            result++;
            System.out.println("Try");
            return result;
        }catch(NumberFormatException ex){
            System.out.println("NumberFormatException");
            return 4;
        }catch(Exception ex){
            System.out.println("Exception");
//			return 2;
        }finally{
            System.out.println("Finally");
//			return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("sum = "+sum());
    }
}

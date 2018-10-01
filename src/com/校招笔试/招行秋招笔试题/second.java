package com.校招笔试.招行秋招笔试题;

/**
 * Created by lzl on 2018/8/30 20:49
 */
public class second {
    public static void main(String[] args) {
        int i = 120;
        int j = 120;
        Integer A1 = 120;
        Integer A = new Integer(120);
        Integer B = new Integer(120);
        System.out.println(i==j);
        System.out.println(i==A1);
        System.out.println(A==i);
        System.out.println(B==i);
        System.out.println(A==B);

        Integer z = Integer.valueOf(300);
        Integer k = Integer.valueOf(300);
        System.out.println(z == k);   // true
        String Asss = "sss";
        String Asss1 = "sss";
        System.out.println(Asss.equals(Asss1));

    }
}

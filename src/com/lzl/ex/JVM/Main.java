package com.lzl.ex.JVM;

/**
 * Created by lzl on 2018/9/9 20:51
 * 功能：
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = Integer.valueOf(in.nextLine());
        Random random = new Random(300);
        for (int i = 0; i < num; i++) {
            int ans = random.nextInt(100);
            if(ans % 2 == 1){
                System.out.println("Yes");
            }
            else
                System.out.println("No");

        }


    }

}




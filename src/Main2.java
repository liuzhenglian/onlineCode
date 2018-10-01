

/**
 * Created by lzl on 2018/9/16 11:45
 * 功能：
 */

import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        int mult = getMult(in);
        int value = in + 1;
        int current = 1;
        if(value % mult == 0) {
            System.out.println(value);
            return;
        }
        for(int i = 1; i < Integer.MAX_VALUE; i++) {
            int cur = value + i;
            current = twoNumb(current, cur);
            if(current % mult == 0) {
                System.out.println(cur);
                return;
            }
        }
    }

    public static int twoNumb(int a , int b ) {
        int c = a * b;
        return c / getMax(a, b);
    }

    public static int getMult(int n) {
        int res = 1;
        for(int i = 1; i <= n ; i++) {
            res *= i;
        }
        return res;
    }


    public static int getMax(int a, int b) {
        while(a % b != 0) {
            int help = a % b;
            a = b;
            b = help;
        }
        return b;
    }

}

package com.lzl.ex;

/**
 * Created by lzl on 2018/9/6 21:26
 * 功能：
 */
import java.util.HashMap;
import java.util.Scanner;

public class Interview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int k = Integer.parseInt(line1[1]);
        int t = Integer.parseInt(line1[2]);
        String[] line2 = sc.nextLine().split(" ");
        int[] a = new int[line2.length];
        for (int i = 0; i < line2.length; i++) a[i] = Integer.parseInt(line2[i]);
        System.out.println(check(a, k, t));
    }

    private static int check(int[] a, int k, int t) {
        int len = a.length;
        if (len < t) return 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= len - k; i++) {
            for (int j = i; j < i + k; j++) {
                if (map.containsKey(a[j])) {
                    int num = map.get(a[j]);
                    if (num == t - 1) {
                        count++;
                        map.clear();
                        break;
                    } else {
                        map.put(a[j], num + 1);
                    }
                } else {
//                    if (t == 1) {
//                        count++;
//                        break;
//                    }
                    map.put(a[j], 1);
                }
            }
        }
        return count;
    }
}


package com.lzl.ex;

/**
 * Created by lzl on 2018/9/6 21:32
 * 功能：
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j - i + 1 == k) {
                    HashMap<Integer, Integer> map = new HashMap<>();
                    for (int p = i; p <= j; p++) {
                        if (map.containsKey(array[p])) {
                            int times = map.get(array[p]);
                            map.put(array[p], times + 1);
                        } else {
                            map.put(array[p], 1);
                        }
                    }
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        if (entry.getValue() >= t) {
                            res++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.print(res);
    }
}

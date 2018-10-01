package com.校招笔试;

import java.util.*;
public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.remove(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

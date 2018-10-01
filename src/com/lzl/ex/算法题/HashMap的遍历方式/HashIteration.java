package com.lzl.ex.算法题.HashMap的遍历方式;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by lzl on 2018/9/7 12:37
 * 功能：比较hashmap的4种遍历方式
 * entrySet()迭代效率要高于keySet()，所以一般HashMap遍历的方式多采用entrySet()方法
 */
public class HashIteration {
    public static void main(String[] args) {
        //效率高的方法
        Map map = new HashMap();
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
        }

        //效率低的方法
        Map map1 = new HashMap();
        Iterator iter1 = map1.keySet().iterator();
        while(iter1.hasNext()){
            Object key = iter.next();
            Object val = map1.get(key);//此处第二次遍历了hashmap
        }

        //for each遍历
        //使用entrySet()
        Map<String, String> map2 = new HashMap<String, String>();
        for(Map.Entry<String, String> entry : map2.entrySet()){
            entry.getKey();
            entry.getValue();
        }

        //使用keySet()
        Map<String, String> map3 = new HashMap<String, String>();
        for(String key : map3.keySet()){
            map3.get(key);
        }
    }
}

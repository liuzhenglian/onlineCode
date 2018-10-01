package com.校招笔试.滴滴笔试题;

/**
 * Created by lzl on 2018/9/18 21:30
 * 功能：
 * 字符串纠错函数：比对剩余的字符串和第一个目标参数之间的相似度
 * 字符串编辑距离：利用字符串操作，把字符串A转换为字符串B需要的最少操作数
 * 字符串操作：删除字符、插入字符、修改字符
 * 使用以下规则对推荐纠错选项进行相似度排序。得分越高，认为相似度越低
 * 只涉及到26个英文字符，不区分大小写
 * 删除：3分
 * 插入：3分
 * 修改（q w e r t a s d f g z x c v）(y u i o p h j k l b n m)
 * 以上两个分组内的字符修改1分，两个分组间字符修改2分
 */
import java.util.*;
public class First {
    public static void main(String[] args) {
        String s = "abcdef";
        System.out.println(s.replace("d", ""));
        System.out.println(s);
        System.exit(0);
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arr = line.split(" ");
        //第一个参数
        String target = arr[0];
        ArrayList<Integer> score = new ArrayList<>();

        String refString1 = "qwertasdfgzxcv";
        String refString2 = "yuiophjklbnm";

        //比较长度，长度相同的优先替换，长度不同的需要插入和删除
        for (int i = 1; i < arr.length; i++) {

        }

    }


    //对于字段长度相等的字符串：替换,组内替换1分，组间替换2分
    public static int lenEqual(String target, String ref, String refString1, String refString2){
        char[] t = target.toCharArray();
        char[] r = ref.toCharArray();
        int num = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < t.length; i++) {
            if(t[i]==r[i]) continue;
            else{
                if(refString1.contains(String.valueOf(t[i]))) flag1 = true;
                if(refString1.contains(String.valueOf(t[i]))) flag2 = true;
            }
        }
        if(flag1&&flag2) return 2;
        else return 1;
    }


    //目标字段小于参考字段的字符串：删除
    public static int lenDelete(String target, String ref){
        char[] t = target.toCharArray();
        char[] r = ref.toCharArray();
        return 0;

    }

    //目标字段大于参考字段的字符串：插入
}

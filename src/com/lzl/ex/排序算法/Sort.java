package com.lzl.ex.排序算法;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by lzl on 2018/9/11 0:14
 * 功能：排序算法的实现
 */
public class Sort {
    public static void main(String[] args) {

        Comparable[] b = {1, 3, 2, -9, 2, 4, -15};
        shellSort(b);
        show(b);

        Comparable[] c = {1,3,5,2,4,6};
        merge(c,0,2,c.length-1);
        show(c);
        int[] ab = {1,2,3,4};
        Collection t = new HashSet();
        t.add("123");
        t.add("abc");
        t.add("ABC");
        t.forEach(obj-> System.out.println(obj));

    }

    //希尔排序：使得数组中任意间隔为h的元素都是有序的
    public static void shellSort(Comparable[] a){
        //将a按照升序进行排列
        int N = a.length;
        int h = 1;  //设置间隔
        while(h<N/3) h = 3 * h + 1;
        while(h>=1){
            //将数组变成h有序
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h &&less(a[j],a[j-h]) ; j -= h) {
                    exch(a,j,j-h);
                }
            }
            h = h/3;
        }
    }

    //归并排序：将两个有序数组归并成一个更大的有序数组

    public static void merge(Comparable[] a, int le, int mi, int ri){
        Comparable[] aux = new Comparable[a.length];    //归并所需要的辅助数组
        //将a[l...m]和a[m+1...h]排序
        int i = le;
        int j = mi+1;
        for (int k = le; k <= ri; k++)
            aux[k] = a[k];      //将a[le...ri]复制到aux[le...ri]

        for (int k = le; k < ri; k++) {
            if(i>mi) a[k] = aux[j++];
            else if(j>le) a[k] = aux[i++];
            else if(less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

    }


    //堆排序
    public static void heapSort(int[] a){
        if(a.length <= 0) return;
        int len = a.length;
        //构建大根堆，父节点的个数为len/2
        for(int i = len/2-1; i >= 0; i--) adjust(a, i, len);
        //交换根节点和尾节点，然后重新构造堆结构
        for(int j = len-1; j > 0; j--){
            exch(a,0,j);//交换根节点和尾节点
            adjust(a, 0, j);//重新构造堆
        }


    }
    //从第一个父节点开始，从下到上，从左到右调整
    private static void adjust(int[] a, int i, int len){
        int temp = a[i]; //取出当前元素
        for(int k = 2*i + 1; k < len; k = 2 * k + 1){//从i节点的左子树开始，即2*i + 1
            if(k + 1 < len && a[k] < a[k + 1]) k++;//如果左子节点小于右子节点，k加1，则指向右节点
            if(temp < a[k]){//如果子节点大于父节点，则将子节点的值赋值给父节点
                a[i] = a[k];
                i = k;
            }else break;

        }
        a[i] = temp;
    }




    //实现快速排序
    //快排的核心思想是按照一个切分元素对待排序数组进行划分，大于切分元素的元素在一边，小于切分元素的在另外一边
    //排序核心算法
    public static void sort(Comparable[] a){
        if(a == null) return;
        int len  = a.length;
        if(len <= 1) return;
        shuffle(a);//打乱
        sort(a, 0, len-1);
    }

    //递归排序
    private static void sort(Comparable[] a, int s, int e){
        if(s >= e) return;
        int partionId = partition(a, s, e);
        sort(a, s, partionId - 1);
        sort(a, partionId + 1, e);
    }

    //数组切分
    private static int partition(Comparable[]a, int s, int e){
        int i = s;      //左扫描指针
        int j = e + 1;  //右扫描指针
        Comparable v = a[s];    //切分元素，子数组的第一个元素
        while(true){
            //从左到右扫描，找到比v大的第一个元素的索引i
            while(less(a[++i], v)) if(i == e) break;
            //从右到左扫描，找到比v小的第一个元素索引j
            while(less(v, a[--j])) if(j == s) break;
            if(i >= j) break;//左右指针相遇，就退出while
            exch(a, i ,j);//交换找到的两个元素
        }
        exch(a, s, j);  //交换切分元素 v 和索引 j 对应的元素
        return j;   //返回交换后，切分元素所在的索引
    }

    //打乱数组
    private static void shuffle(Comparable[] a){
        int n = a.length;
        Random random = new Random(100);
        for (int i = 0; i < n; i++) {
            int r = i + random.nextInt(n - i);  //i到n-1之间的值
            Comparable temp = a[i]; //交换索引i和r对应的元素
            a[i] = a[r];
            a[r] = temp;
        }
    }



    //公共部分-----------------------------------------------
    //判断第一个元素是否小于第二个元素
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static boolean less(int v, int w){
        return v<w;
    }

    //交换数组中两个元素的位置
    private static void exch(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //打印数组
    public static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

    }

    public static void show(int[] a){
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

    }

    //测试数组是否已经从小到大排序
    public static boolean isSorted(Comparable[] a){
        for(int i = 0; i < a.length - 1; i++)
            if(!less(a[i], a[i + 1])) return false;
        return true;
    }

    public static boolean isSorted(int[] a){
        for(int i = 0; i < a.length - 1; i++)
            if(!less(a[i], a[i + 1])) return false;
        return true;
    }

}

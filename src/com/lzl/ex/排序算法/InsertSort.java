package 排序算法;

/**
 * Created by: Administrator 2018-09-01 14:22
 * 功能：插入排序
 */
public class InsertSort {

    //从小到大排序
    public static void insertSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j >0; j--) {
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
                else
                    break;
            }
        }
    }

    //从小到大排序,减少交换次数
    public static void betterInsertSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int ans = arr[i+1];
            for (int j = i+1; j >0 ; j--) {
                if( ans <= arr[j-1]){
                    arr[j] = arr[j-1];
                }
                else{
                    arr[j] = ans;
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]  =temp;
    }

    public static void main(String[] args) {
        int[] a = {0,2,3,1,4,5,2,4,3,1};
        betterInsertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

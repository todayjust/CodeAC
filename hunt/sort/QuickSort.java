package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void swap(int a[],int l,int r){
        int tmp=a[l];
        a[l]=a[r];
        a[r]=tmp;
    }
    public static void qSort(int[] arr , int left,int right){
        if(left>=right) return;
        //随机选择一个，防止整体有序的数组排序过慢
        int nextInt = new Random().nextInt(right - left + 1) + left;
        System.out.println(nextInt);
        swap(arr, nextInt, left);
        int key = arr[left];
        int l = left,r=right;
        while (l<r) {
            while (l < r && arr[r] >= key) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= key) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l]=key;
        qSort(arr,left,l-1);
        qSort(arr,l+1,right);
    }
    public static void quickSort(int[] arr){
        if(null == arr || arr.length<=1) return ;
        int n = arr.length-1;
        qSort(arr,0,n);
    }
    public static void main(String[] args) {
//        int[] arr = {3,5,7,11,10,9,8,6,4,2};
        int[] arr = {3,2};

        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

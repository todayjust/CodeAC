package sort;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {3,5,7,11,10,9,8,6,4,2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] a) {
        if(a!=null&&a.length<2) return;
        int n = a.length;
        int[] temp = new int[n];
        sort(a,0,n-1,temp);

    }

    private static void sort(int[] a, int left, int right, int[] temp) {
        if(left>= right) return;
        int mid = (left+right) / 2;
        sort(a,left,mid,temp);
        sort(a,mid+1,right,temp);
        merge(a,left,mid,right,temp);
    }

    private static void merge(int[] a, int left, int mid, int right, int[] temp) {

        int t=0,l=left,r=mid+1;
        while(l<=mid && r<=right){
            if(a[l]<a[r]){
                temp[t++]= a[l++];
            }
            else{
                temp[t++] = a[r++];
            }
        }
        while(l<=mid){
            temp[t++]=a[l++];
        }
        while(r<=right){
            temp[t++]=a[r++];
        }

        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            a[left++] = temp[t++];
        }
    }
}

package sort;

import java.util.Arrays;

public class HeapSort {
    public static void swap(int a[], int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 11, 10, 9, 8, 6, 4, 2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >=0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }
    }

    //向下调整大顶堆
    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for(int k=2*i+1;k<length;k=2*k+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k]>temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i]=arr[k];
                i=k; //向下调整
            }else{
                break;
            }
        }
        arr[i]=temp;//将temp值放到(向下调整的)最终的位置

    }

}

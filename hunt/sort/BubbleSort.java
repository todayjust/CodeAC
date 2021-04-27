package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 11, 10, 9, 8, 6, 4, 2};
//        int[] arr = {3,2};

        bubSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int a[], int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

    public static void bubSort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            //对待排序序列进行冒泡排序
            for (int j = 0; j + 1 < N - i; j++) {
                //相邻元素进行比较，当顺序不正确时，交换位置
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }

    }
}

package sort;

import java.util.Arrays;

/**
 * @Author zihailei
 * @Date 2018/6/30
 * @Description 快速排序
 */
public class QuickSort {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] array = {9, 7, 6, 5, 4, 3, 1, 8, 10, 2, 0, 4, 6, 2, 1, 5, 55, 99, 100, 20};
        quickSort2(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("所用时间：" + (System.currentTimeMillis() - start) + "ms");
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int key = a[left];
        while (i < j) {
            // 从右向左找第一个小于key的值
            while (i < j && a[j] >= key)
                j--;

            if (i < j) {
                a[i++] = a[j];
            }
            //从左向右找第一个大于key的值
            while (i < j && a[i] < key)
                i++;

            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = key;
        System.out.println(Arrays.toString(a));
        quickSort(a, left, i - 1);//递归调用
        quickSort(a, i + 1, right);//递归调用
    }

    public static void quickSort2(int[] a, int s, int e) {
        if (s >= e)
            return;
        int i = s - 1, j = s;
        int m = a[e];
        while (i <= j && i <= e && j <= e) {
            if (a[j] <= m) {
                int tmp = a[++i];
                a[i] = a[j];
                a[j++] = tmp;
            }
            else
                ++j;
        }
        quickSort2(a, s, i - 1);
        quickSort2(a, i + 1, e);
    }


}

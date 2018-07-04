package sort;

/**
 * @Author zihailei
 * @Date 2018/6/30
 * @Description 快速排序
 */
public class QuickSort {


    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int[] array = {9, 7, 6, 5, 4, 3, 1, 8, 10, 2, 0, 4, 6, 2, 1, 5, 55, 99, 100};
        quickSort(array, 6, array.length - 1);
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
                a[i] = a[j];
                i++;
            }
            //从左向右找第一个大于key的值
            while (i < j && a[i] < key)
                i++;

            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }

        //i == j
        a[i] = key;
        quickSort(a, left, i - 1);//递归调用
        quickSort(a, i + 1, right);//递归调用
    }


}

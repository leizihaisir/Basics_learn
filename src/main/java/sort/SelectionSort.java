package sort;

/**
 * @Author zihailei
 * @Date 2018/1/26
 * @Description 选择排序是一种简单直观的排序算法，无论什么数据进去都是 O(n²) 的时间复杂度。
 * 所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
 * 算法步骤:
 * 1:首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 2:再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 3:重复第二步，直到所有元素均排序完毕
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] sortArray = {0, 1, 9, 8, 7, 6, 5, 4, 3, 2};
        getSelectionSortArray(sortArray);
        for (int i = 0; i < sortArray.length; i++) {
            System.out.println(sortArray[i]);
        }
    }

    private static void getSelectionSortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j])
                    minIndex = j;
                if (minIndex != i) {
                    int temp = array[i];
                    array[i] = array[minIndex];
                    array[minIndex] = temp;
                }
            }
        }
    }
}

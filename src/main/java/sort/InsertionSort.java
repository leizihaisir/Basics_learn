package sort;

/**
 * @Author zihailei
 * @Date 2018/1/31
 * @Description 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] sortArray = {0, 1, 9, 8, 7, 6, 5, 4, 3, 2};
        getInsertionSort(sortArray);
        for (int i = 0; i < sortArray.length; i++) {
            System.out.println(sortArray[i]);
        }
    }

    private static void getInsertionSort(int[] array) {
        int count = 0;
        int length = array.length;
        int preIndex, current;
        for (int i = 1; i < length; i++) {
            preIndex = i - 1;
            current = array[i];
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
                count++;
            }
            array[preIndex + 1] = current;
        }
        System.out.println("count:" + count);
    }
}

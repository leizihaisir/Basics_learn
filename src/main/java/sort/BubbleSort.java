package sort;

/**
 * @Author zihailei
 * @Date 2018/1/26
 * @Description
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] sortArray = {0, 1, 9, 8, 7, 6, 5, 4, 3, 2};
        getBubbleSortArray(sortArray);
        for (int i = 0; i < sortArray.length; i++) {
            System.out.println(sortArray[i]);
        }
    }


    public static void getBubbleSortArray(int[] arr) {

        int temp;//临时变量
        for (int i = 0; i < arr.length - 1; i++) {   //表示趟数，一共arr.length-1次。
            for (int j = arr.length - 1; j > i; j--) {

                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

}

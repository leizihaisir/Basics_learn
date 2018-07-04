package sort;

/**
 * @Author zihailei
 * @Date 2018/2/1
 * @Description
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] sortArray = {1, 9, 8, 7, 6, 5, 4, 2, 3, 0};
        sort1(sortArray);
        for (int i = 0; i < sortArray.length; i++) {
            System.out.println(sortArray[i]);
        }
    }

    private static void getShellSort(int[] array) {
        int count = 0;
        int length = array.length;
        int temp;
        int incre = length;
        while (true) {
            // 每次增量均为上次增量的一半
            incre = incre / 2;
            for (int i = 0; i < incre; i++) {
                // 遍历按增量递增的数组(缺少前一个)
                for (int k = i + incre; k < length; k += incre) {
                    for (int j = k; j > i; j -= incre) {
                        if (array[j] > array[j - incre]) {
                            break;
                        }
                        temp = array[j - incre];
                        array[j - incre] = array[j];
                        array[j] = temp;
                        count++;
                    }
                }
            }
            if (incre == 1) {
                break;
            }
        }
        System.out.println("count:" + count);
    }

    public static void sort1(int[] arr) {
        int count = 0;
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                        count++;
                    }
                    arr[j] = temp;
                }
            }
        }

        System.out.println("count:" + count);
    }
}

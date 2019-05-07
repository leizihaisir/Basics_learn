package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zihailei
 * @Date 2019/3/7
 * @Description
 */
public class FindOneByArray {

    private static int[] idArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 9};


    public static void main(String[] args) {
        findByXOR();
    }

    private static void findByXOR() {
        int result = 0;
        for (int i : idArray) {
            result = result ^ i;
        }
        System.out.println(result);
    }

    private static void findByHash() {
        Set<Integer> set = new HashSet<>();

        for (int i : idArray) {
            if (set.contains(i)) {
                set.remove(i);
                continue;
            }
            set.add(i);
        }
        Object o = set.toArray()[0];
        if (o != null) {
            System.out.println(o.toString());
        }
    }
}

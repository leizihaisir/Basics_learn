/**
 * @Author zihailei
 * @Date 2018/6/29
 * @Description
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(countStep(10));
    }

    public static int countStep(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return countStep(n - 1) + countStep(n - 2);
    }

}

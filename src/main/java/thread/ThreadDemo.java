package thread;

/**
 * @Author zihailei
 * @Date 2018/1/29
 * @Description
 */
public class ThreadDemo {

    public static void main(String[] args) {
        // 线程内循环
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("自定义线程循环：" + i + "次");
                }
            }
        };
        thread.start();
        // 主线程循环
        for (int i = 1; i <= 100; i++) {
            System.out.println("主线程循环：" + i + "次");
        }
    }
}

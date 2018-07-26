package thread.worker;

/**
 * @Author zihailei
 * @Date 2018/7/5
 * @Description
 */
public class Student implements Runnable {

    @Override
    public void run() {
        System.out.println("线程名称：" + Thread.currentThread().getName());
        synchronized (WoekerMain.wan) {
            System.out.println("学生：取到了一个碗");
            System.out.println("学生：阿姨帮忙盛饭");
            WoekerMain.wan.notify();
            try {
                WoekerMain.wan.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("学生：吃饭");
        }
    }
}

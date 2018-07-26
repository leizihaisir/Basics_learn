package thread.worker;

/**
 * @Author zihailei
 * @Date 2018/7/5
 * @Description
 */
public class CafeteriaWorker implements Runnable {
    @Override
    public void run() {
        System.out.println("线程名称：" + Thread.currentThread().getName());
        synchronized (WoekerMain.wan) {
            try {
                WoekerMain.wan.wait();
            } catch (InterruptedException e) {
            }
            System.out.println("阿姨：给学生盛饭");
            WoekerMain.wan.notify();
        }
    }
}

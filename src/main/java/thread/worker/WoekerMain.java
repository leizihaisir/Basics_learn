package thread.worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author zihailei
 * @Date 2018/7/5
 * @Description
 */
public class WoekerMain {
    public static Object wan = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("线程名称：" + Thread.currentThread().getName());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new CafeteriaWorker());
        Thread.sleep(100);//等阿姨准备好
        exec.execute(new Student());
        exec.shutdown();
    }
}

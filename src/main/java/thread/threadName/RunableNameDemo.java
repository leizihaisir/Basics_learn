package thread.threadName;

/**
 * @Author zihailei
 * @Date 2018/1/30
 * @Description
 */
public class RunableNameDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("执行这段运行时代码的线程名:" + Thread.currentThread().getName());
    }
}

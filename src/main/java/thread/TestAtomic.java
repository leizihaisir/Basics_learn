package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zihailei
 * @Date 2018/11/29
 * @Description
 */
public class TestAtomic {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void inc() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            service.execute(() -> TestAtomic.inc());
        }
        service.shutdown();
        //避免出现main主线程先跑完而子线程还没结束，在这里给予一个关闭时间
        service.awaitTermination(3000, TimeUnit.SECONDS);
        System.out.println("运行结果:TestAtomic.count=" + TestAtomic.count);
    }
}

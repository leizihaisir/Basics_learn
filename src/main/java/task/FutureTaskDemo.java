package task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author zihailei
 * @Date 2018/10/16
 * @Description
 */
public class FutureTaskDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> result = executorService.submit(() -> {
            for (int i = 0; i < 200; i++) {
                System.out.println("任务1异步执行" + i);
            }
            return "任务1";
        });
        Future<String> result2 = executorService.submit(() -> {
            for (int i = 0; i < 200; i++) {
                System.out.println("任务2异步执行" + i);
            }
            return "任务1";
        });
        try {
            System.out.println(result.get() + "：执行完成");
            System.out.println(result2.get() + "：执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}

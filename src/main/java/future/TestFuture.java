package future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author zihailei
 * @Date 2019-04-30
 * @Description
 */
public class TestFuture {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future = executorService.submit(() -> "hello world");
        System.out.printf(future.get());
    }
}

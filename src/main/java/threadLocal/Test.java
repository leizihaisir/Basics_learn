package threadLocal;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author zihailei
 * @Date 2019/4/26
 * @Description
 */
public class Test {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("main");
        System.out.println(JSON.toJSONString(threadLocal.get()));
        executorService.submit(() -> {
            threadLocal.set(Thread.currentThread().getName() + "pool");
            System.out.println(JSON.toJSONString(threadLocal.get()));

        });
        executorService.submit(() -> {
            threadLocal.set(Thread.currentThread().getName() + "pool");
            System.out.println(JSON.toJSONString(threadLocal.get()));

        });
        Thread.sleep(2000);
        System.out.println(JSON.toJSONString(threadLocal.get()));

        System.out.println(finallyNotWork());

    }

    public static int finallyNotWork() {
        int temp = 100;
        try {
            throw new Exception("a exp");
        } catch (Exception e) {
            return temp;
        } finally {
            return 1;
        }
    }

}

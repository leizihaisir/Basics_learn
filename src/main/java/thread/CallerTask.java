package thread;

import java.util.concurrent.Callable;

/**
 * @Author zihailei
 * @Date 2019/1/20
 * @Description
 */
public class CallerTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "hello";
    }
}

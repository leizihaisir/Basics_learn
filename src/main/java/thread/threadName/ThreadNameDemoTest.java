package thread.threadName;

/**
 * @Author zihailei
 * @Date 2018/1/30
 * @Description
 */
public class ThreadNameDemoTest {

    public static void main(String[] args) {
        System.out.println("主线程名称:" + Thread.currentThread().getName());
        //  //创建一个名字为newThread的线程并启动
        new Thread(new ThreadNameDemo(), "newThread").start();
        // //创建一个线程，不指定名字，JVM会自动给其分配一个名字
        new Thread(new RunableNameDemo()).start();
    }
}

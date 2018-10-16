package observer;

/**
 * @Author zihailei
 * @Date 2018/7/27
 * @Description
 */
public class TestObserver {
    public static void main(String[] args) {
        ServerManager sm = new ServerManager();
        MyObserver a = new MyObserver(sm);
        sm.setData(5);
        sm.setData(10);
    }

}

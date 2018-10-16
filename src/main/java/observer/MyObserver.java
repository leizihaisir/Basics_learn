package observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author zihailei
 * @Date 2018/7/27
 * @Description
 */
public class MyObserver implements Observer {

    public MyObserver(ServerManager sm) {
        super();
        sm.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("MyObserver receive:Data has changed to " + ((ServerManager) o).getData());
    }
}

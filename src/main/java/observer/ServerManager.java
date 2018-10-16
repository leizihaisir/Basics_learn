package observer;

import java.util.Observable;

/**
 * @Author zihailei
 * @Date 2018/7/27
 * @Description
 */
public class ServerManager extends Observable {

    private int data = 0;

    public int getData() {
        return data;
    }

    public void setData(int i) {
        if (this.data != i) {
            this.data = i;
            setChanged();
            notifyObservers();
        }
    }
}
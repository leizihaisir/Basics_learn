package source;

/**
 * @Author zihailei
 * @Date 2018/1/26
 * @Description
 */
public class HashMapTest {

    public static void main(String[] args) {
        String key = "zihailei";
        System.out.println(hash(key) & 15);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}

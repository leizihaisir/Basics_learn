import org.apache.commons.lang3.StringUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zihailei
 * @Date 2019/1/4
 * @Description
 */
public class Test {


    public static String idPassport(String id) {
        if (StringUtils.isEmpty(id) || (id.length() < 5)) {
            return id;
        }
        return id.substring(0, 2) + new String(new char[id.length() - 5]).replace("\0", "*") + id.substring(id.length() - 3);
    }

    public static String toBinary(int xf) {
        return Integer.toBinaryString(xf);
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    public static void main(String[] args) throws ScriptException {
        final int COUNT_BITS = Integer.SIZE - 3;
        // runState is stored in the high-order bits
        final int RUNNING = -1 << COUNT_BITS;
        System.out.println(toBinary(RUNNING));
        final int SHUTDOWN = 0 << COUNT_BITS;
        System.out.println(toBinary(SHUTDOWN));
        final int STOP = 1 << COUNT_BITS;
        System.out.println(toBinary(STOP));
        final int TIDYING = 2 << COUNT_BITS;
        System.out.println(toBinary(TIDYING));
        final int TERMINATED = 3 << COUNT_BITS;
        System.out.println(toBinary(TERMINATED));
    }
}

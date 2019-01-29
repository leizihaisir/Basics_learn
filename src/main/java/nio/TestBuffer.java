package nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @Author zihailei
 * @Date 2019/1/28
 * @Description
 */
public class TestBuffer {

    public static void main(String[] args) {
        //testIntBuffer();
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put(Byte.valueOf("k"));
        System.out.println(allocate.capacity());
        System.out.println(allocate.position());
        System.out.println(allocate.limit());
    }

    private static void testIntBuffer() {
        IntBuffer intBuffer = IntBuffer.allocate(2);
        System.out.println(intBuffer.capacity());
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.limit());
        System.out.println("---------");
        intBuffer.put(2);
        intBuffer.put(22);
        System.out.println(intBuffer.capacity());
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.limit());
        System.out.println("---------");
        intBuffer.flip();
        System.out.println("flip---------");
        System.out.println(intBuffer.capacity());
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.limit());
        System.out.println("red before---------");
        System.out.println(intBuffer.get());
        System.out.println(intBuffer.get());
        System.out.println("red after---------");
        System.out.println(intBuffer.capacity());
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.limit());
        System.out.println("---------");
    }
}

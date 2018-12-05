package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author zihailei
 * @Date 2018/11/8
 * @Description
 */
public class TestSocketChannel {

    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("http://localhost/", 80));
            String newData = "New String to write to file..." + System.currentTimeMillis();

            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.clear();
            buf.put(newData.getBytes());
            buf.flip();
            while (buf.hasRemaining()) {
                socketChannel.write(buf);
            }
            //buf.flip();
            //buf.clear();
            //int read = socketChannel.read(buf);
            //while (read != -1) {
            //    buf.flip();
            //    while (buf.hasRemaining()) {
            //        System.out.print((char) buf.get());
            //    }
            //    buf.clear();
            //    read = socketChannel.read(buf);
            //}

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

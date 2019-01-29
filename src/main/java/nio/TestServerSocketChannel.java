package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import static java.nio.channels.SelectionKey.OP_READ;

/**
 * @Author zihailei
 * @Date 2018/11/8
 * @Description
 */
public class TestServerSocketChannel {

    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            // 打开 Selector
            Selector selector = Selector.open();

            serverSocketChannel.socket().bind(new InetSocketAddress(8088));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                // 通过调用 select 方法, 阻塞地等待 channel I/O 可操作
                if (selector.select(3000) == 0) {
                    System.out.print(".");
                    continue;
                }

                // 获取 I/O 操作就绪的 SelectionKey, 通过 SelectionKey 可以知道哪些 Channel 的哪类 I/O 操作已经就绪.
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

                while (keyIterator.hasNext()) {

                    SelectionKey key = keyIterator.next();

                    // 当获取一个 SelectionKey 后, 就要将它删除, 表示我们已经对这个 IO 事件进行了处理.
                    keyIterator.remove();

                    if (key.isAcceptable()) {
                        System.out.println("可以接受数据");
                        // 当 OP_ACCEPT 事件到来时, 我们就有从 ServerSocketChannel 中获取一个 SocketChannel,
                        // 代表客户端的连接
                        // 注意, 在 OP_ACCEPT 事件中, 从 key.channel() 返回的 Channel 是 ServerSocketChannel.
                        // 而在 OP_WRITE 和 OP_READ 中, 从 key.channel() 返回的是 SocketChannel.
                        SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                        clientChannel.configureBlocking(false);
                        //在 OP_ACCEPT 到来时, 再将这个 Channel 的 OP_READ 注册到 Selector 中.
                        // 注意, 这里我们如果没有设置 OP_READ 的话, 即 interest set 仍然是 OP_CONNECT 的话, 那么 select 方法会一直直接返回.
                        ByteBuffer allocate = ByteBuffer.allocate(256);
                        allocate.put(Byte.parseByte("123"));
                        clientChannel.register(key.selector(), OP_READ, allocate);
                    }

                    if (key.isReadable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer buf = (ByteBuffer) key.attachment();
                        long bytesRead = clientChannel.read(buf);
                        if (bytesRead == -1) {
                            clientChannel.close();
                        } else if (bytesRead > 0) {
                            key.interestOps(OP_READ | SelectionKey.OP_WRITE);
                            System.out.println("Get data length: " + bytesRead);
                        }
                    }

                    if (key.isValid() && key.isWritable()) {
                        ByteBuffer buf = (ByteBuffer) key.attachment();
                        buf.flip();
                        SocketChannel clientChannel = (SocketChannel) key.channel();

                        clientChannel.write(buf);

                        if (!buf.hasRemaining()) {
                            key.interestOps(OP_READ);
                        }
                        buf.compact();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @Author zihailei
 * @Date 2018/11/7
 * @Description
 */
public class TestChannel {

    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = null;
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile("/Users/zihailei/Pictures/YMZF-2589.sql", "rw");
            channel = randomAccessFile.getChannel();

            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            CharBuffer charBuffer = CharBuffer.allocate(1024);

            int read = channel.read(byteBuffer);
            while (read != -1) {
                byteBuffer.flip();
                decoder.decode(byteBuffer, charBuffer, false);
                charBuffer.flip(); // 切换到读模式
                while (charBuffer.hasRemaining()) {
                    System.out.print(charBuffer.get());
                }
                byteBuffer.clear();
                charBuffer.clear();
                read = channel.read(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            randomAccessFile.close();
            channel.close();
        }


    }
}

package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @Author zihailei
 * @Date 2018/6/17
 * @Description
 */
public class TestNio {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/zihailei/Documents/learn/Basics_learn/src/main/resources/text.txt", "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = fileChannel.read(buffer);
            Charset charset = Charset.forName("UTF-8");
            while (read != -1) {
                buffer.flip();
                System.out.println(charset.decode(buffer));
                buffer.clear();
                read = fileChannel.read(buffer);
            }
            randomAccessFile.close();
            fileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("当前程序耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }


}

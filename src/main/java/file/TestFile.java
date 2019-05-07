package file;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zihailei
 * @Date 2019/4/28
 * @Description
 */
public class TestFile {

    public static void main(String[] args) throws Exception {
        List<String> paths = new ArrayList<>();
        paths.add("/Users/zihailei/Documents/learn/Basics_learn/src/main/resources/a.txt");
        paths.add("/Users/zihailei/Documents/learn/Basics_learn/src/main/resources/b.txt");
        String resultPath = "/Users/zihailei/Documents/learn/Basics_learn/src/main/resources/c.txt";
        //mergeFilesChannle(paths, resultPath);

    }

    public static void mergeFiles(List<String> paths, String resultPath) {
        if (paths == null || paths.isEmpty()) {
            return;
        }
        if (StringUtils.isEmpty(resultPath)) {
            return;
        }
        byte[] bytes = new byte[1024];
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(resultPath));
            for (String path : paths) {
                inputStream = new FileInputStream(path);
                int readCount;
                while ((readCount = inputStream.read(bytes)) > 0) {
                    outputStream.write(bytes, 0, readCount);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static void mergeFilesChannle(List<String> paths, String resultPath) {
        if (paths == null || paths.isEmpty()) {
            return;
        }
        if (StringUtils.isEmpty(resultPath)) {
            return;
        }
        FileChannel inputChannel = null;
        FileChannel resultFileChannel = null;
        try {
            resultFileChannel = new FileOutputStream(new File(resultPath)).getChannel();
            for (String path : paths) {
                inputChannel = new FileInputStream(path).getChannel();
                resultFileChannel.transferFrom(inputChannel, resultFileChannel.size(), inputChannel.size());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputChannel.close();
            } catch (IOException e) {
            }
            try {
                resultFileChannel.close();
            } catch (IOException e) {
            }
        }
    }


}

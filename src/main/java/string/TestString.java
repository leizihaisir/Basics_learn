package string;

/**
 * @Author zihailei
 * @Date 2018/10/29
 * @Description
 */
public class TestString {

    public static void main(String[] args) {
        String picFileName = "/home/newsettle/hbank/identfront.jpg";
        String substring = picFileName.trim().substring(picFileName.lastIndexOf("/  FileBody fundFileBin = new FileBody(postFile);") + 1);
        System.out.println(substring);
    }
}
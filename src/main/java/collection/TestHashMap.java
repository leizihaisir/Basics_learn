package collection;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * @Author zihailei
 * @Date 2018/10/15
 * @Description
 */
public class TestHashMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "zihailei");
        System.out.println(JSON.toJSONString(map));
        map = change(map);
        System.out.println(JSON.toJSONString(map));
    }

    private static HashMap<String, String> change(HashMap<String, String> map) {
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("age", "10");
        return map1;
    }
}

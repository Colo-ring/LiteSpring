package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author IntelliYJC
 * @create 2022/8/4 14:04
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();
    static {
        hashMap.put("10001", "张三子");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }
    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}

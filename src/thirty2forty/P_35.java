package thirty2forty;

import java.util.HashMap;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-21 12:22
 * @Description: 第一次只出现一次的字符
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class P_35 {
    HashMap<Character, Integer> map = new HashMap<>();

    public int FirstNotRepeatingChar(String str) {
        if (str == null) {
            return -1;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {

            if (map.containsKey(str.charAt(i))) {
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < length; i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

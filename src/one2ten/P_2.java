package one2ten;

import org.junit.Test;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-11 13:50
 * @Description: 替换空格 P51
 * 请实现一个函数，
 * 将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class P_2 {
    public String replaceSpace(StringBuffer str) {
        //spacenum为计算空格数
        int spacenum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spacenum++;
            }
        }
        //indexOld为为替换前的str下标
        int indexOld = str.length() - 1;
        //计算空格转换成%20之后的str长度
        int newLength = str.length() + spacenum * 2;
        int indexNew = newLength - 1;
        //indexNew为为把空格替换为%20后的str下标
        str.setLength(newLength);
        while (indexOld >= 0 && indexOld < newLength) {
            if (str.charAt(indexOld) == ' ') {
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            } else {
                str.setCharAt(indexNew--, str.charAt(indexOld));
            }
            --indexOld;
        }
        return str.toString();
    }

    @Test
    public void Test2() {
        StringBuffer sb = new StringBuffer("We Are Happy");
        String s = replaceSpace(sb);
        System.out.println(s);

    }
}

package forty2fifty;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-25 15:17
 * @Description: 翻转单词顺序 p58
 *     [算法思想]：先翻转整个句子，然后，依次翻转每个单词。依据空格来确定单词的起始和终止位置
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class P_45 {
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length - 1);
        int blank = -1;
        for(int i = 0;i < chars.length;i++){
            if(chars[i] == ' '){
                int nextBlank = i;
                reverse(chars,blank + 1,nextBlank - 1);
                blank = nextBlank;
            }
        }
        //最后一个单词单独进行反转
        reverse(chars,blank + 1,chars.length - 1);
        return new String(chars);

    }
    public void reverse(char[] chars,int low,int high){
        while(low < high){
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }

    /**
     * 方法二
     * @param str
     * @return
     */
    public String ReverseSentenceII(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] a = str.split(" ");
        StringBuffer o = new StringBuffer();
        int i;
        for (i = a.length; i >0;i--){
            o.append(a[i-1]);
            if(i > 1){
                o.append(" ");
            }
        }
        return o.toString();
    }
}

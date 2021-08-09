package Sort.T1451_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 重新排列字符串中的单词
 * 题意：按单词长度升序重排字符串，首字母大小，其余小写。
 * 竟然在首字母转换的地方坎坷了.....
 * 链接：https://leetcode-cn.com/problems/rearrange-words-in-a-sentence/
 */
public class T1451  {
    public static String arrangeWords(String text) {

        String[] str= text.toLowerCase().split(" ");
        int len=str.length;
        String[][] res =new String[len][2];

        for (int i = 0; i < len; i++) {
            res[i][0]=str[i];
            res[i][1]= String.valueOf(str[i].length());
        }
        Arrays.sort(res, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
            }
        });
        //首字母转为大写
        char c = res[0][0].charAt(0);
        c=(char)(c-32);
        res[0][0]=c+res[0][0].substring(1);
        StringBuilder sb=new StringBuilder();
        //字符串拼接
        for (int i = 0; i < res.length; i++) {
            if (i!= res.length-1){
                sb.append(res[i][0]).append(" ");
            }else {
                sb.append(res[i][0]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String text="Keep calm and code on";
        String res = arrangeWords(text);
        System.out.println(res);
    }
}

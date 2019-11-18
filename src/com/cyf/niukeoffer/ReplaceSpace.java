package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/7/23 12:30
 * @Description:请实现一个函数，将一个字符串中的每个空格替换成“%20”。 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * spacenum:计算空格数；
 * indexold为为替换前的str下标；
 * newlength计算空格转换成%20之后的str长度；
 * indexold为为把空格替换为%20后的str下标；
 * 使str的长度扩大到转换成%20之后的长度,防止下标越界
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int spacenum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                spacenum++;
        }
        int indexold = str.length() - 1;
        int newlength = str.length() + spacenum * 2;
        int indexnew = newlength - 1;
        str.setLength(newlength);
        for (; indexold >= 0 && indexold < newlength; indexold--) {
            if (str.charAt(indexold) == ' ') {
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            } else {
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
        }
        return str.toString();
    }
}


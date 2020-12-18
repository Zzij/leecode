package com.zz.leecode.stringz;

import java.util.HashMap;

/**
 * @author zzj
 * @className ConvertStringToZString
 * @description TODO
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * @date 2020/11/9
 */
public class ConvertStringToZString {

    public String convert(String s, int numRows) {


        int length = s.length();

        HashMap<Integer, StringBuilder> hashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {

            int index = i % numRows;
            if (hashMap.containsKey(index)) {
                hashMap.get(index).append(s.charAt(i));
            } else {
                StringBuilder sb = new StringBuilder();
                hashMap.put(index, sb);
                sb.append(s.charAt(i));
            }
        }

        StringBuilder currentSb = new StringBuilder(length);
        for (int j = 0; j < numRows; j++) {
            StringBuilder stringBuilder = hashMap.get(j);
            currentSb.append(stringBuilder);
        }

        return currentSb.toString();
    }

    public static void main(String[] args) {
        ConvertStringToZString convertStringToZString = new ConvertStringToZString();
        String leetcodeishiring = convertStringToZString.convert("LEETCODEISHIRING", 3);
        System.out.println(leetcodeishiring);
    }
}

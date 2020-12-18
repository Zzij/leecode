package com.zz.leecode.difference;

import java.util.HashMap;

/**
 * @author zzj
 * @className StringDifference
 * @description 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * @date 2020/12/18
 */
public class StringDifference {

    /**
     * 垃圾
     *
     * @param s 初始
     * @param t 增加
     * @return 新增字段
     */
    public static char findTheDifference(String s, String t) {
        char[] charS = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char aChar : charS) {
            if (hashMap.containsKey(aChar)) {
                Integer integer = hashMap.get(aChar);
                integer++;
                hashMap.put(aChar, integer);
            } else {
                hashMap.put(aChar, 1);
            }
        }
        char[] charsT = t.toCharArray();
        for (char c : charsT) {
            Integer integer = hashMap.get(c);
            if (integer == null || integer == 0) {
                return c;
            }
            integer--;
            hashMap.put(c, integer);
        }
        return 1;
    }


    /**
     * 利用ascall值
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference2(String s, String t) {
        char[] charS = s.toCharArray();
        int s1 = 0;
        for (char aChar : charS) {
            s1 += aChar;
        }
        int t1 = 0;
        char[] charsT = t.toCharArray();
        for (char c : charsT) {
            t1 += c;
        }
        return (char)(t1-s1);

    }

    public static void main(String[] args) {
        System.out.println(findTheDifference2("abcd", "abcde"));
    }
}

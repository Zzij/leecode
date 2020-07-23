package com.zz.leecode.norepeat;

import sun.applet.Main;

import java.util.HashMap;

/**
 * @author zzj
 * @className MaxNoRepeat
 * @description TODO
 * @date 2020/7/23
 * <p>
 * <p>
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 如qabcdefdoplmgy  就是 qabcdef
 * <p>
 * 思路 ：没有思路
 */
public class MaxNoRepeat {

    /**
     * 滑动窗口解决方案
     * <p>
     * 声明两个指针，分别指向第一个和第二个字符
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;

        int indexRight = 0, indexLeft = 0;

        int temp = 0;

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean containsKey = map.containsKey(s.charAt(i));

            if (containsKey) {
                temp = i - left;

                if (max < temp) {
                    indexLeft = left;
                    indexRight = i - 1;
                    max = temp;
                }

                left = Math.max(left, map.get(s.charAt(i)) + 1);
                if (s.length() - 1 == i) {
                    if (max < (i - left + 1)) {
                        max = i - left + 1;
                        indexRight = i;
                        indexLeft = left;
                    }
                }
            } else {
                if (s.length() - 1 == i) {
                    if (max < (i - left + 1)) {
                        max = i - left + 1;
                        indexRight = i;
                        indexLeft = left;
                    }
                }
            }
            map.put(s.charAt(i), i);
        }
        if (max == 0 && indexLeft == 0 && indexRight == 0) {
            max = s.length();
            indexRight = s.length() - 1;
        }
        indexRight = indexRight + 1;

        System.out.println(s.substring(indexLeft, indexRight));

        return max;
    }


    /**
     * 只要长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringNum(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean containsKey = map.containsKey(s.charAt(i));
            if (containsKey) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            max = Math.max(max, i - left + 1);
            map.put(s.charAt(i), i);
        }

        return max;
    }


    public static void main(String[] args) {
        String str = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstringNum(str));
    }
}

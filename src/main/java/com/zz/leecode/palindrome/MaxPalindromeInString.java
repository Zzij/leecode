package com.zz.leecode.palindrome;

import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets;

import javax.swing.tree.ExpandVetoException;

/**
 * @author zzj
 * @className MaxPalindromeInString
 * @description TODO
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * @date 2020/11/9
 */
public class MaxPalindromeInString {


    /**
     * 思考若是回文  可以考虑必是中间向两边扩散 且相等
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        int length = s.length();

        String palindromeStr = "";
        if (length == 1) {
            palindromeStr = s;
        }
        for (int i = 0; i < length; i++) {

            if ((i + 1) < length && s.charAt(i) == s.charAt(i + 1)) {
                //只有偶数
                palindromeStr = expand(i, i + 1, length, palindromeStr, s);
                //奇数
                palindromeStr = expand(i, i, length, palindromeStr, s);
            } else {
                palindromeStr = expand(i, i, length, palindromeStr, s);
            }

        }
        System.out.println("last palindromeStr " + palindromeStr);
        return palindromeStr;
    }

    private String expand(int i, int j, int length, String palindromeStr, String string) {

        while (true) {
            if (string.charAt(i) == string.charAt(j)) {
                if (i == 0) {
                    String temp = string.substring(i, j + 1);
                    if (temp.length() > palindromeStr.length()) {
                        palindromeStr = temp;
                    }
                    return palindromeStr;
                }

                if (j == length - 1) {
                    String temp = string.substring(i, j + 1);
                    if (temp.length() > palindromeStr.length()) {
                        palindromeStr = temp;
                    }
                    return palindromeStr;
                }

                i--;
                j++;
            } else {

                String temp = string.substring(++i, j);
                if (temp.length() > palindromeStr.length()) {
                    palindromeStr = temp;
                }

                return palindromeStr;
            }

        }
    }

    public static void main(String[] args) {
        MaxPalindromeInString maxPalindromeInString = new MaxPalindromeInString();
        maxPalindromeInString.longestPalindrome("abbbc");
    }
}

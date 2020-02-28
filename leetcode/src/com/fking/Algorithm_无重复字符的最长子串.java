package com.fking;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Algorithm_无重复字符的最长子串 {
    public static void main(String[] args) {

        lengthOfLongestSubstring("abcabcbb");
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <=1){
            return s.length();
        }

        Set<Character> cList = new HashSet<Character>();
        int ret = 0;
        for (int i = 0; i < s.length()-1; i++) {
            cList.clear();
            Character chi = s.charAt(i);
            cList.add(chi);
            for(int j = i+1; j < s.length();j++){
                Character chj = s.charAt(j);
                if(!cList.contains(chj)){
                    cList.add(chj);
                    if(j == s.length()-1){
                        ret = Math.max(ret, cList.size());
                    }
                }else {
                    ret = Math.max(ret, cList.size());
                    break;
                }
            }
        }

        return ret;
    }
}

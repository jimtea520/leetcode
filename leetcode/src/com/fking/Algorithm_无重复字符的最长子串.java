package com.fking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Algorithm_无重复字符的最长子串 {
    public static void main(String[] args) {

//        lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring2("abcabcbb");
    }

    /**
     * 暴力破解
     *
     * 执行用时 :
     * 101 ms
     * 内存消耗 :
     * 40.7 MB
     * @param s
     * @return
     */
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

    /**
     * 滑动窗口
     *
     * 1.定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
     * 2.我们定义不重复子串的开始位置为 start，结束位置为 end
     * 3.随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
     * 4.无论是否更新 start，都会更新其 map 数据结构和结果 ans。
     * 5.时间复杂度：O(n)O(n)
     *
     * 执行用时 :
     * 9 ms
     * 内存消耗 :
     * 40.2 MB
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s){
        if (s.length() <=1){
            return s.length();
        }
        int len = s.length(), ans=0;
        Map<Character, Integer> maps = new HashMap<>();
        for (int start = 0, end = 0; end < len; end++) {
            Character c = s.charAt(end);
            System.out.print("c:"+c+",start:"+start+",end:"+end);
            if (maps.containsKey(c)) {
                start = Math.max(maps.get(c), start);
                System.out.print(",changestart:"+start);
            }
            System.out.print(",beforeans:"+ans);
            ans = Math.max(ans, end - start +1);
            maps.put(c, end +1);
            System.out.print(",afterans:"+ans+",end +1:"+(end +1));
            System.out.println();
        }

        return ans;
    }
}

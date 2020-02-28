package com.fking;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class Algorithm_最长回文子串 {
    public static void main(String[] args) {
        longestPalindrome("babad");
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()){
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        if(s.length() == 2){
            String s1 = s.substring(0, 1);
            String s2 = s.substring(1, 2);
            if(s1.equals(s2)) {
                return s;
            }else{
                return s1;
            }
        }

        String ret = "";
        StringBuffer stringBuffer = new StringBuffer ();
        for (int i = 0; i < s.length()-1; i++) {
            Character chi = s.charAt(i);
            if(ret.isEmpty()) {
                ret = chi.toString();
            }
            for(int j = s.length()-1; j > i;j--){
                Character chj = s.charAt(j);

                if(chi.equals(chj)){
                    //倒排
                    String tempS = s.substring(i, j+1);
                    stringBuffer.delete(0, stringBuffer.length());
                    stringBuffer.append(tempS);
                    String tempS2 = stringBuffer.reverse().toString();
                    if(tempS.equals(tempS2) && ret.length() < tempS.length()){
                        //是回响
                        ret = tempS;
                        break;
                    }
                }
            }
        }

        return ret;
    }
}

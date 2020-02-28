package com.fking;

/**
 * 回文数:
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Algorithm_回文数 {
    public static void main(String[] args) {
        isPalindrome(1);
    }

    public static boolean isPalindrome(int x) {
        //小于零或者10的倍数
        if(x<0 || (x!= 0 && x%10 == 0)){
            return false;
        }

        int a = 0;
        int tx = x;
        while(tx >0) {
            a = a*10 +tx%10;
            tx *=0.1;
        }

        return x==a;
    }
}

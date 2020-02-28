package com.fking;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Interview_整数反转 {
    public static void main(String[] args) {
        reverse(3);
    }

    public static  int reverse(int x) {
        if(x <= Integer.MIN_VALUE || x>= Integer.MAX_VALUE){
            x = 0;
        }

        boolean isLessZero = x<0?true:false;
        if (x<0){
            x = -x;
        }
        StringBuffer sb = new StringBuffer(String.valueOf(x));
        long ret = Long.valueOf(sb.reverse().toString());
        if (ret >= Integer.MAX_VALUE || ret <= Integer.MIN_VALUE){
            return 0;
        }
        return isLessZero? -(int)ret:(int)ret;
    }
}

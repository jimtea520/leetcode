package com.fking;

/**
 * 斐波那契数列:
 *
 通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和
 */
public class Interview_斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(fib2(5));
    }

    /**
     *  递归
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n-1)+fib(n-2);
    }

    /**
     *  复杂度为O(n)
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int f2=1,f1=0;
        for (int i = 2; i <= n; i++) {
            int f = f1 + f2;
            f1 = f2;
            f2 = f;

        }

        return  f2;
    }
}

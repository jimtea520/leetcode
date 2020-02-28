package com.fking;

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 */
public class Algorithm_Z字形变换 {
    public static void main(String[] args) {

        convert("aa",3);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> sbList = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            sbList.add(new StringBuilder());

        int curRow = 0;
        boolean addRow = false;

        for (char c : s.toCharArray()) {
            sbList.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) addRow = !addRow;
            curRow += addRow ? 1 : -1;
        }

        String ret = "";
        for (StringBuilder sb : sbList) ret += sb.toString();
        return ret.toString();
    }
}

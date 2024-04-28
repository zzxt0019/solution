package cn.leetcode.no_1001_1100.no_1017;

import java.util.Arrays;

public class 负二进制转换 {
    public static void main(String[] args) {

    }

    private static final int[] all = new int[31];  // 多少位内的所有负数/正数加起来的最小值/最大值
    private static final int[] pow = new int[31];

    static {
        int lastMin = 0;
        int lastMax = 0;
        for (int i = 0; i < 31; i++) {
            pow[i] = pow(-2, i);
            if (pow[i] < 0) {
                all[i] = lastMin + pow[i];
                lastMin = all[i];
            } else {
                all[i] = lastMax + pow[i];
                lastMax = all[i];
            }
        }

    }

    public static String baseNeg2(int n) {
        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        for (int index = 30; index > 0; index--) {
            if (pow[index] > 0) {
                // 当前是正数, 那么必须满足后面所有负数之和+当前值<=目标值, 当前值才可为1
                //    如果当前值+负数之和>目标值, 意味着后面全取最小值(负数全1正数全0)也比目标值大, 故当前位应取0
                if (pow[index] + all[index - 1] <= n) {
                    builder.append(1);
                    n -= pow[index];
                    flag = true;
                } else if (flag) {
                    builder.append(0);
                }
            } else {
                if (pow[index] + all[index - 1] >= n) {
                    builder.append(1);
                    n -= pow[index];
                    flag = true;
                } else if (flag) {
                    builder.append(0);
                }
            }
        }
        builder.append(n);
        return builder.toString();
    }

    public static int pow(int a, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= a;
        }
        return result;
    }
}

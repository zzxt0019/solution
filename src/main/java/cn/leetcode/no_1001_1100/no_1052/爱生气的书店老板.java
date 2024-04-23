package cn.leetcode.no_1001_1100.no_1052;

public class 爱生气的书店老板 {
    public static void main(String[] args) {

    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int result = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                result += customers[i];
                customers[i] = 0;
            }
        }
        int current = 0;
        for (int i = 0; i < minutes; i++) {
            current += customers[i];
        }
        int max = current;
        for (int i = 1; i < customers.length - minutes + 1; i++) {
            current += customers[i + minutes - 1];
            current -= customers[i - 1];
            max = Math.max(max, current);
        }
        return max + result;
    }
}

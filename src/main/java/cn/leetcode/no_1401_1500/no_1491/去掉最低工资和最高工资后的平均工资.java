package cn.leetcode.no_1401_1500.no_1491;

public class 去掉最低工资和最高工资后的平均工资 {
    public static void main(String[] args) {

    }

    public static double average(int[] salary) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : salary) {
            sum += i;
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        sum -= min + max;
        return (double) sum / (salary.length - 2);
    }
}

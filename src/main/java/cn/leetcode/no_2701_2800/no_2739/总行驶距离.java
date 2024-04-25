package cn.leetcode.no_2701_2800.no_2739;

public class 总行驶距离 {
    public static void main(String[] args) {
        System.out.println(distanceTraveled(5, 10));

    }

    public static int distanceTraveled(int mainTank, int additionalTank) {
        int time = 0;
        while (mainTank >= 5) {
            int add = Math.min(mainTank / 5, additionalTank);
            time += mainTank / 5 * 50;
            mainTank %= 5;
            additionalTank -= add;
            mainTank += add;
        }
        time += mainTank * 10;
        return time;
    }
}

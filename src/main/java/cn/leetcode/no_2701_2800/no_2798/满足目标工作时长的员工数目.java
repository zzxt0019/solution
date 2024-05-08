package cn.leetcode.no_2701_2800.no_2798;

public class 满足目标工作时长的员工数目 {
    public static void main(String[] args) {

    }

    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int hour : hours) {
            if (hour >= target) {
                count++;
            }
        }
        return count;
    }
}

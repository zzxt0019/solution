package cn.leetcode.no_2001_2100.no_2079;

public class 给植物浇水 {
    public static void main(String[] args) {
        int[] plants = {7, 7, 7, 7, 7, 7, 7};
        int capacity = 8;
        System.out.println(wateringPlants(plants, capacity));

    }

    public static int wateringPlants(int[] plants, int capacity) {
        int restWater = capacity;
        int total = 0;
        for (int i = 0; i < plants.length; i++) {
            if (restWater - plants[i] < 0) {
                total += i * 2 + 1;
                restWater = capacity - plants[i];
            } else {
                restWater -= plants[i];
                total++;
            }
        }
        return total;
    }


}

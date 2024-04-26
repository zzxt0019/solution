package cn.leetcode.no_1101_1200.no_1146;

import java.util.*;

public class 快照数组 {
    public static void main(String[] args) {
    }
    private static class SnapshotArray {
        private final List<int[]>[] listArray;

        private int snapId = 0;

        public SnapshotArray(int length) {
            listArray = new List[length];
            for (int i = 0; i < listArray.length; i++) {
                listArray[i] = new ArrayList<>();
            }
        }

        public void set(int index, int val) {
            List<int[]> records = listArray[index];
            if (records.isEmpty() || records.get(records.size() - 1)[0] < snapId) {
                records.add(new int[]{snapId, val});
            } else {
                records.get(records.size() - 1)[1] = val;
            }
        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            List<int[]> records = listArray[index];
            for (int i = records.size() - 1; i >= 0; i--) {
                if (records.get(i)[0] <= snap_id) {
                    return records.get(i)[1];
                }
            }
            return 0;
        }
    }
}

import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int total = n * n;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of every number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int num = grid[i][j];

                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int repeated = 0;
        int missing = 0;

        // Check numbers from 1 to n*n
        for (int i = 1; i <= total; i++) {

            if (map.getOrDefault(i, 0) == 2) {
                repeated = i;
            }

            if (map.getOrDefault(i, 0) == 0) {
                missing = i;
            }
        }

        return new int[]{repeated, missing};
    }
}
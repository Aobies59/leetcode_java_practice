// Solution to Problem 1 - Merge Sorted Arrays
// Beats 95% of users in memory usage, but pretty slow


public class Merge_Sorted_Arrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        final int superior_limit = 1000000;

        for (int i = m; i < (m + n); i++) {
            nums1[i] = superior_limit;
        }

        int index_1 = 0;
        int index_2 = 0;
        while (index_1 < nums1.length && index_2 < nums2.length) {
            if (nums2[index_2] == superior_limit) {
                index_2++;
                index_1 = 0;
            } else if (nums2[index_2] < nums1[index_1]) {
                int temp_2 = nums2[index_2];
                nums2[index_2] = nums1[index_1];
                nums1[index_1] = temp_2;
            } else {
                index_1++;
            }
        }
    }
}
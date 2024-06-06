// Solution to Problem 3 - Remove duplicates of sorted array
// Pretty slow, but beats 51% of users in memory management

import java.util.Arrays;

public class Remove_Duplicates_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        if (nums.length == 0)
            return k;
        k++;
        
        int index_2 = nums.length - 1;
        int index_1;
        int previous_number = nums[index_2];
        final int max_number = previous_number + 1;
        while ((index_1 = index_2 - 1) >= 0) {
            if (nums[index_1] == previous_number) {
                nums[index_1 + 1] = nums[index_2];
                nums[index_2] = max_number;
                index_2--;
            } else {
                previous_number = nums[index_1];
                index_2--;
                k++;
            }
        }
        Arrays.sort(nums);

        return k;
    }
}
 
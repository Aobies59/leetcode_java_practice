// Solution to problem 4 - Remove Duplicates from Sorted Array II
// 0ms runtime and beats ~95% of users in memory usage

public class Remove_Duplicates_Sorted_Array_2 {
    public int removeDuplicates(int[] nums) {
        int last_num = nums[0];
        boolean num_twice = false;
        int beginning_index = 1;
        for (int i = 1; i < nums.length; i++) {
            final int num = nums[i];
            if (!num_twice || last_num != num) {
                num_twice = last_num == num;
                last_num = num;
                nums[beginning_index] = last_num;
                beginning_index++;
            }
        }
        return beginning_index;
    }
}

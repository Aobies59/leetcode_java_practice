// Solution to Problem 2 - Remove Element
// 0ms runtime, and beats 55% of users in memory usage

class Remove_Element {
    public static int removeElement(int[] nums, int val) {
        int k = 0;

        int i = 0;
        int j = nums.length - 1;

        if (j < 0)  // if nums is an empty array
            return k;

        if (j == 0)  // if nums has length 1
            return (nums[0] == val) ? 0 : 1;

        while (i != j) {
            while (i < j && nums[i] != val) {
                i++;
                k++;
            }

            while (j > i && nums[j] == val) {
                j--;
            }

            if (nums[j] != val && nums[i] == val) {
                int temp_i = nums[i];
                nums[i] = nums[j];
                nums[j] = temp_i;
            } else if (nums[i] != val) {  // if val was not found
                return k + 1;
            }
        }

        return k;
    }
}
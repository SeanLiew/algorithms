package leet.bimethod;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-10-22 18:50
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if ((index == 0 || (index > 0 && nums[index] > nums[index - 1])) &&
                    (index == nums.length - 1 || (index < nums.length - 1 && nums[index] > nums[index + 1]))) {
                return index;
            }
            if (nums[index] >= nums[index + 1]) {
                index += 2;
            } else {
                index += 1;
            }
        }
        return 0;
    }


    @Test
    public void testSearch(){
        int[] arr = {2};
        int i = findPeakElement(arr);

        System.out.println(i);
    }
}

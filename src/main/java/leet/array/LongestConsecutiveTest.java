package leet.array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-22 18:43
 */
public class LongestConsecutiveTest {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            int length = 0;
            int num = nums[i];
            if (!set.contains(nums[i] - 1)) {
                while (set.contains(num++)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    @Test
    public void test(){
        System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2,6,7,8,9,10}));
    }

}

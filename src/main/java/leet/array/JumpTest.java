package leet.array;

import org.junit.Test;

public class JumpTest {
    @Test
    public void test1(){
        int[] num = {1,3,0,0,0,0,4};

        System.out.println(canJump(num));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;

    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return 1;
        }
        int n  = 0;
        int pointer = 0;
        int position = 0;
        while (position < nums.length - 1) {
            n++;
            int maxPosition = 1;
            for (int i = 1; i <= nums[pointer]; i++) {
                int next = pointer + i;
                if (next >= nums.length - 1) {
                    return n;
                }
                if (pointer + i + nums[next] > maxPosition) {
                    maxPosition = pointer + i + nums[next];
                    position = pointer + i;
                }
            }
            pointer = position;
        }
        return n;
    }

    @Test
    public void test2(){
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,3,1}));
        System.out.println(jump(new int[]{3,2,1}));
        System.out.println(jump(new int[]{2,3,1,1,2,1,3}));
        System.out.println(jump(new int[]{1,2,3}));
    }

    public int jump3(int[] nums) {
        int ans = 0;
        int end = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++)
        {
            maxPos = Math.max(nums[i] + i, maxPos);
            if (i == end)
            {
                end = maxPos;
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void test3(){
        System.out.println(jump3(new int[]{2,3,5,1,2,1,3}));
    }

    @Test
    public void test4(){
        System.out.println(canJump4(new int[]{2,0,0}));
        System.out.println(canJump4(new int[]{3,2,1,0,4}));
        System.out.println(canJump4(new int[]{1,2,3}));
    }

    public boolean canJump4(int[] nums) {
        int k = 0;
        for (int i = 0; i <= k && k < nums.length - 1; i++) {
            k = Math.max(k, nums[i] + i);
        }
        return k >= nums.length - 1;
    }

    public int jump5(int[] nums) {
        int ans = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {
                end = maxPos;
                ans++;
            }

        }
        return ans;
    }

    @Test
    public void test5(){
        System.out.println(jump5(new int[]{2,3,1,1,4}));
    }
}

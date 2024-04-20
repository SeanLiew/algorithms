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
        return 1;
    }

    @Test
    public void test2(){
        int[] num = {1,3,0,0,0,0,4};

        System.out.println(jump(num));
    }
}

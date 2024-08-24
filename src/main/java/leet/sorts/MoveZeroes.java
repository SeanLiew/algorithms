package leet.sorts;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int current = nums[j];
                if (current == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p++] = nums[i];
            }
        }
        for (int i = p; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    @Test
    public void test(){
        int[] arr1 = {0, 3, 0, 1, 0, 2};
        moveZeroes2(arr1);

        System.out.println(JSON.toJSONString(arr1));
    }
}

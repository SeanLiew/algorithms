package leet.nums;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Desc:
 * @Author: Sean
 * @Date: 2021/3/8 17:52
 */
public class ExchangeNum {
    @Test
    public void test (){
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,65,11,12,13,14,15};

        System.out.println(JSON.toJSONString(exchange(nums)));
    }

    public int[] exchange(int[] nums) {
        int[] newArr = new int[nums.length];
        int postIndex = nums.length - 1;
        int preIndex = 0;
        for (int i=0; i<nums.length;i++){
            if (nums[i] % 2 != 0){
                newArr[preIndex++] = nums[i];
            } else {
                newArr[postIndex--] = nums[i];
            }
        }
        return newArr;

    }
}

package leet.nums;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        //头指针
        int start = 0;
        //尾指针
        int end = 0;
        while (end <= nums.length - 1) {
            //到数组结尾，加入list
            if (end == nums.length - 1) {
                list.add(start == end ? nums[start] + "" : nums[start] + "->" + nums[end]);
                break;
            }
            //判断end下一个是否比end大1
            if (nums[end + 1] - nums[end] == 1) {
                //尾指针后移
                end++;
            } else {
                //加入list
                list.add(start == end ? nums[start] + "" : nums[start] + "->" + nums[end]);
                start = end + 1;
                end = end + 1;
            }

        }
        return list;
    }

    @Test
    public void test(){
        int[] nums = {0,1,3,4,5,6};
        System.out.println(JSON.toJSON(summaryRanges(nums)));
    }
}

package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class ArrayRemoveTest {

    @Test
    public void test(){
        int[] arr = {1,1,2,2,4,5,5,6,7,7,8};
        int i = removeDuplicates(arr);
        System.out.println(JSON.toJSON(arr));

        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        int result = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[result] != nums[i]){
                nums[++result] = nums[i];
            }
        }
        return result + 1;
    }


    @Test
    public void testRemoveDuplicates2(){
        int[] arr = {1,1,2,2,2,3,4,4};
        int i = testRemoveDuplicates2(arr);
        System.out.println(JSON.toJSON(arr));

        System.out.println(i);
    }

    public int testRemoveDuplicates2(int[] nums) {
        int result = 1;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[result] || nums[i] != nums[result-1]){
                nums[++result] = nums[i];
            }
        }
        return result + 1;
    }


    @Test
    public void test2(){
        int[] arr = {3,2,2,3};
        int i = removeElement(arr, 3);

        System.out.println(i);

    }

    public int removeElement(int[] nums, int val) {
        int result = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[result++] = nums[i];
            }
        }


        return result;
    }

    public int removeElement2(int[] nums, int val) {
        int result = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                result++;
            }
        }
        System.out.println(JSON.toJSON(nums));

        return result;
    }

    @Test
    public void test22(){
        int[] arr = {3,2,2,3};
        int i = removeElement2(arr, 3);

        System.out.println(i);

    }


}

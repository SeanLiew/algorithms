package leet.array;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/7/7  11:28
 **/
public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {4, 4, 6, 1, 1};
        int repeat = singleNumber2(arr);
        System.out.println(repeat);
    }

    public static int singleNumber(int[] nums) {
        d: for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                if (i != j && nums[i] == nums[j]){
                    continue d;
                }
            }
            return nums[i];
        }
        return 0;
    }
    public static int singleNumber2(int[] nums) {
        int single = 0;
        for (int i : nums){
            single ^= i;
        }
        return single;
    }
}

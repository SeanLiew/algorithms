package leet.array;

/**
 * desc: 找出重复数字
 * author: liuxiaozheng
 * time: 2020/6/22  14:27
 **/
public class RepeatNum {
    public static void main(String[] args) {
        int[] arr = {12, 1, 63, 41, 60, 76, 18, 1, 3 ,4, 5, 6, 21,7, 54, 3, 23, 2, 12, 11, 90, 12, 43};
        int repeat = find(arr);
        System.out.println(repeat);
    }

    public static int find(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                if (nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return 0;
    }
}

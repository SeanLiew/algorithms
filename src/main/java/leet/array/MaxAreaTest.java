package leet.array;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-07 20:45
 */
public class MaxAreaTest {
    @Test
    public void test(){
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int i = maxArea(arr);

        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int min = height[right] < height[left] ? height[right] : height[left];
            int area = (min) * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}

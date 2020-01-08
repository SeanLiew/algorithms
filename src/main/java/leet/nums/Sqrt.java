package leet.nums;

import org.junit.Test;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/1/8  11:25
 **/
public class Sqrt {



    @Test
    public void test(){
        int result = mySqrt(5);
        System.out.println(result);
    }

    public int mySqrt(int x) {
        if (x == 0){
            return 0;
        }

        int left = 1;

        int right = x / 2 + 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            int num = x / mid;

            if (num == mid){
                return mid;
            }
            if (left +1 == right){
                return left;
            }
            if (num < mid){
                right = mid;
            } else{
                left = mid;
            }
        }
        return 0;
    }
}

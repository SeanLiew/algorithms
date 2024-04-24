package leet.nums;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NumTest2 {

    @Test
    public void testCountAndSay (){

        System.out.println(isHappy(2));
    }

    boolean isHappy(int n) {
        int slowRunner = next(n);
        int fastRunner = next(next(n));
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = next(slowRunner);
            fastRunner = next(next(fastRunner));
        }
        return fastRunner == 1;
    }

    public int next(int num) {
        int result = 0;
        while (num > 0) {
            int i = num % 10;
            result = result + i * i;
            num = num / 10;
        }
        return result;
    }



    @Test
    public void testContainsDuplicate(){

        System.out.println(containsDuplicate(new int[]{1,2,3,4,4}));
    }
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (map.get(num) != null) {
                return true;
            }
            map.put(num, num);
        }
        return false;
    }

}

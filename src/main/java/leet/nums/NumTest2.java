package leet.nums;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NumTest2 {

    @Test
    public void testCountAndSay (){

        System.out.println(isHappy(7));
    }

    boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && fastRunner != slowRunner){
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }

        return fastRunner == 1;
    }

    int getNext(int n){
        int next = 0;
        while(n >= 1){
            int i = n % 10;
            next = next + i * i;
            n = n /10;
        }
        return next;
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

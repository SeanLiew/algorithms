package leet.nums;

import leet.utils.GsonUtils;
import org.junit.Test;

public class SortedNums {
    public int minArray(int[] numbers) {

        int i = 0, j = numbers.length - 1;

        while (i < j){
            int m = (i + j) / 2;

            if (numbers[m] > numbers[j]){
                i = m + 1;
            } else if (numbers[m] < numbers[j]){
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];

    }


    @Test
    public void test(){
        int[] nums = {4,5,6,3,2,1};
        System.out.println(minArray(nums));
    }
}

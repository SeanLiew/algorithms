package leet.nums;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Desc:
 * @Author: Sean
 * @Date: 2021/3/10 14:23
 */
public class MajorityNum {
    @Test
    public void test (){

        int[] arr = {2,1,4,2,1,2,5};


        System.out.println(JSON.toJSONString(insert(arr)));
        System.out.println(majorityElement(arr));
    }
    public int majorityElement(int[] nums) {


        return 0;
    }

    public static int[] insert(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i++){
            int insert = arr[i];
            b: for (int j = i - 1; j >= 0; j--){
                if (insert < arr[j]){
                    arr[j + 1] = arr[j];
                    arr[j] = insert;
                } else{
                    arr[j + 1] = insert;
                    break b;
                }
            }
        }
        return arr;
    }
    public static int[] insert2(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int insert = arr[i];

            for (int j = i - 1; j >= 0; j--){

            }

        }



        return arr;
    }

}

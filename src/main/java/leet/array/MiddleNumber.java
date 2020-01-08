package leet.array;

import org.junit.Test;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2019/12/18  16:11
 **/
public class MiddleNumber {
    @Test
    public void test (){

//        int[] nums1 = {1, 2, 5, 6, 9};
//
//        int[] nums2 = {2, 3};

        int[] nums1 = {1, 4, 5, 9, 10};

        int[] nums2 = {6, 7};

        int search = this.search(nums1, nums2);

//        System.out.println(search(nums1));
//        System.out.println(search(nums1, 1, 3));

        System.out.println(search);
    }

    public int search(int[] nums1, int[] nums2){

        int totalLength = nums1.length + nums2.length;

        int startMiddle = totalLength / 2;

        int i1 =  middleIndex(nums1);

        int min1 = 0;

        int max1 = nums1.length - 1;

        int i2 = middleIndex(nums2);

        int min2 = 0;

        int max2 = nums2.length - 1;

        while(i1 + i2 != startMiddle){
            if (nums1[i1] > nums2[i2 + 1]){
                max1 = i1;
                i1 = (min1 + i1) / 2;
            }

            while (i1 + i2 != startMiddle){
                if (i1 == max1 - 1){
                    i1 = max1;
                    break;
                }
                if (i1 == min1 + 1){
                    i1 = min1;
                    break;
                }

                if (i1 + i2 < startMiddle){
                    min1 = i1;
                    i1 = (i1 + max1) / 2;
                    break;

                }
                if (i1 + i2 > startMiddle){
                    max1 = i1;
                    i1 = (min1 + i1) / 2;
                    break;
                }
            }

            if (nums2[i2] > nums1[i1 + 1]){
                max2 = i2;
                i2 = (min2 + i2) / 2;
            }

            while (i1 + i2 != startMiddle){
                if (i2 == max2 - 1){
                    i2 = max2;
                    break;
                }

                if (i2 == min2 + 1){
                    i2 = min2;
                    break;
                }

                if (i1 + i2 < startMiddle){
                    min2 = i2;
                    i2 = (i2 + max2) / 2;
                }
                if (i1 + i2 > startMiddle){
                    max2 = i2;
                    i2 = (min2 + i1) / 2;
                }
            }
        }
        if (totalLength % 2 == 0){
            return (nums1[i1] + nums2[i2]) / 2;
        }

        return nums1[i1] > nums2[i2] ? nums1[i1] : nums2[i2];
    }

    public double search(int[] nums1){
        int length = nums1.length;

        if (length == 0){
            return 0;
        }

        if (length % 2 == 0){
            double sum = nums1[length/2 - 1] + nums1[length/2];
            return sum/2;
        }

        return nums1[length/2];
    }
    public int middleIndex(int[] nums1){
        int length = nums1.length;

        if (length == 0){
            return 0;
        }

        if (length % 2 == 0){
            return length/2 - 1;
        }

        return length/2;
    }

    public double search(int[] nums1, int start, int end){
        int length = end + 1 - start;

        if (nums1.length == 0){
            return 0;
        }

        if (length % 2 == 0){
            double sum = nums1[start + end/2] + nums1[start + end/2 + 1];
            return sum/2;
        }

        return nums1[start + length/2];
    }

    public int[] searchIndex(int[] nums1, int start, int end){
        int length = end + 1 - start;

        if (nums1.length == 0){
            int[] arr = {};
            return arr;
        }

        if (length % 2 == 0){
            int[] arr = {start + end/2, start + end/2 + 1};
            return arr;
        }
        int[] arr = {start + end/2, start + end/2 + 1};

        return arr;
    }


}

package leet.code;

import org.junit.Test;


/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-06-20 19:53
 */
public class TestRandomSet {
    @Test
    public void test () {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(2));

    }
}

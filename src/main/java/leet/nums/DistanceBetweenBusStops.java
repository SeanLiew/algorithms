package leet.nums;

import org.junit.Test;

public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance == null || distance.length == 0 || distance.length == 1) {
            return 0;
        }
        int sum = 0;
        int dis = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
            if (start < destination && start <= i && i < destination) {
                dis += distance[i];
            }
            if (start > destination && (start <= i || i < destination)) {
                dis += distance[i];
            }
        }
        return Math.min(dis, sum - dis);

    }
    @Test
    public void test() {
        int[] distance = {1,2,3,4};
        System.out.println(distanceBetweenBusStops(distance, 0,1));
        int[] distance2 = {7,10,1,12,11,14,5,0};
        System.out.println(distanceBetweenBusStops(distance2, 7,2));
    }
}

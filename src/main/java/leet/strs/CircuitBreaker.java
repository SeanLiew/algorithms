package leet.strs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-07-03 14:25
 */
public class CircuitBreaker {

    private Map<String, CircuitBreakerRule> map = new HashMap<>();

    private int failedThreadshold = 80;



    public void invokeMethod (String methodName) {
        CircuitBreakerRule circuitBreakerRule = map.get(methodName);
        if (circuitBreakerRule == null) {
            circuitBreakerRule = new CircuitBreakerRule();
            map.put(methodName, circuitBreakerRule);
        }
        Map<Integer, CircuitBreakerTimer> timeMap = circuitBreakerRule.getTimeMap();
        Integer currentTime = getCurrentTime();
        CircuitBreakerTimer circuitBreakerTimer = timeMap.get(currentTime);
        if (circuitBreakerTimer == null) {
            circuitBreakerTimer = new CircuitBreakerTimer();
            timeMap.put(currentTime, circuitBreakerTimer);
        }
        int methodCount = circuitBreakerTimer.getMethodCount();
        int methodFailedCount = circuitBreakerTimer.getMethodFailedCount();

        circuitBreakerTimer.setMethodCount(methodCount);
        circuitBreakerTimer.setMethodFailedCount(methodFailedCount);
        if (methodFailedCount > failedThreadshold) {
            //不执行methodName;
            return;
        }
        methodCount++;
        try {
            //执行 methodName
        } catch(Exception e) {
            methodFailedCount++;
        }
    }


    private Integer getCurrentTime () {
        return (int)System.currentTimeMillis() / 1000;
    }



    class CircuitBreakerRule{

        private Map<Integer, CircuitBreakerTimer> timeMap = new HashMap();


        public Map<Integer, CircuitBreakerTimer> getTimeMap() {
            return timeMap;
        }

        public void setTimeMap(Map<Integer, CircuitBreakerTimer> timeMap) {
            this.timeMap = timeMap;
        }
    }


    class CircuitBreakerTimer {
        /**
         * 接口请求次数
         */
        private int methodCount;

        private int methodFailedCount;

        public int getMethodCount() {
            return methodCount;
        }

        public void setMethodCount(int methodCount) {
            this.methodCount = methodCount;
        }

        public int getMethodFailedCount() {
            return methodFailedCount;
        }

        public void setMethodFailedCount(int methodFailedCount) {
            this.methodFailedCount = methodFailedCount;
        }
    }
}




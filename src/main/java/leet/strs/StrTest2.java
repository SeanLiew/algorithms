package leet.strs;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StrTest2 {

    @Test
    public void testIsIsomorphic(){

        System.out.println(this.isIsomorphic("egg", "add"));
        System.out.println(this.isIsomorphic("bar", "foo"));
        System.out.println(this.isIsomorphic("paper", "title"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character cs = s.charAt(i);
            Character ct = t.charAt(i);
            Character cAtS = mapS.get(cs);
            Character cAtT = mapT.get(ct);
            if (cAtS == null && cAtT == null) {
                mapS.put(cs, ct);
                mapT.put(ct, cs);
            } else {
                if (!cs.equals(cAtT)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void testChar(){
        String guess = "1o1o3o4j5";

        for (int i = 0; i < guess.length(); i++) {
            System.out.println(guess.charAt(i) + "");
        }
    }

    public String getHint(String secret, String guess) {
        Map<Integer, String> secretIndexElementMap = new HashMap<>();
        Map<String, Integer> secretElementCountMap = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            String element = secret.charAt(i) + "";
            secretIndexElementMap.put(i, element);
            Integer count = secretElementCountMap.get(element);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            secretElementCountMap.put(element, count);
        }
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            String guessElement = guess.charAt(i) + "";
            String secreteElement = secretIndexElementMap.get(i);
            Integer count = secretElementCountMap.get(guessElement);
            if (guessElement.equals(secreteElement)) {
                bulls++;
                if (count != null) {
                    count--;
                    secretElementCountMap.put(guessElement, count);
                }
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            String guessElement = guess.charAt(i) + "";
            String secreteElement = secretIndexElementMap.get(i);
            Integer count = secretElementCountMap.get(guessElement);
            if (guessElement.equals(secreteElement)) {
                continue;
            }
            if (count != null && count > 0) {
                count--;
                secretElementCountMap.put(guessElement, count);
                cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

    @Test
    public void testGetHint(){
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
        System.out.println(getHint("1122", "2211"));
        System.out.println(getHint("1123", "0111"));
        System.out.println(getHint("1122", "1222"));
        System.out.println(getHint("11", "10"));
    }
}

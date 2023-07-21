package leet.strs;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StrTest2 {

    @Test
    public void testIsIsomorphic(){

        System.out.println(this.isIsomorphic("egg", "add"));
        System.out.println(this.isIsomorphic("foo", "bar"));
        System.out.println(this.isIsomorphic("paper", "title"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            Character a = s.charAt(i);
            Character b = t.charAt(i);
            Character chrA = mapS.get(a);
            Character chrB = mapT.get(b);
            if (chrA == null && chrB == null){
                mapS.put(a, b);
                mapT.put(b, a);
            } else {
                if (!a.equals(chrB)){
                    return false;
                }
                if (!b.equals(chrA)){
                    return false;
                }
            }
        }
        return true;
    }
}

package by.mich;

import java.util.HashMap;
import java.util.Map;

public class L0205_IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = map.get(s.charAt(i));
            if (c == null) {
                map.put(s.charAt(i), t.charAt(i));
            } else if (c != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

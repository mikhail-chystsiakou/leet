package by.mich;

import java.util.HashMap;
import java.util.Map;

public class L0205_IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
//        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Character[] map = new Character[256];
        boolean[] usedT = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (
                (map[sc] != null && map[sc] != tc)
                    || (map[sc] == null && usedT[tc])
            ) {
                return false;
            } else {
                map[sc] = tc;
                usedT[tc] = true;
            }
        }
        return true;
    }
}

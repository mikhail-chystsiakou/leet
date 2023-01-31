package by.mich;

public class L0567_PermutationInString {
    public static void main(String[] args) {
        assert !checkInclusion("ab", "eidboaoo");
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1map = new int[26];
        int[] s2map = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i)-'a']++;
            s2map[s2.charAt(i)-'a']++;
        }
        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(s1map[i] == s2map[i]) {
                count++;
            }
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (count == 26) return true;

            int r = s2.charAt(i) - 'a';
            int l = s2.charAt(i - s1.length()) - 'a';
            s2map[r]++;
            if (s2map[r] == s1map[r]) {
                count++;
            } else if (s2map[r]-1 == s1map[r]){
                count--;
            }
            s2map[l]--;
            if (s2map[l] == s1map[l]) {
                count++;
            } else if (s2map[l]+1 == s1map[l]){
                count--;
            }
        }
        return count == 26;
    }

    // 651ms 42mb
    // 16% 86%
    public static boolean checkInclusionBad(String s1, String s2) {
        int[] letters = new int[26];
        int[] lettersTmp = new int[26];
        for(char c : s1.toCharArray()) {
            letters[c-'a']++;
            lettersTmp[c-'a']++;
        }

        int leftToFind = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            for (int j = 0; i+j < s2.length() && j < s1.length(); j++) {
                if (lettersTmp[s2.charAt(i+j) - 'a'] > 0) {
                    lettersTmp[s2.charAt(i+j) - 'a']--;
                    leftToFind--;
                } else {
                    break;
                }
                if (leftToFind == 0){
                    return true;
                }
            }
            if(leftToFind < s1.length()) {
                System.arraycopy(letters, 0, lettersTmp, 0, letters.length);
                leftToFind = s1.length();
            }
        }
        return false;
    }
}

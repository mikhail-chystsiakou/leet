package by.mich;

public class L0771_JewelsAndStones {

    public static void main(String[] args) {
        assert numJewelsInStones(
            "ab",
            "aaabbdd"
        ) == 5;
        assert numJewelsInStones(
            "UGz",
            "YSb"
        ) == 0;
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int[] jewelsArr = new int[52];
        for (int i = 0; i < jewels.length(); i++) {
            int pos = charToInt(jewels.charAt(i));
            jewelsArr[pos] = 1;
        }

        int result = 0;
        for (int i = 0; i < stones.length(); i++) {
            int pos = charToInt(stones.charAt(i));

            if (jewelsArr[pos] == 1) result++;
        }
        return result;
    }

    /**
     * Maps char value to int
     * A - 0
     * B - 1
     * ...
     * a - 26
     * b - 27
     */
    public static int charToInt(char c) {
        int i = c - 'a';
        if (i < 0) i = c - 'A' + 26;
        return i;
    }
}

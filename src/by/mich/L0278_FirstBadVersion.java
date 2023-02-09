package by.mich;

public class L0278_FirstBadVersion {
    public static void main(String[] args) {
        firstBadVersion(2126753390);
    }
    public static boolean isBadVersion(int i) {
        return i == 1702766719;
    }
    public static int firstBadVersion(int n) {
        long l = 0, r = n;
        int i = (int)((l + r) / 2);
        while(l < r) {
            if(isBadVersion(i)) {
                r = i - 1;
            } else {
                l = i + 1;
            }
            i = (int)((l + r) / 2);
        }
        return isBadVersion(i) ? i : i + 1;
    }
}

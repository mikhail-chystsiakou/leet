package by.mich;

/**
 * You are given an array representing a row of seats where seats[i] = 1
 * represents a person sitting in the ith seat, and seats[i] = 0 represents
 * that the ith seat is empty (0-indexed).
 *
 * There is at least one empty seat, and at least one person sitting.
 *
 * Alex wants to sit in the seat such that the distance between him and the
 * closest person to him is maximized.
 */
public class L0849_MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        maxDistToClosest(new int[] {1,0,0,0,1,0,1});
    }

    // https://leetcode.com/problems/maximize-distance-to-closest-person/submissions/890347049/
    // 100 65
    public static int maxDistToClosest(int[] seats) {
        int max = 0;
        int current = 0;
        int rightLength = 0;
        int leftLength = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                current++;
            } else {
                if (max < current) {
                    max = current;
                }
                if (i == max && i != 0) {
                    leftLength = max;
                }
                current = 0;
            }
        }
        rightLength = current;

        int midLength = (max - 1) / 2 + 1;
        return Math.max(midLength, Math.max(leftLength, rightLength));
    }

    // https://leetcode.com/problems/maximize-distance-to-closest-person/submissions/890342816/
    // 100 90
    public static int maxDistToClosestTwoPointers(int[] seats) {
        int max = 0;
        for (int l = 0, r = 0; r < seats.length; r++) {
            if (seats[r] == 1) {
                if ((r - l) > max) {
                    max = r - l;
                }
                l = r+1;
            }
        }
        max = (max+1) / 2;
        for (int i = 0; i < seats.length; i++)
            if (seats[i] == 1) {
                if (max < i) max = i;
                break;
            }
        for (int i = 0; i < seats.length; i++)
            if (seats[seats.length - 1 - i] == 1) {
                if (max < i) max = i;
                break;
            }
        return max;
    }
}

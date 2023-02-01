package by.mich;

public class L0724_FindPivotIndex {
    public static void main(String[] args) {
        assert pivotIndex(new int[] {2, -1, 1}) == 0;
    }

    // https://leetcode.com/problems/find-pivot-index/submissions/889075611/?envType=study-plan&id=level-1
    // 100 95
    public static int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (runningSum*2+nums[i] == sum) {
                return i;
            }
            runningSum += nums[i];
        }
        return -1;
    }
}

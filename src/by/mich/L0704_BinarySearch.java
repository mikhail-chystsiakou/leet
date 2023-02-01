package by.mich;

public class L0704_BinarySearch {
    public static void main(String[] args) {
        assert binarySearch(new int[] {2, 5}, 5) == 1;
    }

    public static int binarySearch(int[] nums, int target) {
        int s = 0, e = nums.length - 1;

        while (s <= e) {
            int m = (s + e) / 2;
            if (nums[m] == target) return m;

            if (nums[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return searchRecursive(nums, 0, nums.length-1, target);
    }

    public static int searchRecursive(int[] nums, int start, int end, int target) {
        int i = (end + start) / 2;

        if (target == nums[i]) return target;
        if (start == end) return -1;

        if (target > nums[i]) {
            int newStart = (start + end)/2 + 1;
            return searchRecursive(nums, newStart, end, target);
        } else {
            int newEnd = (start + end)/2 - 1;
            if (newEnd < 0) newEnd = 0;
            return searchRecursive(nums, start, newEnd, target);
        }
    }
}

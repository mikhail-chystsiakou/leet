package by.mich;

import java.util.Arrays;

public class L0912_QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[] {5, 2, 3, 1})));
    }
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    // 5 2 3 1 i = 1 j = 0
    // 2 5 3 1 i = 0 j = 0
    // 2 5 3 1 i = 0 j = 3
    // 1 2 5 3 i = 1 j = 3
    // 1 2 5 3 0-0, 2-3
    public static void quickSort(int[] nums, int li, int ri) {
        if (ri - li < 1) return;

        int i = (li + ri) / 2;
        for (int j = li; j <= ri; j++) {
            if (nums[j] > nums[i] && j < i) {
                shiftLtoR(nums, j, i);
                i--;
                j--;
            } else if (nums[j] < nums[i] && j > i) {
                shiftRtoL(nums, i, j);
                i++;
                j--;
            }
        }
        quickSort(nums, li, i-1);
        quickSort(nums, i+1, ri);
    }

    private static void shiftLtoR(int[] nums, int l, int r) {
        for (int i = l; i < r; i++) {
            int tmp = nums[i+1];
            nums[i+1] = nums[i];
            nums[i] = tmp;
        }
    }

    private static void shiftRtoL(int[] nums, int l, int r) {
        for (int i = r; i > l; i--) {
            int tmp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = tmp;
        }
    }
}

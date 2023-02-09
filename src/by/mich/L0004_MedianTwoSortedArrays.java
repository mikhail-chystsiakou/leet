package by.mich;

public class L0004_MedianTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(
            new int[]{1, 3},
            new int[]{2}
        ));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int d = (nums1.length + nums2.length - 1) / 2 - 1;
        int l = 0, r = d;
        int i1;
        // 1 2 3 4
        for(i1 = (r + l + 1) / 2; l != r; i1 = (r + l + 1) / 2) {
            int c = checkOrdered(i1, d - i1, nums1, nums2);
            if (c == 0) break;

            if (c == -1) {
                r = i1 -1 ;
            } else {
                l = i1 + 1;
            }
        }
        Data median = getNext(i1, d - i1, nums1, nums2);
        if ((nums1.length + nums2.length) % 2 == 1) return median.next;
        Data nextMedian = getNext(median.i1, median.i2, median.nums1, median.nums2);

        return (median.next + nextMedian.next) / 2.0;
    }

    static class Data {
        int i1;
        int i2;
        int[] nums1;
        int[] nums2;
        int next;

        public Data(int i1, int i2, int[] nums1, int[] nums2, int next) {
            this.i1 = i1;
            this.i2 = i2;
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.next = next;
        }
    }

    /**
     * 1 2 3 4
     * 1 3 4 5
     */
    public static Data getNext(int i1, int i2, int[] nums1, int[] nums2) {
        if (i1 >= nums1.length - 1) return new Data(i2, i1, nums2, nums1, nums2[i2+1]);
        if (i2 >= nums2.length - 1) return new Data(i1, i2, nums1, nums2, nums1[i1+1]);

        if (nums1[i1+1] <= nums2[i2+1]) return new Data(i1, i2, nums1, nums2, nums1[i1+1]);
        if (nums1[i1+1] > nums2[i2+1]) return new Data(i2, i1, nums2, nums1, nums2[i2+1]);

        return null;
    }


    public static int checkOrdered(int i1, int i2, int[] nums1, int[] nums2) {
        if (i1 == nums1.length-1 && i2 == nums2.length - 1) return 0;

        if (i1 >= nums1.length) return -1;
        if (i2 >= nums2.length) return 1;

        if (i1 == nums1.length-1 && nums2[i2+1] < nums1[i1]) return -1;
        if (i2 == nums2.length-1 && nums1[i1+1] < nums2[i2]) return 1;
        if (nums2[i2+1] < nums1[i1]) return -1;
        if (nums1[i1+1] < nums2[i2]) return 1;

        return 0;
    }
}

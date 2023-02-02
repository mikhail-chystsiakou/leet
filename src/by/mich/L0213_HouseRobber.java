package by.mich;

public class L0213_HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3}));
        // 1,1,3,6,7,10,7,1,8,5,9,1,4,4,3
        //     3   7    7   8   9   4   3
        // 1,3,6,7,10,7,1,8,5,9,1,4,4,3
        //     3   7    7   8   9   4   3

        // 1 5 1 1 5
    }

    public static int rob(int[] nums) {
        return getSum(nums, 0, 0, 0);
    }

    public static int getSum(int[] houses, int maxSum, int curSum, int depth) {

        boolean isLeaf = true;
        for (int i = 0; i < houses.length; i++) {
            if (depth == 1) {
                System.out.println("i = ?");
            }
            if (depth == 1 && curSum == 3) {
                System.out.println("i = ?");
            }
            if (houses[i] == -1) continue;
            if (i == 2 && curSum == 0) {
                System.out.println("here");
            }
            if (i == 4 && curSum == 3) {
                if (Thread.currentThread().getStackTrace().length == 5) {
                    System.out.println("on 5 level");
                }
                System.out.println("here 2");
            }


            isLeaf = false;

            int h = houses[i];
            curSum += h;


            int li = i == 0 ? houses.length - 1 : i - 1;
            int ri = i == houses.length - 1 ? 0 : i + 1;
            int l = houses[li];
            int r = houses[ri];
            houses[li] = -1;
            houses[i] = -1;
            houses[ri] = -1;

            int newSum = getSum(houses, maxSum, curSum, depth+1);
            if (i == 2 && curSum == 3) {
                System.out.println("here");
            }
            if (newSum > maxSum) maxSum = newSum;

            houses[i] = h;
            houses[li] = l;
            houses[ri] = r;
            curSum -= h;
        }

        return isLeaf ? curSum : maxSum;
    }
}

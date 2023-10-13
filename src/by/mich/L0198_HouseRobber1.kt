package by.mich

/**
 * Time spent: 33min20sec
 * https://leetcode.com/problems/house-robber/submissions/1074039766
 */
fun main() {
    rob(arrayOf(1, 2, 3, 1).toIntArray())
}

fun rob(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums[0]
    }

    val dp = IntArray(nums.size)
    dp[0] = nums[0]

    var lastTaken = false
    dp[1] = if (nums[0] < nums[1]) {
        lastTaken = true
        nums[1]
    } else nums[0]

    for (i in 2 until nums.size) {
        if (!lastTaken) {
            dp[i] = dp[i-1] + nums[i]
            lastTaken = true
        } else if (dp[i-2] + nums[i] > dp[i-1]){
            dp[i] = dp[i-2] + nums[i]
            lastTaken = true
        } else {
            dp[i] = dp[i-1]
            lastTaken = false
        }
    }
    return dp[nums.size-1]
}
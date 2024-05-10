package com.example.hackerrankproblems

class RemoveDuplicatesFromArray {
    fun removeDuplicates(nums: IntArray): Int {
        var left = 0
        for (i in 1..nums.size) {
            if (nums[i] != nums[left]) {
                left++
                nums[left] = nums[i]
            }
        }
        return left + 1
    }
}
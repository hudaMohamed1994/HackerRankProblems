package com.example.hackerrankproblems

class FindMedianOfArrays {
        fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
            val mergedArray = nums1.plus(nums2)
            mergedArray.sort()
            val n = mergedArray.size
            return if (n % 2 == 0) {
                val mid1 = mergedArray[n / 2 - 1].toDouble()
                val mid2 = mergedArray[n / 2].toDouble()
                (mid1 + mid2) / 2.0
            } else {
                mergedArray[n / 2].toDouble()
            }
        }
}
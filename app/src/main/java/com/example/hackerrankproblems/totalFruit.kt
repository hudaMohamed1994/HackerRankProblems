import kotlin.math.max

    fun totalFruit(nums: IntArray): Int {
        val distinctElements = mutableMapOf<Int, Int>()
        var start = 0
        var total = 0
        var res = 0

        for (i in nums.indices) {
            if (!distinctElements.containsKey(nums[i])) {
                distinctElements[nums[i]] = 1
            } else {
                distinctElements[nums[i]] = distinctElements[nums[i]]!! + 1
            }
            total += 1

            while (distinctElements.size > 2) {
                var f = nums[start]
                distinctElements[f] = distinctElements[f]!! - 1
                total -= 1
                start += 1
                if(distinctElements[f] == 0)
                {
                    distinctElements.remove(f)
                }
            }
            res = max(res, total)
        }
        return res

    }

fun main ()
{
    val nums1 = intArrayOf(1,2,3,2,2)
    totalFruit(nums1)
    println(    totalFruit(nums1)
    )

}

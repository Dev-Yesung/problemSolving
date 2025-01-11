package leet_code

fun main() {
    val answer = threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
    answer.forEach { println(it) }
}

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val answer: MutableList<List<Int>> = mutableListOf()
    for (i in 0 until nums.size - 2) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }

        var leftPtr = i + 1
        var rightPtr = nums.size - 1
        while (leftPtr < rightPtr) {
            val sum = nums[i] + nums[leftPtr] + nums[rightPtr]
            if (sum < 0) {
                leftPtr++
            } else if (sum > 0) {
                rightPtr--
            } else {
                answer.add(listOf(nums[i], nums[leftPtr], nums[rightPtr]))

                while (leftPtr < rightPtr && nums[leftPtr] == nums[leftPtr + 1]) {
                    leftPtr++
                }
                while (leftPtr < rightPtr && nums[rightPtr] == nums[rightPtr - 1]) {
                    rightPtr--
                }

                leftPtr++
                rightPtr--
            }
        }
    }

    return answer
}

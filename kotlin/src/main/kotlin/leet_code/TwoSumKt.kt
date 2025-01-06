package leet_code

fun main() {
    val answer = twoSum(intArrayOf(2, 7, 11, 15), 9)
    println(answer.contentToString())
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val numsMap: MutableMap<Int, Int> = mutableMapOf()
    for ((i, num) in nums.withIndex()) {
        if (numsMap.containsKey(target - num)) {
            return intArrayOf(numsMap.get(target - num) ?: 0, i)
        }
        numsMap[num] = i
    }

    return intArrayOf(0, 0)
}

package leet_code

fun main() {
    val answer = arrayPairSum(intArrayOf(6, 2, 6, 5, 1, 2))
    println(answer)
}

fun arrayPairSum(nums: IntArray): Int {
    var answer = 0
    nums.sort()
    for ((i, num) in nums.withIndex()) {
        if (i % 2 == 0) {
            answer += num
        }
    }
    return answer
}

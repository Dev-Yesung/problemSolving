package leet_code

fun main() {
    val answer = trap(intArrayOf(4, 2, 0, 3, 2, 5))
    println(answer)
}

fun trap(height: IntArray): Int {
    var answer = 0
    var leftPtr = 0
    var rightPrt = height.size - 1
    var leftMax = height[leftPtr]
    var rightMax = height[rightPrt]

    while (leftPtr < rightPrt) {
        leftMax = height[leftPtr].coerceAtLeast(leftMax)
        rightMax = height[rightPrt].coerceAtLeast(rightMax)
        if (leftMax <= rightMax) {
            answer += leftMax - height[leftPtr]
            leftPtr++
        } else {
            answer += rightMax - height[rightPrt]
            rightPrt--
        }
    }

    return answer
}

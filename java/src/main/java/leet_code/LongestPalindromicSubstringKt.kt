package leet_code

fun main() {
    val answer = longestPalindromicSubstring("ac")
    println(answer)
}

fun longestPalindromicSubstring(s: String): String {
    val length = s.length
    if (length <= 1) {
        return s
    }

    var maxStr = s.substring(0, 1)
    for (i in 0 until length - 1) {
        val odd = extendFromCenter(s, i, i)
        val even = extendFromCenter(s, i, i + 1)
        if (odd.length > maxStr.length) {
            maxStr = odd
        }
        if (even.length > maxStr.length) {
            maxStr = even
        }
    }

    return maxStr
}

fun extendFromCenter(s: String, left: Int, right: Int): String {
    var leftVal = left
    var rightVal = right
    while (leftVal >= 0 && rightVal < s.length && s[leftVal] == s[rightVal]) {
        leftVal--
        rightVal++
    }
    return s.substring(leftVal + 1, rightVal)
}

package leet_code

import java.util.Arrays

fun main() {
    val charArray = charArrayOf('h', 'e', 'l', 'l', 'o')
    val origin = Arrays.copyOfRange(charArray, 0, charArray.size)
    reverseString(charArray)
    println(origin)
    println(charArray)
}

fun reverseString(s: CharArray) {
    var start = 0
    var end = s.size - 1
    while (start < end) {
        s[start] = s[end].also { s[end] = s[start] }
        start++
        end--
    }
}
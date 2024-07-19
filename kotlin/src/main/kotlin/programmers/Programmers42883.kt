package programmers

fun main() {
    val answer = Programmers42883()
        .solution("1231234", 3)
    println(answer)
}

class Programmers42883 {

    fun solution(number: String, k: Int): String {
        var count = k
        val numbers = number.toMutableList()
        val result = ArrayDeque<Char>()
        for (num in numbers) {
            while (count > 0 && result.isNotEmpty() && result.last() < num) {
                result.removeLast()
                count--
            }
            result.addLast(num)
        }

        while (count > 0) {
            result.removeLast()
            count--
        }

        return result.joinToString("")
    }

}

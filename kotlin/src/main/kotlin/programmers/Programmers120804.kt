package programmers

fun main(args: Array<String>) {
    val answer = Programmers120804()
        .solution(4, 5)

    println(answer)
}

class Programmers120804 {

    fun solution(num1: Int, num2: Int): Int {
        return num1 * num2;
    }
}

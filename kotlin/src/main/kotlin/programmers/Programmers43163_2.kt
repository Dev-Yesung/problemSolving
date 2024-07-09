package programmers

class Programmers43163_2 {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val isVisited = BooleanArray(n)
        for (computer in 0 until n) {
            if (isVisited[computer]) {
                continue;
            }

            visitAll(computer, computers, isVisited)
            answer++
        }

        return answer
    }

    private fun visitAll(computer: Int, computers: Array<IntArray>, isVisited: BooleanArray): Unit {
        val stack = mutableListOf<Int>()

        stack.add(computer)
        while (stack.isNotEmpty()) {
            val current = stack.removeLast()

            if (isVisited[current]) {
                continue
            }
            isVisited[current] = true

            for (next in 0 until computers[current].size) {
                if (computers[current][next] == 0) {
                    continue
                }

                stack.add(next)
            }
        }
    }
}

package programmers

class Programmers43162_1 {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val isVisited = Array(n) { false }
        for (computer in 0 until n) {
            if (isVisited[computer]) {
                continue;
            }

            visitAll(computer, computers, isVisited)
            answer++
        }

        return answer
    }

    private fun visitAll(computer: Int, computers: Array<IntArray>, isVisited: Array<Boolean>): Unit {
        val queue = mutableListOf<Int>()

        isVisited[computer] = true
        queue.add(computer)
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            for (next in 0 until computers[current].size) {
                if (computers[current][next] == 0 || isVisited[next]) {
                    continue
                }

                isVisited[next] = true
                queue.add(next)
            }
        }
    }
}

package programmers

fun main(args: Array<String>) {
    val answer = Programmers49191_1()
        .solution(
            5, arrayOf(
                intArrayOf(4, 3),
                intArrayOf(4, 2),
                intArrayOf(3, 2),
                intArrayOf(1, 2),
                intArrayOf(2, 5)
            )
        )
    println(answer)
}

class Programmers49191_1 {
    fun solution(n: Int, results: Array<IntArray>): Int {
        val graph = Array(n) { BooleanArray(n) }
        for (edge in results) {
            val winner = edge[0] - 1
            val loser = edge[1] - 1
            graph[winner][loser] = true
        }

        var answer = 0
        for (v in 0 until n) {
            val wins = countForward(v, graph, BooleanArray(n)) - 1
            val loses = countBackward(v, graph, BooleanArray(n)) - 1

            if (wins + loses + 1 == n) {
                answer++
            }
        }

        return answer
    }

    private fun countForward(targetVertex: Int, graph: Array<BooleanArray>, isVisited: BooleanArray): Int {
        var count = 1

        for (vertex in graph.indices) {
            if (!graph[targetVertex][vertex] || isVisited[vertex]) {
                continue
            }

            isVisited[vertex] = true
            count += countForward(vertex, graph, isVisited)
        }

        return count
    }

    private fun countBackward(targetVertex: Int, graph: Array<BooleanArray>, isVisited: BooleanArray): Int {
        var count = 1

        for (vertex in graph.indices) {
            if (!graph[vertex][targetVertex] || isVisited[vertex]) {
                continue
            }

            isVisited[vertex] = true
            count += countBackward(vertex, graph, isVisited)
        }

        return count
    }
}

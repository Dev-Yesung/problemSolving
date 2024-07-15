package programmers

fun main() {
    val answer = Programmers1844_1()
        .solution(
            arrayOf(
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 0, 1, 0, 1),
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 1, 1, 0, 1),
                intArrayOf(0, 0, 0, 0, 1)
            )
        )

    println("Answer: $answer")
}


class Programmers1844_1 {
    private val WALL = 0
    private val dx = intArrayOf(1, 0, -1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)

    fun solution(maps: Array<IntArray>): Int {
        val row = maps.size
        val col = maps[0].size
        val step = Array(row) { IntArray(col) }
        val queue = mutableListOf<Pair<Int, Int>>()

        queue.add(Pair(0, 0))
        step[0][0] = 1
        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            for (dir in 0 until 4) {
                val nx = curr.first + dx[dir]
                val ny = curr.second + dy[dir]

                if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                    continue
                }
                if (maps[nx][ny] == WALL) {
                    continue
                }
                if (step[nx][ny] > 0) {
                    continue
                }

                queue.add(Pair(nx, ny))
                step[nx][ny] = step[curr.first][curr.second] + 1
            }
        }
        val answer = step[row - 1][col - 1]

        return if (answer == 0) -1 else answer
    }
}

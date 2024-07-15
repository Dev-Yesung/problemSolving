package programmers

class Programmers43163 {

    fun solution(begin: String, target: String, words: Array<String>): Int {
        if (!words.contains(target)) {
            return 0
        }

        val isVisited = BooleanArray(words.size)
        val queue = mutableListOf<Pair<String, Int>>()
        queue.add(Pair(begin, 0))

        while (queue.isNotEmpty()) {
            val (word, step) = queue.removeFirst()

            if (word == target) {
                return step
            }

            for (i in word.indices) {
                val next = words[i]
                if (!isConvertable(word, next)) {
                    continue
                }
                if (isVisited[i]) {
                    continue
                }

                isVisited[i] = true
                queue.add(Pair(next, step + 1))
            }
        }

        return 0
    }

    private fun isConvertable(src: String, dst: String): Boolean {
        val srcArray = src.toCharArray()
        val dstArray = dst.toCharArray()

        var diff = 0
        for (i in srcArray.indices) {
            if (srcArray[i] != dstArray[i]) {
                diff++
            }
        }

        return diff == 1
    }
}

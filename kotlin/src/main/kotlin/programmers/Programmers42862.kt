package programmers

class Programmers42862 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val lostList = (lost.sorted() - reserve.sorted()).toMutableList()
        val reserveList = (reserve.sorted() - lost.sorted()).toMutableList()
        var answer = n - lostList.size
        for (i in lostList) {
            if (reserveList.contains(i - 1)) {
                reserveList.remove(i - 1)
                answer += 1
            } else if (reserveList.contains(i + 1)) {
                reserveList.remove(i + 1)
                answer += 1
            }
        }

        return answer
    }

}

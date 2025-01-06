package leet_code

fun main() {
    val answer = groupAnagram(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    println(answer)
}

fun groupAnagram(strs: Array<String>): List<List<String>> {
    val answerMap: MutableMap<String, MutableList<String>> = mutableMapOf()
    for (str in strs) {
        val key = str.toCharArray().sorted().joinToString("")
        answerMap.getOrPut(key) { mutableListOf() }
        answerMap[key]!!.add(str)
    }

    return ArrayList<List<String>>(answerMap.values)
}

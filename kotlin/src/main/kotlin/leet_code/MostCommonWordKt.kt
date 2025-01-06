package leet_code

fun main() {

}

fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    val counts: MutableMap<String, Int> = mutableMapOf()
    val words = paragraph.replace("\\W+".toRegex(), " ")
        .lowercase()
        .trim()
        .split(" ")
    for (word in words) {
        if (banned.contains(word)) {
            continue
        }
        counts[word] = counts.getOrDefault(word, 0) + 1
    }

    return counts.maxByOrNull { it.value }!!.key
}

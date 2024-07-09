package ch02

// 불변량 개념을 문제와 함께 학습하는 챕터

const val WIDTH : Int = 4
const val HEIGHT : Int = 3

fun main() {
    val totalCuttingCount = calculateWidthCutCount(WIDTH) + calculateHeightCutCount(WIDTH, HEIGHT)
    println("Chocolate Cutting Count is $totalCuttingCount")
}

fun calculateWidthCutCount(width: Int): Int {
    return width - 1
}

fun calculateHeightCutCount(width: Int, height: Int): Int {
    return width * (height - 1)
}

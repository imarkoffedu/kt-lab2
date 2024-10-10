package org.imarkoff.lab2

fun listOfSquares(list: List<Int>) : List<Int> {
    return list.map { it * it }
}

fun main() {
    print("List of squares of numbers from 1 to 5: ")
    val list = listOf(1, 2, 3, 4, 5)
    val squares = listOfSquares(list)
    println(squares)

    print("The sum of squares of numbers from 1 to 5: ")
    val sum = squares.sum()
    println(sum)

    print("Cartesian product of second list: ")
    val firstList = listOf(1, 2, 3)
    val secondList = listOf(3, 4)
    // flatMap removes inset array after each mapping
    // Pair. та прикол якісь тупо пара з двох значень і на тому всьо
    val cartesianProduct = firstList.flatMap { i -> secondList.map { j -> Pair(i, j)} }
    println(cartesianProduct)
}
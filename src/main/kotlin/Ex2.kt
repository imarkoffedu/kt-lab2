package org.imarkoff.lab2

data class Trader(val name: String, val city: String)

data class Transaction(
    val trader: Trader,
    val year: Int, val month: Int,
    val value: Int, val currency: Currency
)

enum class Currency {
    UAH, USD, EUR
}

fun main() {
    val UAH = Currency.UAH
    val USD = Currency.USD
    val EUR = Currency.EUR

    val raoul = Trader("Raoul", "Cambridge")
    val mario = Trader("Mario", "Milan")
    val alan = Trader("Alan", "Cambridge")
    val brian = Trader("Brian", "Cambridge")

    val traders = listOf(raoul, mario, alan, brian)
    val transactions = listOf(
        Transaction(brian, 2011, 12, 300, UAH),
        Transaction(raoul, 2012, 10, 1000, UAH),
        Transaction(raoul, 2011, 11, 400, USD),
        Transaction(mario, 2012, 9, 710, UAH),
        Transaction(mario, 2012, 7, 700, USD),
        Transaction(alan, 2012, 4, 950, EUR)
    )

    println("1. Find all transactions made in 2011 and sort by price (from lowest to highest)")
    val transIn2011 = transactions.filter { it.year == 2011 }.sortedBy { it.value }
    println(transIn2011)

    println()

    print("2. Traders works in: ")
    val cities = mutableSetOf<String>()
    traders.map { cities.add(it.city) }
    println(cities)

    println()

    println("3. Find all traders from Cambridge and sort them by name")
    val tradersInILiveInBangladeshILiveInBangladesh = traders
        .filter { it.city == "Cambridge" }
        .sortedBy { it.name }
    println(tradersInILiveInBangladeshILiveInBangladesh)

    println()

    print("4. Sorted traders names: ")
    val sortedTradersNames = traders
        .map { it.name }
        .sorted()
    println(sortedTradersNames)

    println()

    print("5. Are there traders in Milan? ")
    val tradersInMilan = traders
        .filter { it.city == "Milan" }
        .isNotEmpty()
    println(if (tradersInMilan) "Yes" else "No")

    println()

    println("6. All transactions from traders who live in Cambridge")
    val transactionsInCambridge = transactions
        .filter { it.trader.city == "Cambridge" }
    println(transactionsInCambridge)

    println()

    println("7. The most expensive transaction")
    var theMostExpensiveTransaction: Transaction? = null
    for (transaction in transactions)
        if (theMostExpensiveTransaction == null ||
            transaction.value > theMostExpensiveTransaction.value)
            theMostExpensiveTransaction = transaction
    println(theMostExpensiveTransaction)

    println()

    println("8. Group by currency")
    val groupedByCurrency = transactions
        .groupBy { it.currency }
    println(groupedByCurrency)

    print("9. Sum of all transaction in UAH currency: ")
    var uahSum = 0
    for (transaction in transactions)
        if (transaction.currency == UAH)
            uahSum += transaction.value
    println(uahSum)

    println()

    println("10. Stringified transactions and ordered by date.")
    var transactionsByDate = transactions
        .sortedWith(compareBy({ it.year }, {it.month})) // https://stackoverflow.com/a/37259451

    for ((index, tr) in transactionsByDate.withIndex()) {
        val nextPointer = if (transactionsByDate.size > index + 1) "-> " else ""
        print("${index + 1}. ${tr.month}-${tr.year}: ${tr.value} ${tr.currency} $nextPointer")
    }
}
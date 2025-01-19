package ru.netology

val cardType = "Mastercard"
val transactionsPerMonth: Int = 0
val currentTransaction: Int = 150_000

fun masterCardFee(currentTransaction: Int, transactionsPerMonth: Int): Int {

    val taxMultiplier = 0.006
    val taxAddition = 20
    val totalTransaction: Int = currentTransaction + transactionsPerMonth
    var totalFee: Int

    if (transactionsPerMonth > 75_000) {
        totalFee = (currentTransaction * taxMultiplier + taxAddition).toInt()
    } else if (totalTransaction > 75_000) {
        totalFee = ((totalTransaction - 75_000) * taxMultiplier + taxAddition).toInt()
    } else {
        totalFee = 0
    }

    return totalFee
}

fun visaFee(currentTransaction: Int): Int {

    val tax = 0.0075
    val min_tax = 35

    return if ((currentTransaction * tax) < 35) min_tax else (currentTransaction * tax).toInt()
}

fun taxFee(cardType: String, transactionsPerMonth: Int, currentTransaction: Int): Int {

    var fee: Int
    if (transactionsPerMonth + currentTransaction > 600_000 || currentTransaction > 150_000) {
        println("Превышение лимитов транзакций. Транзакция заблокирована.")
        return 0
    } else {
        when {
            cardType == "Mastercard" -> fee = masterCardFee(currentTransaction, transactionsPerMonth)
            cardType == "Visa" -> fee = visaFee(currentTransaction)
            else -> fee = 0
        }
    }
    return fee
}

fun main() {

    println("Размер комисии " + taxFee(cardType, transactionsPerMonth, currentTransaction))

}
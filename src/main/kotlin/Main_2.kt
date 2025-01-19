package ru.netology

fun main() {
    val cardType = "Mastercard"
    val transactionsPerMonth: Int = 0
    val currentTransaction: Int = 150_000

    fun masterCardFee(currentTransaction:Int, transactionsPerMonth: Int): Int{
        val totalTransaction: Int = currentTransaction + transactionsPerMonth
        var totalFee: Int
        if (totalTransaction > 75_000 && transactionsPerMonth == 0){
            totalFee = ((totalTransaction - 75_000) * 0.006 + 20).toInt()
        } else if (totalTransaction > 75_000) {
            totalFee = (totalTransaction * 0.006 + 20).toInt()
        } else {
            totalFee = 0
        }
        return totalFee
    }

    fun taxFee (cardType: String, transactionsPerMonth: Int, currentTransaction: Int): Int{

        var fee: Int
        if (transactionsPerMonth + currentTransaction > 600_000  || currentTransaction > 150_000){
            println("Превышение лимитов транзакций. Транзакция заблокирована.")
            return 0
        } else {
            when {
            cardType == "Mastercard" -> fee = masterCardFee(currentTransaction, transactionsPerMonth)
            cardType == "Visa" -> fee = (currentTransaction * 0.0075 + 35).toInt()
            else -> fee = 0
            }
        }
        return fee
    }

    println("Размер комисии "+ taxFee(cardType, transactionsPerMonth, currentTransaction))

}
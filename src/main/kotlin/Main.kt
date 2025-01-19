package ru.netology

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val secAgo = 259201

    fun secToMin(sec: Int):String {
        val min = sec / 60
        var minText = ""
        if ((min % 10 == 1) && !(min == 11)) {
            minText = "минуту"
        } else if((min % 10 >= 5 && min % 10 <= 9) || min == 11 || min == 12 || min ==13 || min == 14){
            minText = "минут"
        }else if (min % 10 == 2 || min % 10 == 3 || min % 10 == 4) {
            minText = "минуты"
        } else {
            minText = "минут"
        }
        return "$min $minText"
    }

    fun secToHours(sec: Int): String {
        val hours = (sec / 3600).toInt()
        var hourText = ""
        if ((hours == 1 || hours == 21)) {
            hourText = "час"
        } else if (hours >= 5 && hours <= 20) {
            hourText = "часов"
        } else {
            hourText = "часа"
        }
        return "$hours $hourText"
    }

    fun agoToText(secAgo: Int):String {
        var returnText = ""
        when {
            secAgo <= 60 -> returnText = "только что"
            secAgo > 60 && secAgo < 3600 -> returnText = secToMin(secAgo) + " назад"
            secAgo >= 3600 && secAgo < 24 * 60 * 60 -> returnText = secToHours(secAgo) + " назад"
            secAgo >= 24 * 60 * 60 && secAgo < 24 * 60 * 60 * 2 -> returnText = "вчера"
            secAgo >= 24 * 60 * 60 * 2 && secAgo < 24 * 60 * 60 * 3 -> returnText = "позавчера"
            secAgo >= 24 * 60 * 60 * 3 -> returnText = "давно"
        }
        return "был(а) $returnText"
    }

    val result = agoToText(secAgo)
    println(result)
}
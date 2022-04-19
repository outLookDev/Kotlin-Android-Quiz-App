package com.azmovhudstv.myquizgame

import java.lang.Integer.SIZE
import kotlin.random.Random

object Constants {
    fun getQuestion(): ArrayList<Question> {
        var quzList = ArrayList<Question>()
      var   SIZE:Int=0
        var question1 = Question(
            1,
            "Kotlinda int qanday qiymat oladi ?",
            "Matn",
            "Vergulli Son",
            "Son",
            "Endi bilib olaman",
            3
        )
        quzList.add(question1)
        var question2 = Question(
            2,
            "Linear Layout Qanday Layout ?",
            "Chiziqli Layout",
            "Absolyut Layout",
            "Chiziqsiz Layout",
            "Endi Bilib Olaman",
            1
        )
        quzList.add(question2)
        var question3 = Question(
            3,
            "Var bilan val ortasidagi farq Nima ?",
            "var son oladi  val esa yoq",
            "val ozgarmaydigan qiymat var esa ozgaruvchan",
            "val ozgaruvchan qiymat var esa ozgarmas ",
            "Endi bilib olaman ",
            2
        )
        quzList.add(question3)
        var question4 = Question(
            4,
            "Kotlinda Courtine Nima ?",
            "Sinf uchun Kotlin Atamasi",
            "Asinxron kodni Taqdim Etadi ",
            "Data Type",
            "Endi bilib olaman ",
            2
        )
        quzList.add(question4)
        var question5= Question(
            5,
            "\"42\"Kotlinda Stringni a ga aylantirish uchun to'g'ri sintaksis qanday Long?\n",
            "var i =\"42\".toLong",
            "Long i =\"42\" ",
            "var i:Long=\"42\"",
            "Endi bilib olaman ",
            1
        )
        quzList.add(question5)
        while (quzList.size <= SIZE) {
            val random = Random(quzList.size)
            val randomNumber: Int = random.nextInt()
        }
        return quzList
    }
}
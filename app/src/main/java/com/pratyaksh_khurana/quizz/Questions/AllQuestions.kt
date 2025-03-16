package com.pratyaksh_khurana.quizz.Questions

import android.os.Parcel
import android.os.Parcelable

class AllQuestions() : Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    fun insertAll(): List<QuestionEntity> {

        val iList: MutableList<QuestionEntity> = mutableListOf()

        // Математика
        val q1 = QuestionEntity(
            id = null,
            question = "Какое из следующих чисел не является простым?",
            op1 = "31",
            op2 = "61",
            op3 = "71",
            op4 = "91",
            answer = "91",
            subject = "математика"
        )
        val q2 = QuestionEntity(
            id = null,
            question = "Какое наименьшее число необходимо прибавить к 1056, чтобы сумма делилась на 23 без остатка?",
            op1 = "2",
            op2 = "3",
            op3 = "18",
            op4 = "21",
            answer = "2",
            subject = "математика"
        )
        val q3 = QuestionEntity(
            id = null,
            question = "1397 × 1397 = ?",
            op1 = "1981709",
            op2 = "1951609",
            op3 = "18362619",
            op4 = "2031719",
            answer = "1951609",
            subject = "математика"
        )
        val q4 = QuestionEntity(
            id = null,
            question = "Какое наибольшее четырехзначное число делится на 88 без остатка?",
            op1 = "8888",
            op2 = "9768",
            op3 = "9988",
            op4 = "9944",
            answer = "9944",
            subject = "математика"
        )
        val q5 = QuestionEntity(
            id = null,
            question = "Какое из следующих чисел является простым?",
            op1 = "33",
            op2 = "81",
            op3 = "93",
            op4 = "97",
            answer = "97",
            subject = "математика"
        )

        // География
        val q6 = QuestionEntity(
            id = null,
            question = "Процент орошаемых земель в Индии примерно составляет:",
            op1 = "45",
            op2 = "65",
            op3 = "35",
            op4 = "25",
            answer = "35",
            subject = "география"
        )
        val q7 = QuestionEntity(
            id = null,
            question = "Какова столица Индийского субконтинента?",
            op1 = "Берлин",
            op2 = "Дели",
            op3 = "Ченнаи",
            op4 = "Стокгольм",
            answer = "Дели",
            subject = "география"
        )
        val q8 = QuestionEntity(
            id = null,
            question = "Какой штат в Индии имеет наибольшую площадь лесного покрова?",
            op1 = "Аруначал-Прадеш",
            op2 = "Харьяна",
            op3 = "Мадхья-Прадеш",
            op4 = "Ассам",
            answer = "Мадхья-Прадеш",
            subject = "география"
        )
        val q9 = QuestionEntity(
            id = null,
            question = "Самые древние горы в Индии:",
            op1 = "Аравалы",
            op2 = "Виндхиас",
            op3 = "Сатпуры",
            op4 = "Нильгирские холмы",
            answer = "Аравалы",
            subject = "география"
        )
        val q10 = QuestionEntity(
            id = null,
            question = "Какая страна имеет наибольшее население?",
            op1 = "Индия",
            op2 = "Япония",
            op3 = "Китай",
            op4 = "Шиллинг",
            answer = "Китай",
            subject = "география"
        )

        // Литература
        val q11 = QuestionEntity(
            id = null,
            question = "О каком из этих персонажей писал Марк Твен?",
            op1 = "Little boy blue",
            op2 = "Dennis the menace",
            op3 = "Красная Шапочка",
            op4 = "Том Сойер",
            answer = "Том Сойер",
            subject = "литература"
        )
        val q12 = QuestionEntity(
            id = null,
            question = "Кто написал «Убить пересмешника»?",
            op1 = "Dr. Seuss",
            op2 = "Харпер Ли",
            op3 = "Рональд Рейган",
            op4 = "Джон Леннон",
            answer = "Харпер Ли",
            subject = "литература"
        )
        val q13 = QuestionEntity(
            id = null,
            question = "В какой пьесе Шекспира влюбленные совершают самоубийство?",
            op1 = "Ромео и Джульетта",
            op2 = "Lonesome Dove",
            op3 = "Breakfast at Tiffany's",
            op4 = "Run rabbit run",
            answer = "Ромео и Джульетта",
            subject = "литература"
        )
        val q14 = QuestionEntity(
            id = null,
            question = "Что лучше всего описывает «Скотный двор» Джорджа Оруэлла?",
            op1 = "Женщины/месячные циклы",
            op2 = "Бейб Рут/Янкиз",
            op3 = "Динозавры/Барни",
            op4 = "Животные/Коммунизм",
            answer = "Животные/Коммунизм",
            subject = "литература"
        )
        val q15 = QuestionEntity(
            id = null,
            question = "В какой книге основное внимание уделено лошади?",
            op1 = "The Muppets",
            op2 = "Animal Farm",
            op3 = "Черная красавица",
            op4 = "One Flew Over the Cuckoo's Nest",
            answer = "Черная красавица",
            subject = "литература"
        )

        iList.add(q1)
        iList.add(q2)
        iList.add(q3)
        iList.add(q4)
        iList.add(q5)
        iList.add(q6)
        iList.add(q7)
        iList.add(q8)
        iList.add(q9)
        iList.add(q10)
        iList.add(q11)
        iList.add(q12)
        iList.add(q13)
        iList.add(q14)
        iList.add(q15)

        return iList
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        // Можно добавить сериализацию данных, если требуется
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AllQuestions> {
        override fun createFromParcel(parcel: Parcel): AllQuestions {
            return AllQuestions(parcel)
        }

        override fun newArray(size: Int): Array<AllQuestions?> {
            return arrayOfNulls(size)
        }
    }
}

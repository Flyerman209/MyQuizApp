package com.pratyaksh_khurana.quizz.Questions

import android.os.Parcel
import android.os.Parcelable

class AllQuestions() : Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    fun insertAll(): List<QuestionEntity> {

        val iList: MutableList<QuestionEntity> = mutableListOf()

        // Математика
        // Математика (простые задачи)
        val q1 = QuestionEntity(
            id = null,
            question = "Чему равна сумма чисел 25 и 37?",
            op1 = "52",
            op2 = "62",
            op3 = "58",
            op4 = "63",
            answer = "62",
            subject = "математика"
        )
        val q2 = QuestionEntity(
            id = null,
            question = "Сколько будет 7 умножить на 8?",
            op1 = "54",
            op2 = "56",
            op3 = "49",
            op4 = "63",
            answer = "56",
            subject = "математика"
        )
        val q3 = QuestionEntity(
            id = null,
            question = "Если от 100 отнять 45, получится...",
            op1 = "65",
            op2 = "55",
            op3 = "45",
            op4 = "60",
            answer = "55",
            subject = "математика"
        )
        val q4 = QuestionEntity(
            id = null,
            question = "Чему равен корень из 81?",
            op1 = "7",
            op2 = "8",
            op3 = "9",
            op4 = "10",
            answer = "9",
            subject = "математика"
        )
        val q5 = QuestionEntity(
            id = null,
            question = "Решите уравнение: x + 12 = 20. Найдите x.",
            op1 = "8",
            op2 = "32",
            op3 = "10",
            op4 = "12",
            answer = "8",
            subject = "математика"
        )

// География (про Россию)
        val q6 = QuestionEntity(
            id = null,
            question = "Какой город является столицей России?",
            op1 = "Санкт-Петербург",
            op2 = "Казань",
            op3 = "Москва",
            op4 = "Новосибирск",
            answer = "Москва",
            subject = "география"
        )
        val q7 = QuestionEntity(
            id = null,
            question = "Самая длинная река в России:",
            op1 = "Енисей",
            op2 = "Обь",
            op3 = "Волга",
            op4 = "Лена",
            answer = "Волга",
            subject = "география"
        )
        val q8 = QuestionEntity(
            id = null,
            question = "Какое море омывает южные берега России?",
            op1 = "Балтийское",
            op2 = "Каспийское",
            op3 = "Азовское",
            op4 = "Черное",
            answer = "Черное",
            subject = "география"
        )
        val q9 = QuestionEntity(
            id = null,
            question = "Самый крупный полуостров России:",
            op1 = "Крымский",
            op2 = "Ямал",
            op3 = "Таймыр",
            op4 = "Камчатка",
            answer = "Таймыр",
            subject = "география"
        )
        val q10 = QuestionEntity(
            id = null,
            question = "Как называется самая высокая гора России?",
            op1 = "Эльбрус",
            op2 = "Ключевская Сопка",
            op3 = "Белуха",
            op4 = "Фишт",
            answer = "Эльбрус",
            subject = "география"
        )

// Литература (русская классика, школьная программа)
        val q11 = QuestionEntity(
            id = null,
            question = "Кто написал роман «Война и мир»?",
            op1 = "Фёдор Достоевский",
            op2 = "Александр Пушкин",
            op3 = "Лев Толстой",
            op4 = "Иван Тургенев",
            answer = "Лев Толстой",
            subject = "литература"
        )
        val q12 = QuestionEntity(
            id = null,
            question = "Кто автор поэмы «Руслан и Людмила»?",
            op1 = "Александр Пушкин",
            op2 = "Михаил Лермонтов",
            op3 = "Николай Гоголь",
            op4 = "Афанасий Фет",
            answer = "Александр Пушкин",
            subject = "литература"
        )
        val q13 = QuestionEntity(
            id = null,
            question = "Главный герой романа Достоевского «Преступление и наказание»:",
            op1 = "Пётр Верховенский",
            op2 = "Евгений Онегин",
            op3 = "Родион Раскольников",
            op4 = "Обломов",
            answer = "Родион Раскольников",
            subject = "литература"
        )
        val q14 = QuestionEntity(
            id = null,
            question = "Кто написал «Капитанскую дочку»?",
            op1 = "Иван Тургенев",
            op2 = "Михаил Лермонтов",
            op3 = "Александр Пушкин",
            op4 = "Николай Гоголь",
            answer = "Александр Пушкин",
            subject = "литература"
        )
        val q15 = QuestionEntity(
            id = null,
            question = "В каком произведении Гоголя появляется Чичиков?",
            op1 = "Мертвые души",
            op2 = "Ревизор",
            op3 = "Тарас Бульба",
            op4 = "Шинель",
            answer = "Мертвые души",
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

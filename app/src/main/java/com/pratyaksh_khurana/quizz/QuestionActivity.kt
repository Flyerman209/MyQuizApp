package com.pratyaksh_khurana.quizz

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pratyaksh_khurana.quizz.History.HistoryEntity
import com.pratyaksh_khurana.quizz.History.HistoryViewModel
import com.pratyaksh_khurana.quizz.Questions.QuestionEntity
import com.pratyaksh_khurana.quizz.Questions.QuestionViewModel
import com.pratyaksh_khurana.quizz.databinding.ActivityQuestionBinding
import java.util.*

class QuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionBinding
    private lateinit var subjectChosen: String
    private lateinit var userName: String

    private var i = 0
    private var correct = 0
    private var incorrect = 0
    private var points = 0
    private var totalPoints = 0

    // для сохранения истории пользователя
    private val viewModel1: HistoryViewModel by viewModels()

    private val viewModel: QuestionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userName = intent.getStringExtra("user").toString()
        // предмет, выбранный на предыдущем экране
        subjectChosen = intent.getStringExtra("subject").toString()

        // установить выбранный предмет
        binding.subject.text = getString(R.string.chosenSubject, subjectChosen)

        when (subjectChosen) {
            "Математика" -> {
                getMathQues()
            }
            "География" -> {
                getGeographyQues()
            }
            "Литература" -> {
                getLiteratureQues()
            }
        }

        // при нажатии кнопки "назад" возвращаемся на экран выбора предмета
        binding.backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    // отобразить вопросы на экране
    private fun renderQuesOnScreen(question: List<QuestionEntity>, index: Int) {

        // сбросить все варианты к состоянию по умолчанию
        binding.op1.isChecked = true

        if (i == 4) {
            binding.nextBtn.text = "ЗАВЕРШИТЬ"
        }
        // если вопросы закончились
        // переход к экрану с результатами
        // на данный момент происходит переход на экран выбора предмета
        if (i > 4) {
            Toast.makeText(
                this,
                "Правильных: $correct, Неправильных: $incorrect, Очков: $points",
                Toast.LENGTH_SHORT
            ).show()

//            totalPoints = viewModel1.getTotalPointsOfUser(userName) + points
//            Toast.makeText(this,totalPoints.toString(),Toast.LENGTH_LONG).show()

            viewModel1.insert(
                HistoryEntity(
                    id = null,
                    username = userName,
                    subject = subjectChosen,
                    earned = points,
                    date = currentDate(),
                    time = currentTime()
                )
            )

            // переход к экрану результатов для отображения итогов текущего прохождения
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("subject", subjectChosen)
            intent.putExtra("correct", correct)
            intent.putExtra("incorrect", incorrect)
            intent.putExtra("currentDate", currentDate())
            intent.putExtra("currentTime", currentTime())
            intent.putExtra("pointScoredCurrent", points)

            // общее количество очков, набранных по выбранному предмету
            intent.putExtra("totalPointsTillDate", totalPoints)

            startActivity(intent)
        } else {

            val idx = (index + 1)
            binding.questionNumber.text = getString(R.string.questionNumber, idx)
            binding.questionText.text = question[index].question
            binding.op1.text = question[index].op1
            binding.op2.text = question[index].op2
            binding.op3.text = question[index].op3
            binding.op4.text = question[index].op4

            binding.nextBtn.setOnClickListener {

                if (binding.op1.isChecked || binding.op2.isChecked || binding.op3.isChecked || binding.op4.isChecked) {

                    // подсчитать очки и количество правильных и неправильных ответов
                    if (binding.op1.isChecked) {
                        if (binding.op1.text.toString() == question[index].answer) {
                            // правильный ответ
                            correct()
                        } else {
                            // неправильный ответ
                            incorrect()
                        }
                    } else if (binding.op2.isChecked) {
                        if (binding.op2.text.toString() == question[index].answer) {
                            correct()
                        } else {
                            incorrect()
                        }
                    } else if (binding.op3.isChecked) {
                        if (binding.op3.text.toString() == question[index].answer) {
                            correct()
                        } else {
                            incorrect()
                        }
                    } else if (binding.op4.isChecked) {
                        if (binding.op4.text.toString() == question[index].answer) {
                            correct()
                        } else {
                            incorrect()
                        }
                    }

                    i++
                    renderQuesOnScreen(question, i)

                } else {
                    Toast.makeText(this, "Выберите ответ", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    // правильный ответ: +5 очков
    private fun correct() {
        correct++
        points += 5
    }

    // неправильный ответ: -2 очка
    private fun incorrect() {
        incorrect++
        points -= 2
    }

    // получить все вопросы по выбранному предмету "Математика"
    private fun getMathQues() {
        val l: List<QuestionEntity> = viewModel.getAllQuestions("математика")
        renderQuesOnScreen(l, 0)
    }

    // получить все вопросы по выбранному предмету "Литература"
    private fun getLiteratureQues() {
        val l: List<QuestionEntity> = viewModel.getAllQuestions("литература")
        renderQuesOnScreen(l, 0)
    }

    // получить все вопросы по выбранному предмету "География"
    private fun getGeographyQues() {
        val l: List<QuestionEntity> = viewModel.getAllQuestions("география")
        renderQuesOnScreen(l, 0)
    }

    // получить текущую дату
    private fun currentDate(): String {
        return SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
    }

    // получить текущее время
    private fun currentTime(): String {
        return SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
    }

    override fun onRestart() {
        onBackPressed()
        super.onRestart()
    }
}

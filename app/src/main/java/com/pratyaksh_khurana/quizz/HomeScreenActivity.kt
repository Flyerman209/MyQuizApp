package com.pratyaksh_khurana.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.pratyaksh_khurana.quizz.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // для приветствия пользователя (Привет, имя_пользователя)
        val username = intent.getStringExtra("username").toString()
        val password = intent.getStringExtra("password").toString()
        val id = intent.getStringExtra("id").toString()

        binding.helloUserName.text = getString(R.string.hello_user_name, username)

        binding.logout.setOnClickListener {

            val dialog = AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("Внимание!")
                .setIcon(R.drawable.logout_icon)
                .setMessage("Вы уверены, что хотите выйти?")
                .setNegativeButton("НЕТ") { _, _ ->
                    // ничего не делаем
                }
                .setPositiveButton("ДА") { _, _ ->
                    startActivity(Intent(this, MainActivity::class.java))
                }.show()

        }

        binding.editPassword.setOnClickListener {
            val intent = Intent(this, EditPasswordActivity::class.java)
            intent.putExtra("password", password)
            intent.putExtra("id", id)
            intent.putExtra("user", username)
            startActivity(intent)
        }

        binding.rules.setOnClickListener {
            startActivity(Intent(this, RulesActivity::class.java))
        }
        binding.startQuiz.setOnClickListener {
            val intent = Intent(this, SubjectActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }

        binding.history.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {

        val dialog = AlertDialog.Builder(this)
            .setCancelable(false)
            .setTitle("Внимание!")
            .setIcon(R.drawable.logout_icon)
            .setMessage("Вы уверены, что хотите выйти?")
            .setNegativeButton("НЕТ") { _, _ ->
                // ничего не делаем
            }
            .setPositiveButton("ДА") { _, _ ->
                startActivity(Intent(this, MainActivity::class.java))
            }.show()

    }

    // когда активность становится видимой и пользователь взаимодействует с ней,
    // этот метод вызывается для установки имени пользователя
    override fun onResume() {
        val username = intent.getStringExtra("username").toString()
        binding.helloUserName.text = getString(R.string.hello_user_name, username)
        super.onResume()
    }
}

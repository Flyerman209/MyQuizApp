package com.pratyaksh_khurana.quizz.Fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pratyaksh_khurana.quizz.Login.LoginCredentials
import com.pratyaksh_khurana.quizz.Login.LoginViewModel
import com.pratyaksh_khurana.quizz.R
import com.pratyaksh_khurana.quizz.databinding.FragmentSignUpBinding
import java.util.regex.Pattern

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Раздуваем макет для данного фрагмента
        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)

        binding.createBtn.setOnClickListener {
            // Проверяем, существует ли уже имя пользователя, чтобы избежать дублирования
            // Если имя пользователя уже используется, возвращается список пользователей
            viewModel.checkUsernameExists(binding.username.text.toString().trim())
                .observe(viewLifecycleOwner) { userList ->
                    if (userList.isEmpty()) {
                        if (binding.username.text.toString().trim().isNotEmpty() &&
                            binding.password.text.toString().trim().isNotEmpty() &&
                            binding.email.text.toString().trim().isNotEmpty()
                        ) {
                            if (isValidEmailId(binding.email.text.toString().trim())) {
                                viewModel.insert(
                                    LoginCredentials(
                                        id = null,
                                        username = binding.username.text.toString().trim(),
                                        password = binding.password.text.toString().trim(),
                                        email = binding.email.text.toString().trim()
                                    )
                                )
                                Toast.makeText(
                                    requireContext(),
                                    "Аккаунт создан",
                                    Toast.LENGTH_SHORT
                                ).show()

                                Handler(Looper.getMainLooper()).postDelayed({
                                    fragmentManager?.beginTransaction()?.apply {
                                        replace(R.id.fragmentContainer, LoginFragment())
                                            .commit()
                                    }
                                }, 1000)

                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    "Введите корректный email",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "Все поля должны быть заполнены",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Имя пользователя уже существует",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

        binding.backBtn.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer, LoginFragment())
                    .commit()
            }
        }

        return binding.root
    }

    // Функция для проверки корректности email
    private fun isValidEmailId(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\." +
                    "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\." +
                    "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\." +
                    "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|" +
                    "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }
}

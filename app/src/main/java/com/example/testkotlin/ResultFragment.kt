package com.example.testkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получаем данные из аргументов
        val userName = arguments?.getString("user_name") ?: "Unknown"
        val score = arguments?.getInt("score") ?: 0
        val totalQuestions = arguments?.getInt("total_questions") ?: 0

        // Находим View
        val tvUserName = view.findViewById<TextView>(R.id.tvUserName)
        val tvScore = view.findViewById<TextView>(R.id.tvScore)
        val btnRestart = view.findViewById<Button>(R.id.btnRestart)

        // Заполняем данные
        tvUserName.text = "User: $userName"
        tvScore.text = "The correct answers number: $score out of $totalQuestions"

        // Обработчик кнопки
        btnRestart.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_nameFragment)
        }
    }
}
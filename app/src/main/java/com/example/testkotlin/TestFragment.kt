package com.example.testkotlin
import android.os.Bundle
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController

class TestFragment : Fragment() {

    private lateinit var dbHelper: QuizDbHelper
    private lateinit var questions: List<Question>
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbHelper = QuizDbHelper(requireContext())
        questions = dbHelper.getAllQuestions()

        val btnNext = view.findViewById<Button>(R.id.btnNext)
        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)

        if (questions.isNotEmpty()) {
            displayQuestion()
        } else {
            Toast.makeText(requireContext(), "No question in the base", Toast.LENGTH_SHORT).show()
        }

        btnNext.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId != -1) {
                val selectedOption = when (selectedId) {
                    R.id.rbOptionA -> "A"
                    R.id.rbOptionB -> "B"
                    R.id.rbOptionC -> "C"
                    else -> ""
                }

                if (selectedOption == questions[currentQuestionIndex].answer) {
                    score++
                }

                currentQuestionIndex++

                if (currentQuestionIndex >= questions.size) {
                    showResults()
                } else {
                    displayQuestion()
                }
            } else {
                Toast.makeText(requireContext(), "Choose answer", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun displayQuestion() {
        val currentQuestion = questions[currentQuestionIndex]
        val tvQuestion = view?.findViewById<TextView>(R.id.txtQuestion)
        val rbOptionA = view?.findViewById<RadioButton>(R.id.rbOptionA)
        val rbOptionB = view?.findViewById<RadioButton>(R.id.rbOptionB)
        val rbOptionC = view?.findViewById<RadioButton>(R.id.rbOptionC)

        tvQuestion?.text = currentQuestion.question
        rbOptionA?.text = currentQuestion.option1
        rbOptionB?.text = currentQuestion.option2
        rbOptionC?.text = currentQuestion.option3

        view?.findViewById<RadioGroup>(R.id.radioGroup)?.clearCheck()
    }

    private fun showResults() {
        val action = TestFragmentDirections.actionTestFragmentToResultFragment(
            userName = PreferencesManager(requireContext()).getUserName() ?: "Anonymous user",
            score = score,
            totalQuestions = questions.size
        )
        findNavController().navigate(action)
    }

}
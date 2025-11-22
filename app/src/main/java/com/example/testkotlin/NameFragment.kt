package com.example.testkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
class NameFragment : Fragment() {
    private lateinit var preferencesManager: PreferencesManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_name, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preferencesManager = PreferencesManager(requireContext())

        view.findViewById<Button>(R.id.btnNext).setOnClickListener {
            val name = view.findViewById<EditText>(R.id.editName).text.toString()
            if (name.isNotEmpty()) {
                preferencesManager.saveUserName(name)
                findNavController().navigate(R.id.action_nameFragment_to_testFragment)
            }
        }
    }
}
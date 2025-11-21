package com.example.testkotlin

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val myTextView: TextView = findViewById(R.id.myTextView)
        setCustomFont(myTextView, "lao_ui.ttf", this)
    }

    fun setCustomFont(textView: TextView, fontName: String, context: Context) {
        try {
            val typeface = Typeface.createFromAsset(context.assets, "fonts/$fontName")
            textView.typeface = typeface
        } catch (e: Exception) {
            // Handle font loading error
            e.printStackTrace()
        }
    }
}
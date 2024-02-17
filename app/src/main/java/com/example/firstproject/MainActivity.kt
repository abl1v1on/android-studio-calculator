package com.example.firstproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var operator = ""

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SetTextI18n")
    fun onClickButton(view: View) {
        val textResultView = findViewById<TextView>(R.id.textResultView)

        /* Не понял как получить из view значение атрибута text, поэтому поместил значения
        кнопок в contentDescription */
        textResultView.text = "${textResultView.text}${view.contentDescription}"

    }

    @SuppressLint("SetTextI18n")
    fun onCLickOperator(view: View) {
        val operators: Array<Char> = arrayOf('+', '-', '*', '/')
        val textResultView = findViewById<TextView>(R.id.textResultView)
        val lastIndex = textResultView.text.toString().lastIndex

        if (textResultView.text[lastIndex] !in operators) {
            textResultView.text = "${textResultView.text}${view.contentDescription}"
            operator = view.contentDescription.toString()
        }
    }

    @SuppressLint("SetTextI18n")
    fun calculate(view: View) {
        val textResultView = findViewById<TextView>(R.id.textResultView)
        val splitContent = textResultView.text.toString().split(operator)

        val num1 = splitContent[0].toInt()
        val num2 = splitContent[1].toInt()

        try {
            when (operator) {
                "+" -> textResultView.text = (num1 + num2).toString()
                "-" -> textResultView.text = (num1 - num2).toString()
                "*" -> textResultView.text = (num1 * num2).toString()
                "/" -> if (num2 != 0) textResultView.text = (num1 / num2).toString() else {
                    textResultView.text = "Нельзя делить на 0"
                }
            }
        } catch (e: Exception) {
            textResultView.text = "Ошибка"
        }
    }

    fun clear(view: View) {
        val textResultView = findViewById<TextView>(R.id.textResultView)
        textResultView.text = ""
    }
}

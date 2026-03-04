package com.example.calcu

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder // Add this implementation to build.gradle

class MainActivity : AppCompatActivity() {

    private lateinit var tvInput: TextView
    private var lastNumeric: Boolean = false
    private var stateError: Boolean = false
    private var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)

        // Numerical Buttons
        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener {
                onDigit(it as Button)
            }
        }

        // Operation Buttons
        findViewById<Button>(R.id.btnPlus).setOnClickListener { onOperator("+") }
        findViewById<Button>(R.id.btnMinus).setOnClickListener { onOperator("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { onOperator("*") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { onOperator("/") }

        // Control Buttons
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            tvInput.text = ""
            lastNumeric = false
            stateError = false
            lastDot = false
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            onEqual()
        }
    }

    private fun onDigit(button: Button) {
        if (stateError) {
            tvInput.text = button.text
            stateError = false
        } else {
            tvInput.append(button.text)
        }
        lastNumeric = true
    }

    private fun onOperator(operator: String) {
        if (lastNumeric && !stateError) {
            tvInput.append(operator)
            lastNumeric = false
            lastDot = false 
        }
    }

    private fun onEqual() {
        if (lastNumeric && !stateError) {
            val txt = tvInput.text.toString()
            try {
                // Using ExpressionBuilder for safe calculation
                val expression = ExpressionBuilder(txt).build()
                val result = expression.evaluate()
                tvInput.text = result.toString()
                lastDot = true 
            } catch (ex: Exception) {
                tvInput.text = "Error"
                stateError = true
                lastNumeric = false
            }
        }
    }
}
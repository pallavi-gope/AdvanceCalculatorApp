package com.example.advancecalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.btnAdd
import kotlinx.android.synthetic.main.activity_main.btnClear
import kotlinx.android.synthetic.main.activity_main.btnDivide
import kotlinx.android.synthetic.main.activity_main.btnEndBracket
import kotlinx.android.synthetic.main.activity_main.btnEqual
import kotlinx.android.synthetic.main.activity_main.btnMultiply
import kotlinx.android.synthetic.main.activity_main.btnStartBacket
import kotlinx.android.synthetic.main.activity_main.btnSubtract
import kotlinx.android.synthetic.main.activity_main.btn_0
import kotlinx.android.synthetic.main.activity_main.btn_1
import kotlinx.android.synthetic.main.activity_main.btn_2
import kotlinx.android.synthetic.main.activity_main.btn_3
import kotlinx.android.synthetic.main.activity_main.btn_4
import kotlinx.android.synthetic.main.activity_main.btn_5
import kotlinx.android.synthetic.main.activity_main.btn_6
import kotlinx.android.synthetic.main.activity_main.btn_7
import kotlinx.android.synthetic.main.activity_main.btn_8
import kotlinx.android.synthetic.main.activity_main.btn_9
import kotlinx.android.synthetic.main.activity_main.btn_dot
import kotlinx.android.synthetic.main.activity_main.txtInput
import kotlinx.android.synthetic.main.activity_main.txtResult
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClear.setOnClickListener {
            txtResult.text = ""
            txtInput.text = ""
        }

        btn_0.setOnClickListener {
            txtInput.append("0")
        }
        btn_1.setOnClickListener {
            txtInput.append("1")
        }
        btn_2.setOnClickListener {
            txtInput.append("2")
        }
        btn_3.setOnClickListener {
            txtInput.append("3")
        }
        btn_4.setOnClickListener {
            txtInput.append("4")
        }
        btn_5.setOnClickListener {
            txtInput.append("5")
        }
        btn_6.setOnClickListener {
            txtInput.append("6")
        }
        btn_7.setOnClickListener {
            txtInput.append("7")
        }
        btn_8.setOnClickListener {
            txtInput.append("8")
        }
        btn_9.setOnClickListener {
            txtInput.append("9")
        }

        btnAdd.setOnClickListener {
            val targetEnd = arrayOf("+", "-", "/", "=", "%", "x", "*")
            val modifiedString = replaceString(txtInput.text.toString(), targetEnd, '?')
            txtInput.text = modifiedString
        }
        btnSubtract.setOnClickListener {
            txtInput.append("-")
        }
        btnMultiply.setOnClickListener {
            txtInput.append("x")
        }
        btnDivide.setOnClickListener {
            txtInput.append("/")
        }
        btnStartBacket.setOnClickListener {
            txtInput.append("(")
        }
        btnEndBracket.setOnClickListener {
            txtInput.append(")")
        }
        btn_dot.setOnClickListener {
            txtInput.append(".")
        }

        btnEqual.setOnClickListener {
            val expression = ExpressionBuilder(txtInput.text.toString()).build()
            val result = expression.evaluate()
            val longResult = result.toLong()

            if(result == longResult.toDouble()){
                txtResult.text = longResult.toString()
            }else{
                txtResult.text = result.toString()
            }
        }
    }
    fun replaceString(string: String, targetEnd: Array<String>, replacement: Char): String {
        if (targetEnd.any { string.endsWith(it) }) {
            val lastIndex = string.length - 1
            val stringBuilder = StringBuilder(string)
            stringBuilder.setCharAt(lastIndex, replacement)
            return stringBuilder.toString()
        }
        return string
    }
}
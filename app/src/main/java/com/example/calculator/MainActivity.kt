package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.button.*
import kotlinx.android.synthetic.main.input.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TwoZero.setOnClickListener { appendOnClick(true, "00") }
        oneZero.setOnClickListener { appendOnClick(true, "0") }
        one.setOnClickListener { appendOnClick(true, "1") }
        Two.setOnClickListener { appendOnClick(true, "2") }
        Three.setOnClickListener { appendOnClick(true, "3") }
        Four.setOnClickListener { appendOnClick(true, "4") }
        five.setOnClickListener { appendOnClick(true, "5") }
        six.setOnClickListener { appendOnClick(true, "6") }
        Seven.setOnClickListener { appendOnClick(true, "7") }
        Eight.setOnClickListener { appendOnClick(true, "8") }
        nine.setOnClickListener { appendOnClick(true, "9") }
        point.setOnClickListener { appendOnClick(true, ".") }
        Addition.setOnClickListener { appendOnClick(false, "+") }
        subtraction.setOnClickListener { appendOnClick(false, "-") }
        multiplication.setOnClickListener { appendOnClick(false, "*") }
        Divider.setOnClickListener { appendOnClick(false, "/") }

        clear.setOnClickListener {
            clear()
        }
        Equal.setOnClickListener {
            calculate()
        }
    percentage.setOnClickListener {
        appendOnClick(false,"%")
    }
    StepsClear.setOnClickListener {
        val length=tvInput.length()
        if (length>0)
            tvInput.text=tvInput.text.subSequence(0,length-1)
    }
    }
    private fun appendOnClick(clear: Boolean, string: String)
    {
        if (clear) {
            tvOutput.text = ""
            tvInput.append(string)
        } else {
            tvInput.append(tvOutput.text)
            tvInput.append(string)
            tvOutput.text = ""
        }
    }
    private fun clear() {
        tvInput.text = ""
        tvOutput.text = ""

    }
    private fun calculate() {
        try {
            val input = ExpressionBuilder(tvInput.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()
            if (output == longOutput.toDouble()){
                tvOutput.text = longOutput.toString()
            }else{
                tvOutput.text = output.toString()
            }
        }catch (e:Exception){
            Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
        }
    }
}
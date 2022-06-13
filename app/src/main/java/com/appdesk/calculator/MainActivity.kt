package com.appdesk.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonNumberEvent(view: View){
        val buttonSelect = view as Button
        if (isNewOperation){
            editTextShowNumber.setText("")
        }
        var buttonClickValue = editTextShowNumber.text.toString()
        isNewOperation = false
        when (buttonSelect.id){
            R.id.buttonAC-> {
                buttonClickValue = ""
            }
            R.id.button0 -> {
                buttonClickValue += "0"
            }
            R.id.button1 -> {
                buttonClickValue += "1"
            }
            R.id.button2 -> {
                buttonClickValue += "2"
            }
            R.id.button3 -> {
                buttonClickValue += "3"
            }
            R.id.button4 -> {
                buttonClickValue += "4"
            }
            R.id.button5 -> {
                buttonClickValue += "5"
            }
            R.id.button6 -> {
                buttonClickValue += "6"
            }
            R.id.button7 -> {
                buttonClickValue += "7"
            }
            R.id.button8 -> {
                buttonClickValue += "8"
            }
            R.id.button9 -> {
                buttonClickValue += "9"
            }
            R.id.buttonDot -> {
                buttonClickValue += "."
            }

            R.id.buttonAddOrMinus -> {
                buttonClickValue = "-$buttonClickValue"
            }

        }
        editTextShowNumber.setText(buttonClickValue)
    }

    private var operation = ""
    private var oldNumber = ""
    private var isNewOperation = true

    fun buttonOperationEvent (view: View){
        val buttonSelect = view as Button
        when (buttonSelect.id) {
            R.id.buttonMultiply -> {
                operation = "x"
            }
            R.id.buttonDivide -> {
                operation = "/"

            }
            R.id.buttonAdd -> {
                operation = "+"
            }
            R.id.buttonMinus -> {
                operation = "-"
            }
        }
        oldNumber = editTextShowNumber.text.toString()
        isNewOperation = true
    }

    fun buttonEqualEvent (view: View){
        val newNumber= editTextShowNumber.text.toString()
        var finalNumber:Double?=null
        when(operation){
            "x" -> {
                    finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
        }
        editTextShowNumber.setText(finalNumber.toString())
        isNewOperation = true
    }

    fun buttonPercentage(view: View){
        val number:Double = editTextShowNumber.text.toString().toDouble()/100
        editTextShowNumber.setText(number.toString())
    }



}
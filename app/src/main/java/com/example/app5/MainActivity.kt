package com.example.app5

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private var lastnumber: String? = null
    private var tvNumber: TextView? = null
    private var operator: String? = null
    private var newNumber: String? = null
    private var done: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNumber = findViewById(R.id.tvNumber)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onDigit(view: View) {
        view as Button
        if (done){
            tvNumber?.text = ""
            lastnumber = ""
            newNumber = ""
        }
        if (tvNumber?.text?.toString() == "0" && view.text == "."){
            tvNumber?.append(view.text)
            return
        }
        if (tvNumber?.text?.contains(".") == true && view.text == ".") {
            return
        }
        if (tvNumber?.text.toString() == "0") {
            tvNumber?.text = ""
        }
        tvNumber?.append(view.text)
    }


    fun onOperator(view: View) {
        view as Button
        operator = view.text.toString()
        lastnumber = tvNumber?.text.toString()
        tvNumber?.text = "0"
        if (done){
            done = false
        }
    }

    fun onEqual(view: View) {
        newNumber = tvNumber?.text.toString()
        if (lastnumber == null) {
            return
        }
        if (operator.toString() == "/") {
            val answer = lastnumber?.toFloat()?.div(newNumber!!.toFloat())
            tvNumber?.text = answer.toString()
            lastnumber = answer.toString()
        }
        if (operator.toString() == "*") {
            val answer = lastnumber?.toFloat()?.times(newNumber!!.toFloat())
            tvNumber?.text = answer.toString()
            lastnumber = answer.toString()
        }
        if (operator.toString() == "-") {
            val answer = lastnumber?.toFloat()?.minus(newNumber!!.toFloat())
            tvNumber?.text = answer.toString()
            lastnumber = answer.toString()
        }
        if (operator.toString() == "+") {
            val answer = lastnumber?.toFloat()?.plus(newNumber!!.toFloat())
            tvNumber?.text = answer.toString()
            lastnumber = answer.toString()
        }
        done = true
    }

    fun onCLS(view: View) {
        lastnumber = ""
        tvNumber?.text = "0"
        operator = ""
        newNumber = ""
        done = false
    }
    fun onNegPos(view: View) {
         if (tvNumber?.text?.startsWith("-") == true){
             tvNumber?.text = tvNumber!!.text.toString().replace("-","")
         } else {
             tvNumber?.text = "-" + tvNumber?.text.toString()
         }

    }
    fun onPercentage(view: View) {
        tvNumber?.text = tvNumber?.text.toString().toFloat().div(100).toString()
        done = true
    }


}

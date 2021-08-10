package com.example.myapplication

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.service.autofill.OnClickAction
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View

import android.widget.EditText
import android.widget.TextView
import android.widget.Button
private const val TEXT_CONTENT="TextContent"

class MainActivity : AppCompatActivity() {
    private var textView: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val userInput : EditText = findViewById<EditText>(R.id.editText)
        val button : Button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)
        textView?.text=""
        textView?.movementMethod=ScrollingMovementMethod()

        userInput.setText("")

        button?.setOnClickListener(object : View.OnClickListener {

            override fun onClick(p0 : View?) {
                textView?.append(userInput?.text)
                textView?.append("\n")
                userInput.setText("")
            }

        })


    }

    override fun onStart() {
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState?.getString(TEXT_CONTENT, "")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENT, textView?.text.toString())

    }

}
package com.bingjunior.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }

        findViewById<TextView>(R.id.name_text).setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.name_edit)
        val nameTextView = findViewById<TextView>(R.id.name_text)
        val bioTextView = findViewById<TextView>(R.id.bio_textView)
        nameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nameTextView.visibility = View.VISIBLE

        //get name from editText
        val str:String = editText.text.toString()

        //put it into textView
        bioTextView.setText("Hi, my name is $str currently, I'm pursuing my bachelor's degree in Information Technology. I'm interested in using technology to solve problems, which is why I’m studying Android Development. My primary goal for this internship is to put everything I've learned so far into practice and to develop new relationships with people who share and differ from my interests. Learn how to solve problems within a specified time frame, as well as how to deal with impending challenges and find solutions within certain deadlines. After eight weeks, all I want out of the internship is to address problems head-on, procrastinate as little as possible, and gain confidence in my abilities.\n")

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname (view: View) {
        val editText = findViewById<EditText>(R.id.name_edit)
        val doneButton = findViewById<Button>(R.id.done_button)
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Set the focus to the edit text.
        editText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}
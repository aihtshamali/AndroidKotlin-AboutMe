package com.example.kotlinandroid_aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickName(it)
            toggleTextView()
        }
        findViewById<TextView>(R.id.tv_nick_name).setOnClickListener {
            toggleTextView()
        }
    }

    private fun toggleTextView(){

            // toggle edit text view and button
            nick_name.visibility = if (nick_name.visibility.compareTo(View.GONE)==0) View.VISIBLE else View.GONE
            done_button.visibility = if (done_button.visibility.compareTo(View.GONE)==0) View.VISIBLE else View.GONE
            // toggle the nick name text view field
            tv_nick_name.visibility = if (tv_nick_name.visibility.compareTo(View.GONE)==0) View.VISIBLE else View.GONE


    }

    private fun addNickName(view: View){

        tv_nick_name.text = nick_name.text
        // close keyboard
        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken,0)
    }
}
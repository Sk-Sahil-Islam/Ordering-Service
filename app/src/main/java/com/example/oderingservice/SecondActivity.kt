package com.example.oderingservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class SecondActivity : AppCompatActivity() {
    lateinit var tvOrder : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvOrder = findViewById(R.id.items_string)

        val bundle = intent.extras
        if(bundle != null){
            tvOrder.text = bundle.getString("order")

        }
    }
}
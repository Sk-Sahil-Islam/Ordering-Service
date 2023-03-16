package com.example.oderingservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.databinding.DataBindingUtil
import com.example.oderingservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            btnSubmit.setOnClickListener{
                val bundle = Bundle()
                val checkedMeatRadioId = rgMeat.checkedRadioButtonId
                val meat = findViewById<RadioButton>(checkedMeatRadioId)
                val cheese = cbCheese.isChecked
                val onion = cbOnion.isChecked
                val salad = cbSalad.isChecked
                val orderString = meat.text.toString() +
                        (if(cheese) "\nCheese" else "") +
                        (if(onion) "\nOnion" else "") +
                        (if(salad) "\nSalad" else "")
                bundle.putString("order", orderString)
                bundle.putBoolean("cheese", cheese)
                bundle.putBoolean("onion", onion)
                bundle.putBoolean("salad", salad)

                Intent(this@MainActivity, SecondActivity::class.java).also{
                    it.putExtras(bundle)
                    startActivity(it)
                }
            }
        }


    }
}
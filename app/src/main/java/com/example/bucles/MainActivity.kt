package com.example.bucles

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtInputNumber:EditText = findViewById(R.id.edtInputNumber)
        val btnSend:Button =findViewById(R.id.btnSend)
        val tvShowInfo:TextView = findViewById(R.id.tvShowInfo)
        var attemptsMade:Int = 0

        val numberRamdonAtGuess:Int  = createNumberRamdon()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        btnSend.setOnClickListener {
            var number = edtInputNumber.text.toString().toIntOrNull()
            if (number == null){
                tvShowInfo.text = "Input a number"
            }else{
                attemptsMade++
                val message = when{
                    numberRamdonAtGuess == number -> "Felicitaciones!!! los intentos realizados son $attemptsMade"
                    else -> "No es correcto sigue intentando llevas $attemptsMade intentos"
                }
                tvShowInfo.text = message
            }
        }
    }

    private fun createNumberRamdon():Int{
        return Random.nextInt(0,10)
    }
}
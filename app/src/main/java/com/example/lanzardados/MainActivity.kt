package com.example.lanzardados

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_Lanzar : Button = findViewById(R.id.btn_Lanzar)

        btn_Lanzar.setOnClickListener{
            tiempo()
        }
        rollDice()
    }

    private fun rollDice(){

        var numero: Int=lanzar(6)
        val txtResult: TextView=findViewById(R.id.txt_resultado)
        txtResult.text=numero.toString()



        val drawableResourse = when(numero){
            1 -> R.drawable.dado__1_
            2 -> R.drawable.dado__2_
            3 -> R.drawable.dado__3_
            4 -> R.drawable.dado__4_
            5 -> R.drawable.dado__5_
            else -> R.drawable.dado__6_

        }
        val imgDado : ImageView = findViewById(R.id.imgDado)
        imgDado.setImageResource(drawableResourse)

    }
    private fun lanzar(max: Int): Int{

        return (1..max).random()
    }

    private fun tiempo(){
      object : CountDownTimer(3000, 200) {
          override fun onTick(millisUntilFinished: Long) {
            rollDice()
          }

          override fun onFinish() {
              TODO("Not yet implemented")
          }

      }.start()
    }
}
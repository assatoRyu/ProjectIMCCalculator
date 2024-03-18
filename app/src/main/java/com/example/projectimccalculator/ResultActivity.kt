package com.example.projectimccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var textWeight: TextView
    private lateinit var textHeight: TextView
    private lateinit var textResult: TextView
    private lateinit var btnNewCalc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textWeight = findViewById(R.id.text_reported_weight)
        textHeight = findViewById(R.id.text_reported_height)
        textResult = findViewById(R.id.text_result)

        val bundle = intent.extras

        if ( bundle != null ) {
            val weight = bundle.getDouble("weight")
            val height = bundle.getDouble("height")

            textWeight.text = "Peso informado: $weight kg"
            textHeight.text = "Altura informada: $height m"

            val imc = weight / (height * height)
            var resultCalc = ""

            resultCalc = if ( imc < 18.5 ) {
                     "O IMC está abaixo da média."
            } else if (imc in 18.5..24.9) {
                     "O IMC está em níveis normais."
            } else if (imc in 25.0..29.9) {
                     "Cuidado, você está em sobrepeso."
            } else {
                     "Atenção! Você está na faixa da obesidade."
            }

            textResult.text = resultCalc
        }

        btnNewCalc = findViewById(R.id.btn_new_calc)
        btnNewCalc.setOnClickListener {
            finish()
        }
    }
}
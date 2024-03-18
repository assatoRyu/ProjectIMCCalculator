package com.example.projectimccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var btn_calc: Button
    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText
    private lateinit var textInputWeight: TextInputLayout
    private lateinit var textInputHeight: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calc        = findViewById(R.id.btn_imc_calc)
        editWeight      = findViewById(R.id.edit_weight)
        editHeight      = findViewById(R.id.edit_height)
        textInputWeight = findViewById(R.id.text_input_weight)
        textInputHeight = findViewById(R.id.text_input_height)

        btn_calc.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val weight = editWeight.text.toString()
            val height = editHeight.text.toString()

            textInputWeight.error = null
            textInputHeight.error = null

            if (weight.isNotEmpty() && height.isNotEmpty()) {
                intent.putExtra("weight", weight.toDouble())
                intent.putExtra("height", height.toDouble())

                startActivity(intent)
            } else if (weight.isEmpty()) {
                textInputWeight.error = "É necessário informar o peso."
            } else if (height.isEmpty()) {
                textInputHeight.error = " É necessário informar a altura."
            }
        }
    }
}
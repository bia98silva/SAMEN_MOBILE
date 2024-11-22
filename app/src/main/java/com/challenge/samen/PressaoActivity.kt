package com.challenge.samen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class PressaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pressao)

        val tvPressaoValue: TextView = findViewById(R.id.tvPressaoValue)

        // Obter hora atual
        val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

        // Definir a pressão com base na hora
        val pressure = when {
            currentHour in 6..10 -> "120 mmHg" // Manhã
            currentHour in 11..16 -> "110 mmHg" // Tarde
            currentHour in 17..21 -> "130 mmHg" // Noite
            else -> "125 mmHg" // Madrugada
        }

        tvPressaoValue.text = "Pressão: $pressure"

        val btnVoltar: Button = findViewById(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            val intent = Intent(this,  MonitoramentoActivity::class.java)
            startActivity(intent)
        }
    }
}

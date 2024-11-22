package com.challenge.samen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class RadiacaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radiacao)

        // Referência para o TextView que vai exibir o nível de radiação
        val tvRadiacaoValue: TextView = findViewById(R.id.tvRadiacaoValue)

        // Obter hora atual
        val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

        // Definir o nível de radiação com base na hora
        val radiacao = when {
            currentHour in 6..10 -> "0.3 µSv/h" // Manhã
            currentHour in 11..16 -> "0.5 µSv/h" // Tarde
            currentHour in 17..21 -> "0.8 µSv/h" // Noite
            else -> "0.6 µSv/h" // Madrugada
        }

        // Atualizar o valor da radiação no TextView
        tvRadiacaoValue.text = "Radiação: $radiacao"

        val btnVoltar: Button = findViewById(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            val intent = Intent(this,  MonitoramentoActivity::class.java)
            startActivity(intent)
        }
    }


}

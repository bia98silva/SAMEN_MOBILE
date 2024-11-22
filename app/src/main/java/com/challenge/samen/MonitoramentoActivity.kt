package com.challenge.samen

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MonitoramentoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monitoramento)


        val nomeUsuario = intent.getStringExtra("nomeUsuario") ?: "Usuário"
        val tvSaudacao: TextView = findViewById(R.id.tvSaudacao)
        tvSaudacao.text = "Olá, $nomeUsuario"

        val btnTemperatura: LinearLayout = findViewById(R.id.btnTemperatura)
        val btnPressao: LinearLayout = findViewById(R.id.btnPressao)
        val btnRadiacao: LinearLayout = findViewById(R.id.btnRadiacao)
        val btnModificarCadastro: LinearLayout = findViewById(R.id.btnModificarCadastro)

        // Configuração dos cliques para navegar para as telas
        btnTemperatura.setOnClickListener {
            startActivity(Intent(this, TemperaturaActivity::class.java))
        }

        btnPressao.setOnClickListener {
            startActivity(Intent(this, PressaoActivity::class.java))
        }

        btnRadiacao.setOnClickListener {
            startActivity(Intent(this, RadiacaoActivity::class.java))
        }

        btnModificarCadastro.setOnClickListener {
            startActivity(Intent(this, ModificarCadastroActivity::class.java))
        }
    }
}

package com.challenge.samen


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.challenge.samen.R

class TemperaturaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TemperaturaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperatura)

        recyclerView = findViewById(R.id.recyclerViewTemperatura)

        // Configurar o RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TemperaturaAdapter(getMockData())
        recyclerView.adapter = adapter
    }

    // Dados fictícios para o exemplo
    private fun getMockData(): List<TemperaturaData> {
        return listOf(
            TemperaturaData("00:00", "35°C"),
            TemperaturaData("03:00", "36°C"),
            TemperaturaData("06:00", "34°C"),
            TemperaturaData("09:00", "37°C"),
            TemperaturaData("12:00", "38°C"),
            TemperaturaData("15:00", "39°C"),
            TemperaturaData("18:00", "36°C"),
            TemperaturaData("21:00", "35°C")
        )
    }
}

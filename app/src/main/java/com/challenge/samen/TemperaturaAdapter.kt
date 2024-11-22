package com.challenge.samen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.challenge.samen.R

class TemperaturaAdapter(private val data: List<TemperaturaData>) :
    RecyclerView.Adapter<TemperaturaAdapter.TemperaturaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemperaturaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_temperatura, parent, false)
        return TemperaturaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TemperaturaViewHolder, position: Int) {
        val item = data[position]
        holder.tvHorario.text = "Horário: ${item.horario}"
        holder.tvTemperatura.text = "Temperatura: ${item.temperatura}"
    }

    override fun getItemCount(): Int = data.size

    class TemperaturaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvHorario: TextView = view.findViewById(R.id.tvHorario)
        val tvTemperatura: TextView = view.findViewById(R.id.tvTemperatura)
    }
}

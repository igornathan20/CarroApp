package com.example.app2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarrosAdapter(
    private val carros: List<Carro>,
    private val context: Context,
    private val click: (carro: Carro, position: Int) -> Unit
) : RecyclerView.Adapter<CarrosAdapter.CarrosViewHolder>() {

    inner class CarrosViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carroName: TextView = itemView.findViewById(R.id.modeloTextView)
        val carroCompany: TextView = itemView.findViewById(R.id.marcaTextView)
        val carroImage: ImageView = itemView.findViewById(R.id.carImage)

        fun bind(carro: Carro) {
            carroName.text = carro.modelo
            carroCompany.text = carro.marca
            carroImage.setImageResource(carro.carroImage)
            itemView.setOnClickListener {
                click(carro, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrosViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return CarrosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carros.size
    }

    override fun onBindViewHolder(holder: CarrosViewHolder, position: Int) {
        val carro = carros[position]
        holder.bind(carro)
    }
}

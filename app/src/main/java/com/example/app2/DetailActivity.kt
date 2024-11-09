package com.example.app2

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras
        if (bundle != null) {
            val carros: ArrayList<Carro>? =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    bundle.getParcelableArrayList("carros", Carro::class.java)
                } else {
                    bundle.getParcelableArrayList("carros")
                }

            val position = bundle.getInt("posicao", -1)
            if(position != -1 && carros != null) {
                val carro = carros[position]

                val modelo = findViewById<TextView>(R.id.modeloTextView)
                val marca = findViewById<TextView>(R.id.marcaTextView)
                val torc = findViewById<TextView>(R.id.torcTextView)
                val potencia = findViewById<TextView>(R.id.potenciaTextView)
                val consumo = findViewById<TextView>(R.id.consumoTextView)
                val tabelaFipe = findViewById<TextView>(R.id.tabelaFipeTextView)

                findViewById<ImageView>(R.id.carroImageView).setImageResource(carro.carroImage)
                modelo.text = carro.modelo
                marca.text = carro.marca
                torc.text = carro.torc
                potencia.text = carro.potencia
                consumo.text = carro.consumo
                tabelaFipe.text = carro.tabelaFipe
            }
        }
    }
}

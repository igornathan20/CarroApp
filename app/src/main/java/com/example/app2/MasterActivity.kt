package com.example.app2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MasterActivity : AppCompatActivity() {
    

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_master)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val carros = createCarros()
        CarrosRV = findViewById(R.id.carrosRV)
        CarrosRV.adapter = CarrosAdapter(carros, this){ carro, position ->
            goNextActivity(position, ArrayList(carros))
        }
        CarrosRV.layoutManager = LinearLayoutManager(this)
        CarrosRV.setHasFixedSize(true)
        CarrosRV.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }
    private lateinit var CarrosRV: RecyclerView
    private fun createCarros(): List<Carro> {
        return listOf(
            Carro(R.drawable.brasilia, "Brasília", "Volkswagen", "65", "11,7", "9", "18.252,00"),
            Carro(R.drawable.marea, "Marea", "Fiat", "182", "27", "8.8", "36.531,00"),
            Carro(R.drawable.f40, "F40", "Ferrari", "478", "58,8", "4", "21.500.000,00"),
            Carro(R.drawable.cybertruck, "Cybertruck", "Tesla", "610", "102,8", "256 Wh/km", "1.260.000,00"),
            Carro(R.drawable.wrangler, "Wrangler", "Jeep", "272", "40,8", "7.5", "442.521,00"),
            Carro(R.drawable.t4, "T4", "Troller", "200", "47,9", "6.5", "229.483,00")
        )
    }
    private fun goNextActivity(posicao: Int, carros: ArrayList<Carro>) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putParcelableArrayListExtra("carros", carros)
        println(posicao)
        intent.putExtra("posicao", posicao)
        startActivity(intent)
    }

}
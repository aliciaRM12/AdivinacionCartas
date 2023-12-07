package com.example.adivinacioncartas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.adivinacioncartas.data.DataSet
import com.example.adivinacioncartas.databinding.ActivityJuegoBinding
import com.example.adivinacioncartas.model.Carta
import com.google.android.material.snackbar.Snackbar

class Juego : AppCompatActivity(),OnClickListener {

    private lateinit var binding: ActivityJuegoBinding
    private var nombre: String = ""
    private var puntos: Int = 0
    private lateinit var cartas: ArrayList<Carta>
    private var cartaActual: Carta? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJuegoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nombre = intent.extras?.getString("nombre").toString()
        cartas = DataSet.getAllCartas()

         val snackbar = Snackbar.make(binding.root, "Bienvenido $nombre", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("Empezar", ){
                cartaActual = cartas.random()
                binding.root.setBackgroundResource(cartaActual!!.imagen)
                binding.buttonUp.setOnClickListener(this)
                binding.buttonDown.setOnClickListener(this)
            }
            snackbar.show()
    }

    override fun onClick(v: View?) {
        val id = v?.id
        if(id == binding.buttonUp.id){
            binding.buttonUp.setImageResource(R.drawable.up_press)
            binding.buttonDown.setImageResource(R.drawable.down)
            var nuevaCarta = cartas.random()
            if(nuevaCarta.id > cartaActual!!.id){
                puntos++
                Snackbar.make(binding.root,"$puntos puntos",Snackbar.LENGTH_SHORT).show()
            }else if(nuevaCarta.id == cartaActual!!.id){
                Snackbar.make(binding.root,"Cartas iguales, lleva un total de $puntos puntos",Snackbar.LENGTH_SHORT).show()
            }else{
                binding.buttonUp.isClickable = false
                binding.buttonDown.isClickable = false
                val snackbar = Snackbar.make(binding.root,"Juego finalizado, ha conseguido $puntos puntos",Snackbar.LENGTH_INDEFINITE)
                snackbar.setAction("Volver al inicio"){
                    val intent = Intent(applicationContext,MainActivity::class.java)
                    startActivity(intent)
                }
                snackbar.show()
            }
            cartaActual = nuevaCarta
            binding.root.setBackgroundResource(cartaActual!!.imagen)
        }else if(id == binding.buttonDown.id){
            binding.buttonDown.setImageResource(R.drawable.down_press)
            binding.buttonUp.setImageResource(R.drawable.up)
            var nuevaCarta = cartas.random()
            if(nuevaCarta.id < cartaActual!!.id){
                puntos++
                Snackbar.make(binding.root,"$puntos puntos",Snackbar.LENGTH_SHORT).show()
            }else if(nuevaCarta.id == cartaActual!!.id){
                Snackbar.make(binding.root,"Cartas iguales, lleva un total de $puntos puntos",Snackbar.LENGTH_SHORT).show()
            }else{
                binding.buttonUp.isClickable = false
                binding.buttonDown.isClickable = false
                val snackbar = Snackbar.make(binding.root,"Juego finalizado, ha conseguido $puntos puntos",Snackbar.LENGTH_INDEFINITE)
                snackbar.setAction("Volver al inicio"){
                    val intent = Intent(applicationContext,MainActivity::class.java)
                    startActivity(intent)
                }
                snackbar.show()
            }
            cartaActual = nuevaCarta
            binding.root.setBackgroundResource(cartaActual!!.imagen)
        }
    }
}


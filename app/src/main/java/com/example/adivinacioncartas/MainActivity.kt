package com.example.adivinacioncartas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.adivinacioncartas.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btEmpezar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var nombre = binding.etNombre.text.toString()
        if(nombre.isNullOrEmpty()){
            Snackbar.make(binding.root, "Introducir un nombre", Snackbar.LENGTH_SHORT).show()
        }else{
            val snackbar = Snackbar.make(binding.root, "Nombre introducido correctamente", Snackbar.LENGTH_LONG)
            snackbar.setAction("OK"){
                val intent = Intent(applicationContext,Juego::class.java)
                intent.putExtra("nombre",nombre)
                startActivity(intent)
            }
            snackbar.show()
        }
    }
}

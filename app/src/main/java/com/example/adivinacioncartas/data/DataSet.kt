package com.example.adivinacioncartas.data

import com.example.adivinacioncartas.R
import com.example.adivinacioncartas.model.Carta

class DataSet{
    companion object{
        fun getAllCartas(): ArrayList<Carta>{
            val listaCartas = ArrayList<Carta>()
            listaCartas.add(Carta(1, R.drawable.c1))
            listaCartas.add(Carta(2, R.drawable.c2))
            listaCartas.add(Carta(3, R.drawable.c3))
            listaCartas.add(Carta(4, R.drawable.c4))
            listaCartas.add(Carta(5, R.drawable.c5))
            listaCartas.add(Carta(6, R.drawable.c6))
            listaCartas.add(Carta(7, R.drawable.c7))
            listaCartas.add(Carta(8, R.drawable.c8))
            listaCartas.add(Carta(9, R.drawable.c9))
            listaCartas.add(Carta(10, R.drawable.c10))
            listaCartas.add(Carta(11, R.drawable.c11))
            listaCartas.add(Carta(12, R.drawable.c12))
            listaCartas.add(Carta(13, R.drawable.c13))
            return listaCartas
        }
    }
}

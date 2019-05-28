package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity__registrar_producto.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Activity_RegistrarProducto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__registrar_producto)


        val db = room.getDatabase(this)

        btguardarproducto.setOnClickListener {



            GlobalScope.launch {
                var pro=producto(0)
                pro.precio=tvprecio.text.toString().toFloat()
                pro.nombre=tvnombre.text.toString()
                pro.cantidad=tvcantidad.text.toString().toInt()
                pro.categoria=tvcategoria.text.toString()

                db.dao().insert(pro)

            }






        }
    }
}

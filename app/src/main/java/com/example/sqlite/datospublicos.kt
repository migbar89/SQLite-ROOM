package com.example.sqlite

import android.content.Context

object datospublicos
{

    fun consultaproductos(context: Context): ArrayList<producto>{
        val db = room.getDatabase(context)
        return  db.dao().getproductos() as ArrayList<producto>

    }


}
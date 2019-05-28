package com.example.sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    var listaproducto=ArrayList<producto>()
    var db : room? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /*  var p=producto(6,"Computador1",20F,10,"Electronico1")
        var p1=producto(7,"Computador2",20F,10,"Electronico2")
        var p2=producto(8,"Computador3",20F,10,"Electronico3")
        var p3=producto(9,"Computador4",20F,10,"Electronico4")
        var p4=producto(10,"Computador5",20F,10,"Electronico5")
*/


        db = room.getDatabase(this)

        GlobalScope.launch {
           /* db.dao().insert(p)
            db.dao().insert(p1)
            db.dao().insert(p2)
            db.dao().insert(p3)
            db.dao().insert(p4)
*/
            listaproducto= db!!.dao().getproductos() as ArrayList<producto>

        }






    btcargar.setOnClickListener {


       // Toast.makeText(applicationContext,datospublicos.consultaproductos(applicationContext).size.toString(),Toast.LENGTH_SHORT).show()
        recycleproducto.layoutManager=LinearLayoutManager(applicationContext,LinearLayout.VERTICAL,false)
        var adapter=adapterproducto(listaproducto)
        recycleproducto.adapter=adapter

    }


        btinsertar.setOnClickListener {
           var intent =Intent(this,Activity_RegistrarProducto::class.java)
            startActivity(intent)

        }









    }

    fun insertar()
    {

    }

    override fun onRestart() {
        super.onRestart()
        GlobalScope.launch {
            /* db.dao().insert(p)
             db.dao().insert(p1)
             db.dao().insert(p2)
             db.dao().insert(p3)
             db.dao().insert(p4)
 */
            listaproducto= db?.dao()?.getproductos() as ArrayList<producto>

        }

    }
}

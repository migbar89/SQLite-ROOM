package com.example.sqlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemrecycleproductos.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class adapterproducto(val listaproducto:ArrayList<producto>):RecyclerView.Adapter<adapterproducto.Viewholder>()
{
    private var db: room? = null


    class Viewholder(itemview: View):RecyclerView.ViewHolder(itemview)
    {
        val tvnombre:TextView=itemview.tvnombre
        val tvprecio:TextView=itemview.tvprecio
        val tvcantidad:TextView=itemview.tvcantidad
        var delete:ImageView=itemview.imagedelete
        private var db: room? = null

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): adapterproducto.Viewholder
    {
        val v=LayoutInflater.from(p0.context).inflate(R.layout.itemrecycleproductos,p0,false)
        return Viewholder(v)
    }
    override fun getItemCount(): Int {
       return listaproducto.size
    }
    override fun onBindViewHolder(p0: adapterproducto.Viewholder, p1: Int) {
        p0.tvnombre.setText(listaproducto.get(p1).nombre)
        p0.tvprecio.setText(listaproducto.get(p1).precio.toString())
        p0.tvcantidad.setText(listaproducto.get(p1).cantidad.toString())

        db=room.getDatabase(p0.itemView.context)

        p0.delete.setOnClickListener {

           // Toast.makeText(p0.itemView.context,"Evento click="+p1.toString(),Toast.LENGTH_SHORT).show()
          //  var pro=listaproducto[p1]
            //listaproducto.removeAt(p1)
            Toast.makeText(p0.itemView.context,"Elemento Eliminado Correctamente",Toast.LENGTH_SHORT).show()

            GlobalScope.launch{

                db!!.dao().deleteproducto(listaproducto[p1])

            }
            notifyDataSetChanged()

        }


        p0.itemView.setOnClickListener {
            Toast.makeText(p0.itemView.context,"Evento Click",Toast.LENGTH_SHORT).show()
        }
     }
}
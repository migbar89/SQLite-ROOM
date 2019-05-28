package com.example.sqlite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "producto")
class producto(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int)
{
    @ColumnInfo(name = "nombre")  var nombre:String? = null
    @ColumnInfo(name = "precio")  var precio:Float? = null
    @ColumnInfo(name = "cantidad")  var cantidad:Int? = null
    @ColumnInfo(name = "categoria")  var categoria:String? = null

}
package com.example.sqlite
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Daoproducto {
    @Query("SELECT * from producto")
    fun getproductos(): List<producto>

    @Insert
    suspend fun insert(producto: producto)

    @Query("DELETE FROM producto")
    fun deleteAll()
    @Delete
    fun deleteproducto(producto: producto)
}